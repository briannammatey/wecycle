
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


//retrieve weather data from API
public class WeatherAPI {


    public static JSONObject getWeatherData(String locationName) {
        JSONArray locationData = getLocationData(locationName);
        if (locationData == null || locationData.isEmpty()) {
            System.out.println("Error: Could not find location.");
            return null;
        }

        JSONObject location = (JSONObject) locationData.get(0);
        double latitude = (double) location.get("latitude");
        double longitude = (double) location.get("longitude");

        String urlString = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&current=temperature_2m,relative_humidity_2m,is_day,weather_code,wind_speed_10m&hourly=temperature_2m,weather_code,relative_humidity_2m,wind_speed_10m&temperature_unit=fahrenheit&timezone=America%2FNew_York";
        try {
            HttpURLConnection conn = fetchApiResponse(urlString);
            if (conn == null || conn.getResponseCode() != 200) {
                System.out.println("Error: Could not connect to API");
                return null;
            }

            StringBuilder resultJson = new StringBuilder();
            Scanner scanner = new Scanner(conn.getInputStream());
            while (scanner.hasNext()) {
                resultJson.append(scanner.nextLine());
            }
            scanner.close();
            conn.disconnect();

            JSONParser parser = new JSONParser();
            JSONObject resultJsonObj = (JSONObject) parser.parse(resultJson.toString());
            JSONObject hourly = (JSONObject) resultJsonObj.get("hourly");

            JSONObject current=(JSONObject) resultJsonObj.get("current");



            // Debugging output
            //System.out.println("Hourly data: " + hourly);

            JSONArray time = (JSONArray) hourly.get("time");
            int index = findIndexOfCurrentTime(time);

            JSONArray temperatureData = (JSONArray) hourly.get("temperature_2m");
            double temperature = (double) temperatureData.get(index);


            // Debugging output
            //System.out.println("Weather code data: " + hourly.get("weather_code"));

            JSONArray weatherCodeData = (JSONArray) hourly.get("weather_code");
            if (weatherCodeData == null) {
                System.out.println("Error: Weather code data is null.");
                return null;
            }

            String weatherCondition = convertWeatherCode((long) weatherCodeData.get(index));

            JSONArray relativeHumidityData = (JSONArray) hourly.get("relative_humidity_2m");
            long humidity = (long) relativeHumidityData.get(index);

            JSONArray windSpeedData = (JSONArray) hourly.get("wind_speed_10m");
            double windSpeed = (double) windSpeedData.get(index);

            String timeString = time.get(index).toString();

            String realTime = (String) current.get("time");
            //String realTimeString = realTime.get(index).toString();

            JSONObject weatherData = new JSONObject();
            weatherData.put("temperature", temperature);
            weatherData.put("weather_condition", weatherCondition);
            weatherData.put("humidity", humidity);
            weatherData.put("wind_speed", windSpeed);
            weatherData.put("time", timeString);
            weatherData.put("real_time", realTime);

            return weatherData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static JSONArray getLocationData(String locationName){
        //replace any white space in location name to + to adhere to API's request format
        locationName = locationName.replaceAll(" ", "+");

        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name="+ locationName+ "&count=10&language=en&format=json";
        try{
            //call API to get a response
            HttpURLConnection conn = fetchApiResponse(urlString);
            if(conn==null||conn.getResponseCode()  != 200){
                System.out.println("Error: Could not connect to API");
                return null;
            }else{
                //store
                StringBuilder resultJson = new StringBuilder();
                Scanner scanner = new Scanner(conn.getInputStream());

                //read and store in string  builder
                while(scanner.hasNext()){
                    resultJson.append(scanner.nextLine());
                }
                //close scanner
                scanner.close();

                //close url connection
                conn.disconnect();

                //parse the JSON string into JSO obj
                JSONParser parser = new JSONParser();
                JSONObject resultsJsonObj = (JSONObject) parser.parse(resultJson.toString());
                //get the list of location data
                //JSONArray locationData = (JSONArray) resultsJsoObj.get("results");
                //return locationData;
                return (JSONArray) resultsJsonObj.get("results");

            }


        }catch(Exception e){
            e.printStackTrace();

        }
    return null;

    }
    private static HttpURLConnection fetchApiResponse(String urlString){
        try{
            URL url = new URL(urlString);
            //call api and get a response
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //check response status
            //200 mens good connection


            conn.setRequestMethod("GET");
            conn.connect();
            return conn;
        }catch(IOException e){
            e.printStackTrace();
        }
        //could not make connection
        return null;
    }


    private static int findIndexOfCurrentTime(JSONArray timeList){
        String currentTime = getCurrentTime();
        //iterate the time list and see which one matches our currebt time

        for(int i = 0; i < timeList.size(); i++){
            String time=(String)timeList.get(i);
            if(time.equalsIgnoreCase(currentTime)){
                return i;
            }
        }
        return 0;
    }
    public static String getCurrentTime(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        //format data to get current time 2023-09-02T00:00
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH':00'");

        //format and print current date and time

        return  currentDateTime.format(formatter);
    }

    //convert the weather code to something more readable
    private static String convertWeatherCode(long weatherCode){

        if(weatherCode == 0L){
            return  "Clear";
        }else if(weatherCode <= 3L && weatherCode > 0L){
            return "Cloudy";

        }else if(weatherCode >= 51L && weatherCode <= 67L || (weatherCode >= 80L && weatherCode <=99L)){
                //return
            return "Rain";

        }else if(weatherCode >= 71L && weatherCode <= 77L){
           //snow
           return "Snow";

        }
        return "Unknown";
    }







    public static void main(String[] args) {



    }

}
