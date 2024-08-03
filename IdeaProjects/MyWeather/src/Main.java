import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    private JSONObject weatherData;

    public Main() {
        // Create the frame
        JFrame frame = new JFrame();
        frame.setSize(600, 800);
        frame.setTitle("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Set the background color of the content pane
        frame.getContentPane().setBackground(Color.CYAN);

        // Set layout manager to null for custom positioning
        frame.setLayout(null);

        // Create and configure the JLabel for weather icon
        JLabel label = new JLabel(loadImage("src/images/sunny.png"));
        label.setBounds(30, 160, 500, 300);

        // Create the input text field
        JTextField text = new JTextField();
        text.setFont(new Font("Tahoma", Font.PLAIN, 16));
        text.setBounds(34, 40, 351, 40);
        text.setBackground(Color.LIGHT_GRAY);

        // Create labels for displaying weather information
        JLabel tempText = new JLabel("10 F");
        tempText.setFont(new Font("Tahoma", Font.BOLD, 40));
        tempText.setBounds(240, 430, 450, 40);
        tempText.setForeground(Color.GRAY);

        JLabel weatherCondition = new JLabel("Cloudy");
        weatherCondition.setFont(new Font("Tahoma", Font.ITALIC, 30));
        weatherCondition.setBounds(236, 475, 450, 40);
        weatherCondition.setForeground(Color.PINK);

        JLabel humidity = new JLabel(loadImage("src/images/ drop.png"));
        humidity.setBounds(30, 600, 74, 66);

        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(96, 600, 74, 66);
        humidityText.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel windSpeed = new JLabel(loadImage("src/images/wind.png"));
        windSpeed.setBounds(450, 600, 74, 66);

        JLabel windSpeedText = new JLabel("<html><b>Wind</b> 100%</html>");
        windSpeedText.setFont(new Font("Tahoma", Font.BOLD, 14));
        windSpeedText.setBounds(530, 600, 74, 66);

        JLabel time = new JLabel("<html><b>12:34</b> </html>");
        time.setFont(new Font("Tahoma", Font.BOLD, 36));
        time.setBounds(245, 580, 120, 100);

        // Add components to the frame
        frame.add(time);
        frame.add(windSpeedText);
        frame.add(windSpeed);
        frame.add(humidityText);
        frame.add(tempText);
        frame.add(text);
        frame.add(weatherCondition);
        frame.add(label);
        frame.add(humidity);

        // Create the search button
        JButton button = new JButton(loadImage("src/images/search.png"));
        button.setBounds(380, 35, 45, 45);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = text.getText();
                // Validate input - remove whitespace
                if (userInput.replaceAll("\\s", "").length() <= 0) {
                    return;
                }

                // Retrieve weather data
                weatherData = WeatherAPI.getWeatherData(userInput);
                if (weatherData == null) {
                    JOptionPane.showMessageDialog(frame, "Error: Could not retrieve weather data.");
                    return;
                }

                // Update GUI with retrieved weather data
                String weatherConditioner = (String) weatherData.get("weather_condition");
                switch (weatherConditioner) {
                    case "Clear":
                        label.setIcon(loadImage("src/images/sunny.png"));
                        frame.getContentPane().setBackground(Color.CYAN);
                        break;
                    case "Cloudy":
                        label.setIcon(loadImage("src/images/cloudy.png"));
                        frame.getContentPane().setBackground(Color.DARK_GRAY);
                        break;
                    case "Rain":
                        label.setIcon(loadImage("src/images/rain.png"));
                        frame.getContentPane().setBackground(Color.BLUE);
                        break;
                    case "Snow":
                        label.setIcon(loadImage("src/images/snow.png"));
                        frame.getContentPane().setBackground(Color.WHITE);
                        break;

                    default:
                        label.setIcon(loadImage("src/images/sunny.png"));
                        frame.getContentPane().setBackground(Color.CYAN);
                        break;
                }

                double temperature = (double) weatherData.get("temperature");
                tempText.setText(temperature + " F");

                weatherCondition.setText(weatherConditioner);

                long humidityValue = (long) weatherData.get("humidity");
                humidityText.setText("<html><b>Humidity</b> " + humidityValue + "%</html>");

                double windSpeedValue = (double) weatherData.get("wind_speed");
                windSpeedText.setText("<html><b>Wind</b> " + windSpeedValue + " mph</html>");

                String timeValue = (String) weatherData.get("real_time");
                timeValue= timeValue.substring(11);
                time.setText("<html><b>" + timeValue + "</b></html>");
            }
        });

        frame.add(button);
        frame.setVisible(true);
    }

    private ImageIcon loadImage(String resourcePath){
        try{
            // read the image file from the path given
            BufferedImage image= ImageIO.read(new File(resourcePath));
            // returns an image so that our component can render it
            return new ImageIcon(image);
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Couldn't find resource");
        return null;
    }


    public static void main(String[] args) {
        // Create an instance of Main to show the GUI


    }
}