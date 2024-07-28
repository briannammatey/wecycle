import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.lang.Thread;

public class Food {

    public static void playAgain(){
        
        System.out.println("Would you like to go back to Food menu");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int optionOf=Health.getInput(2);
        
        if(optionOf==1){
            thirdOption();;
        }
    }


    public static void typeWriter(String str){
        for(int i =0; i<str.length(); i++){
            System.out.print(str.charAt(i));
            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }



    public static void thirdOption(){
        System.out.println("***************************");
        System.out.println("Welcome to your Food Plan");
        System.out.println("*****************************");
        Scanner beginNow= new Scanner(System.in);
       
        System.out.println("Press 7 to begin");
        if(beginNow.nextInt()==7){
        System.out.println("So happy that you are here to join us");
        System.out.println("Pick an option by entering a number");
        System.out.println("1. Normal Food Guide");
        System.out.println();
        System.out.println("2.Vegan Friendly Food guide");
        System.out.println();
        System.out.println("3 PCOS Friendly guide");
        System.out.println();
        System.out.println("4. Enter your daily Food plan for today");
        System.out.println();
        int choice =Health.getInput(4);
        if(choice ==1){
            System.out.println("**Welcome to your Normal Food Gude!**");

            String str="Achieving the best diet involves balancing nutrient-dense foods to support overall health, maintain energy levels, and prevent chronic diseases. Here’s a comprehensive description of what constitutes the best diet:\n" + //
                                "\n" + //
                                "1. Variety of Fruits and Vegetables\n" + //
                                "Goal: Aim for at least 5 servings per day, including a variety of colors and types.\n" + //
                                "Benefits: Provides essential vitamins, minerals, fiber, and antioxidants.\n" + //
                                "2. Whole Grains\n" + //
                                "Goal: Make at least half of your grain intake whole grains.\n" + //
                                "Benefits: Rich in fiber, B vitamins, and minerals. Helps in digestion and maintaining a healthy weight.\n" + //
                                "Examples: Whole wheat bread, brown rice, quinoa, oatmeal.\n" + //
                                "3. Lean Proteins\n" + //
                                "Goal: Include a source of lean protein in every meal.\n" + //
                                "Benefits: Supports muscle growth and repair, and provides essential amino acids.\n" + //
                                "Examples: Chicken, turkey, fish, beans, lentils, tofu, Greek yogurt.\n" + //
                                "4. Healthy Fats\n" + //
                                "Goal: Incorporate healthy fats while limiting saturated and trans fats.\n" + //
                                "Benefits: Essential for brain health, hormone production, and absorbing fat-soluble vitamins.\n" + //
                                "Examples: Avocados, nuts, seeds, olive oil, fatty fish like salmon.\n" + //
                                "5. Adequate Hydration\n" + //
                                "Goal: Drink at least 8 glasses of water per day, more if you are active.\n" + //
                                "Benefits: Maintains bodily functions, aids digestion, and helps maintain energy levels.\n" + //
                                "6. Moderation and Portion Control\n" + //
                                "Goal: Be mindful of portion sizes and avoid overeating.\n"
                                +
                                "Benefits: Helps maintain a healthy weight and prevents overconsumption of calories.\n" + //
                                "7. Limited Processed Foods and Added Sugars\n" + //
                                "Goal: Minimize intake of processed foods, sugary snacks, and beverages.\n" + //
                                "Benefits: Reduces the risk of chronic diseases like diabetes and heart disease.\n" + //
                                "Examples to Avoid: Sugary drinks, fast food, and processed snacks.\n" + //
                                "8. Regular Meal Timing\n" + //
                                "Goal: Eat regular meals and snacks to maintain energy levels throughout the day.\n" + //
                                "Benefits: Helps regulate blood sugar levels and prevents overeating.\n" + //
                                "";
            typeWriter(str);


        }else if(choice==2){


            System.out.println(" **Welcome to your Vegan Friendly Food Guide! **");
            String strTwo ="\n" + //
                                
                                "The Best Vegan Diet for Optimal Health\n" + //
                                "Adopting a vegan diet involves carefully balancing plant-based foods to ensure you receive all the necessary nutrients for optimal health, energy, and disease prevention. Here’s a comprehensive guide to achieving the best vegan diet:\n" + //
                                "\n" + //
                                "1. Variety of Fruits and Vegetables\n" + //
                                "Goal: Aim for at least 5 servings per day, including a variety of colors and types.\n" + //
                                "Benefits: Provides essential vitamins, minerals, fiber, and antioxidants.\n" + //
                                "Examples: Leafy greens, berries, citrus fruits, bell peppers, carrots.\n" + //
                                "2. Whole Grains\n" + //
                                "Goal: Make at least half of your grain intake whole grains.\n" + //
                                "Benefits: Rich in fiber, B vitamins, and minerals. Helps in digestion and maintaining a healthy weight.\n" + //
                                "Examples: Brown rice, quinoa, whole wheat bread, oatmeal, barley.\n" + //
                                "3. Plant-Based Proteins\n" + //
                                "Goal: Include a source of plant-based protein in every meal.\n" + //
                                "Benefits: Supports muscle growth and repair, and provides essential amino acids.\n" + //
                                "Examples: Legumes (beans, lentils, chickpeas), tofu, tempeh, edamame, seitan, quinoa.\n" + //
                                "4. Healthy Fats\n" + //
                                "Goal: Incorporate healthy fats while limiting saturated and trans fats.\n" + //
                                "Benefits: Essential for brain health, hormone production, and absorbing fat-soluble vitamins.\n" + //
                                "Examples: Avocados, nuts (almonds, walnuts), seeds (chia, flax, hemp), olive oil, nut butters.\n" + //
                                "5. Adequate Hydration\n" + //
                                "Goal: Drink at least 8 glasses of water per day, more if you are active.\n" + //
                                "Benefits: Maintains bodily functions, aids digestion, and helps maintain energy levels.\n" + //
                                "Examples: Water, herbal teas, infused water with fruits or herbs.\n" + //
                                "6. Moderation and Portion Control\n" + //
                                "Goal: Be mindful of portion sizes and avoid overeating.\n" + //
                                "Benefits: Helps maintain a healthy weight and prevents overconsumption of calories.\n" + //
                                "Tips: Use smaller plates, and listen to your body's hunger and fullness cues.\n" + //
                                "7. Limited Processed Foods and Added Sugars\n" + //
                                "Goal: Minimize intake of processed foods, sugary snacks, and beverages.\n" + //
                                "Benefits: Reduces the risk of chronic diseases like diabetes and heart disease.\n" + //
                                "Examples to Avoid: Sugary drinks, vegan junk food, and highly processed snacks.\n" + //
                                "8. Regular Meal Timing\n" + //
                                "Goal: Eat regular meals and snacks to maintain energy levels throughout the day.\n" + //
                                "Benefits: Helps regulate blood sugar levels and prevents overeating.\n" + //
                                "Tips: Plan meals and snacks to avoid long periods without eating.\n" + //
                                "Sample Daily Vegan Meal Plan\n" + //
                                "Breakfast:\n" + //
                                "\n" + //
                                "Smoothie with spinach, banana, almond milk, chia seeds, and a scoop of plant-based protein powder.\n" + //
                                "Mid-Morning Snack:\n" + //
                                "\n" + //
                                "Apple slices with almond butter.\n" + //
                                "Lunch:\n" + //
                                "\n" + //
                                "Quinoa bowl with black beans, corn, bell peppers, avocado, and a lime-cilantro dressing.\n" + //
                                "Afternoon Snack:\n" + //
                                "\n" + //
                                "Carrot sticks with hummus.\n" + //
                                "Dinner:\n" + //
                                "\n" + //
                                "Stir-fried tofu with mixed vegetables (bell peppers, snap peas, carrots) served over brown rice.\n" + //
                                "Evening Snack (if needed):\n" + //
                                "\n" + //
                                "A small handful of nuts or a piece of dark chocolate (70% cocoa or higher).\n" + //
                                "Tips for Maintaining the Best Vegan Diet\n" + //
                                "Variety is Key: Ensure you eat a wide range of fruits, vegetables, grains, and protein sources to get a variety of nutrients.\n" + //
                                "Supplement Wisely: Consider supplements for nutrients that are harder to obtain from a vegan diet, such as vitamin B12, vitamin D, omega-3 fatty acids (DHA and EPA), iron, calcium, and zinc.\n" + //
                                "Read Labels: Be aware of added sugars, unhealthy fats, and processed ingredients in vegan products.\n" + //
                                "Plan Meals: Prepare meals in advance to ensure you have healthy options available.\n" + //
                                "Listen to Your Body: Pay attention to hunger and fullness cues to avoid overeating or undereating.\n" + //
                                "Personalized Approach\n" + //
                                "The best vegan diet can vary depending on individual needs and preferences. Factors such as age, gender, activity level, and health conditions should be considered. Consulting with a registered dietitian can provide personalized guidance to optimize your diet based on your specific needs.\n" + //
                                "\n" + //
                                "By focusing on a variety of nutrient-dense plant-based foods, staying hydrated, and maintaining balanced meals, y";

                                typeWriter(strTwo);


        }else if(choice ==3){
            System.out.println("**Welcome to your PCOS Friendly Food guide**");


            String strThree="Creating a PCOS-friendly food plan involves focusing on foods that help manage insulin levels, promote hormone balance, and support overall health. Here are some general guidelines for a PCOS-friendly food plan:\n" + //
                                "\n" + //
                                "Complex Carbohydrates: Opt for whole grains like brown rice, quinoa, whole wheat, oats, and barley. These have a lower glycemic index, which helps in managing insulin levels.\n" + //
                                "\n" + //
                                "Lean Proteins: Include lean protein sources such as chicken, turkey, fish, tofu, legumes (like beans and lentils), and eggs. Protein helps stabilize blood sugar levels and supports muscle health.\n" + //
                                "\n" + //
                                "Healthy Fats: Incorporate sources of healthy fats such as avocados, nuts (like almonds and walnuts), seeds (flaxseeds, chia seeds), and olive oil. These fats support hormone production and reduce inflammation.\n" + //
                                "\n" + //
                                "Fruits and Vegetables: Aim for a variety of colorful fruits and vegetables, which provide essential vitamins, minerals, and antioxidants. Berries, leafy greens, broccoli, and bell peppers are excellent choices.\n" + //
                                "\n" + //
                                "Dairy Alternatives: Consider dairy alternatives like almond milk or coconut milk, as dairy products can sometimes aggravate symptoms in some individuals with PCOS.\n" + //
                                "\n" + //
                                "Limit Sugars and Processed Foods: Minimize intake of refined sugars, sugary drinks, and processed foods. These can spike insulin levels and contribute to hormonal imbalance.\n" + //
                                "\n" + //
                                "Balanced Meals: Plan meals that combine complex carbohydrates, lean proteins, healthy fats, and plenty of vegetables to help maintain stable blood sugar levels throughout the day.\n" + //
                                "\n" + //
                                "Hydration: Drink plenty of water throughout the day to stay hydrated and support overall health.\n" + //
                                "\n" + //
                                "Moderate Portions: Pay attention to portion sizes to manage calorie intake and support weight management, which is important for PCOS management.\n" + //
                                "\n" + //
                                "Regular Meals: Try to eat regular meals and avoid skipping meals, as this can help stabilize blood sugar levels and reduce cravings.";

                                typeWriter(strThree);
                                
                                System.out.println("Foods to Avoid");
                                
                                
                                String strFour="Foods to Avoid: High Glycemic Index Carbohydrates: Foods that quickly raise blood sugar levels should be limited. Examples include white bread, white rice, sugary cereals, and baked goods made with refined flour.\n" + //
                                                                        "\n" + //
                                                                        "Sugary Foods and Beverages: Reduce intake of sugary drinks such as sodas, sweetened juices, energy drinks, and desserts like cakes, cookies, and candies.\n" + //
                                                                        "\n" + //
                                                                        "Processed Foods: Minimize consumption of processed foods high in trans fats, unhealthy oils, and additives. These include fast food, packaged snacks, and frozen meals.\n" + //
                                                                        "\n" + //
                                                                        "Dairy Products: Some individuals with PCOS find that dairy products can aggravate symptoms. Consider reducing intake of milk, cheese, and yogurt, or opt for dairy alternatives like almond milk or coconut milk.\n" + //
                                                                        "\n" + //
                                                                        "Red Meat: Limit intake of red meat, especially processed meats like sausages and bacon, as they may contribute to inflammation.\n" + //
                                                                        "\n" + //
                                                                        "Soy Products: While not universally problematic, some women with PCOS may experience hormonal disruptions from consuming large amounts of soy products. Moderation is key.\n" + //
                                                                        "\n" + //
                                                                        "Alcohol: Limit alcohol consumption, as it can affect hormone levels and liver function, which is important for hormone metabolism.\n" + //
                                                                        "\n" + //
                                                                        "Caffeine: Excessive caffeine intake can disrupt hormone balance and affect sleep patterns. Opt for moderation and consider herbal teas as alternatives.\n" + //
                                                                        "\n" + //
                                                                        "Artificial Sweeteners: Some artificial sweeteners may impact insulin sensitivity and gut health. Consider minimizing their use or opting for natural sweeteners like stevia or honey in moderation.\n" + //
                                                                        "\n" + //
                                                                        "Highly Processed Vegetable Oils: Minimize consumption of oils like soybean oil, corn oil, and vegetable oil, which are high in omega-6 fatty acids and may contribute to inflammation.\n" + //
                                                                        "\n" + //
                                                                        "Personalization:\n" + //
                                                                        "Remember, individual responses to food can vary, so it's essential to pay attention to how your body reacts to different foods and adjust your diet accordingly. Working with a registered dietitian who specializes in PCOS can provide personalized guidance and help you develop a diet plan that best suits your needs and goals";
                                                                        typeWriter(strFour);

                                                                    }else{
                                                                        String mealName;
                                                                        Scanner scanner= new Scanner(System.in);
                                                                        HashMap<String, List<String>> meals = new HashMap<>();

                                                                        while (true) {
            System.out.println("Please enter your food plan for today (Press Enter after each meal, type 'done' to finish):");
                System.out.println("Welcome to your daily food plan tracker");
                
                    System.out.print("Meal name: ");
                    mealName = scanner.nextLine();
                    if (mealName.equalsIgnoreCase("done")) {
                        break;
                    }
                    System.out.print("Ingredients (separated by commas): ");
                    String foodsInput = scanner.nextLine();
                    List<String> foods = new ArrayList<>(Arrays.asList(foodsInput.split(",")));
                    meals.put(mealName, foods);
                }

                // Displaying the entered food plan
                System.out.println("Your food plan for today:");
                for (String meal : meals.keySet()) {
                    System.out.println("- " + meal + ": " + meals.get(meal));
                }


        }
    



        }else{

        }

    
        playAgain();
    }


    public static void main(String[] args) {
      
        }


        }