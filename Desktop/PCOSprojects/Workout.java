import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class Workout {
     
    public static void playAgain(){
        
        System.out.println("Would you like to run your workout again");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int optionOf=Health.getInput(2);
        
        if(optionOf==1){
            secondOption();
        }


    }
    
    
    
    public static void secondOption(){
        
        System.out.println(" ****Welcome to your workout plan! ***");
        System.out.println("We will print out a random amount of workouts for you to do ");
        Mental.meditation(1);

        //General selections
        System.out.println("What workout do you want to focus on?");
        System.out.println("1)Full body");
        System.out.println();
        System.out.println("2) Legs");
        System.out.println();
        System.out.println("3)Arms/UpperBody");

        
        //int official=optionOne.nextInt();
        //Full Body Selection
        int official=Health.getInput(3);
        if(official==1){
            
       
        System.out.println("What is your expertise level?");
        System.out.println("1) Beginner");
        System.out.println();
        System.out.println("2) Intermediate");
        System.out.println();
        System.out.println("3) Expert");






        int beginning=Health.getInput(3);
        //Full Body Beginner
        if(beginning==1){
                
            Stack<String> newStack = new Stack<String>();
        
            String[] array={"Push-ups: 3 sets of 10-15 reps","Goblet Squats: 3 sets of 10-12 reps","Band Pull-aparts: 3 sets of 15-20 reps","Jumping Jacks: 3 sets of 30 seconds","Bodyweight Squats: 3 sets of 15-20 reps","Dumbbell Bench Press: 3 sets of 10-12 reps", "Kettlebell Deadlifts: 3 sets of 10-12 reps", "Medicine Ball Slams: 3 sets of 12-15 reps", "Supermans - 3 sets of 12 repetitions","Bodyweight Squats - 3 sets of 12 repetitions", "Push-ups: 3 sets of 10-15 reps", "Jumping Jacks: 3 sets of 30 seconds" };
        
        
            int number=5;
            int counter=0;
            while(counter<number){
                Random randNumber= new Random();
                int randomNumber= randNumber.nextInt(array.length);
                newStack.push(array[randomNumber]);
                counter++;
            }
            System.out.println("Today's Full Body Beginner workout is");
            while(!newStack.isEmpty()){
           
                System.out.println();
            
                System.out.println(newStack.peek());
                newStack.pop();
                System.out.println();

            }
        
                
        }else if(beginning==2){
        //Full Body Intermediate


            Stack<String> newStack = new Stack<String>();
        
            String[] array={"Pike Push-ups - 3 sets of 12 repetitions","Split Squats (Bulgarian Split Squats) - 3 sets of 12 repetitions per leg","Diamond Push-ups - 3 sets of 10 repetitions","Lateral Lunges - 3 sets of 12 repetitions per leg","Plank with Shoulder Taps - 3 sets of 20 taps (10 per side)","Single Leg Glute Bridges - 3 sets of 12 repetitions per leg", "Decline Push-ups - 3 sets of 10 repetitions", "Inchworms - 3 sets of 10 repetitions", "Side Plank with Hip Dip (Left and Right Side) - 3 sets of 15 dips (per side)","Bodyweight Squats - 3 sets of 12 repetitions", "Box Jumps (or Alternating Jump Lunges) - 3 sets of 12 repetitions", "Hollow Body Hold - 3 sets of 30 seconds hold", 
            "Inverted Rows (using a sturdy table or horizontal bar) - 3 sets of 10-12 repetitions"};
        
        
            int number=5;// user will input number
            int counter=0;
            while(counter<number){
                Random randNumber= new Random();
                int randomNumber= randNumber.nextInt(array.length);
                newStack.push(array[randomNumber]);
                counter++;
            }
            System.out.println("Today's Full Body Intermediate workout is");
            while(!newStack.isEmpty()){
           
                System.out.println();
            
                System.out.println(newStack.peek());
                newStack.pop();
                System.out.println();
            
            }
               
                
        }else{

        //Full Body Expert

            Stack<String> newStack = new Stack<String>();
        
                String[] array = {
                    "Handstand Push-ups - 4 sets of 6-8 repetitions",
                    "Pistol Squats - 4 sets of 8-10 repetitions per leg",
                    "One-Arm Push-ups - 4 sets of 6-8 repetitions per arm",
                    "Front Lever Progression - 4 sets of 10-15 seconds hold",
                    "Dragon Flags - 4 sets of 6-8 repetitions",
                    "Muscle-ups (or Assisted Muscle-ups) - 4 sets of 4-6 repetitions",
                    "L-sit to Handstand (or L-sit to Tuck Planche) - 4 sets of 10-15 seconds hold",
                    "Bulgarian Split Squats with Rear Foot Elevated - 4 sets of 10-12 repetitions per leg",
                    "Tuck Planche - 4 sets of 10-15 seconds hold",
                    "Shrimp Squats - 4 sets of 6-8 repetitions per leg",
                    "Planche Push-ups - 4 sets of 5-8 repetitions",
                    "L-sit Pull-ups - 4 sets of 6-8 repetitions",
                    "Back Lever - 4 sets of 10-15 seconds hold",
                    "Tuck Front Lever Rows - 4 sets of 6-8 repetitions",
                    "Dragon Pistol Squats - 4 sets of 6-8 repetitions per leg",
                    "Human Flag - 4 sets of 10-15 seconds hold per side"
                };
        
            int number=5;// user will input number
            int counter=0;
            while(counter<number){
                Random randNumber= new Random();
                int randomNumber= randNumber.nextInt(array.length);
                newStack.push(array[randomNumber]);
                counter++;
            }
            System.out.println("Today's Full Body Expert workout is");
            while(!newStack.isEmpty()){
           
                System.out.println();
            
                System.out.println(newStack.peek());
                newStack.pop();
                System.out.println();
            
            }
               

                
        }
           
        }else if(official==2){
         //Leg workout
       
        System.out.println("What is your expertise level?");
        System.out.println("1) Beginner");
        System.out.println("2) Intermediate");
        System.out.println("3) Expert");

        int beginningTwo=Health.getInput(3);
            if(beginningTwo==1){
                Stack<String> newStack = new Stack<String>();
                String[] array={

            //leg beginner workout
            "BodyWeight Squats: 3 sets of 10-15 reps",
            "Lunges: 3 sets of 10-12 reps (each leg)",
            "Glute bridges: 3 sets of 15 reps",
            "Step Ups: 3 sets of 10",
            "Calf Raises - 3 sets of 20 repetitions",
            "Wall Sit - Hold for 30-45 seconds, repeat 3 times",
            "Side Leg Raises - 3 sets of 15 repetitions per leg",
            "Single Leg Deadlifts - 3 sets of 12 repetitions per leg",
            "High Knees - 3 sets of 30 seconds (perform continuously)",
            "Chair Squats - 3 sets of 15 repetitions",
            "Mountain Climbers - 3 sets of 20 repetitions (10 per leg)",
            "Wall Sit - Hold for 30-45 seconds, repeat 3 times",
            "Side Leg Raises - 3 sets of 15 repetitions per leg",
            "Bodyweight Squats - 3 sets of 12 repetitions",
            "Reverse Lunges with Knee Raise - 3 sets of 12-15 repetitions per leg",
            "Skater Hops - 3 sets of 10-12 repetitions per side"
                };
                int number=5;// user will input number
                int counter=0;
                while(counter<number){
                    Random randNumber= new Random();
                    int randomNumber= randNumber.nextInt(array.length);
                    newStack.push(array[randomNumber]);
                    counter++;
                }
            System.out.println("Today's Leg Beginner workout workout is");
            Mental.meditation(1);
            while(!newStack.isEmpty()){
               
                System.out.println();
                
                System.out.println(newStack.peek());
                newStack.pop();
                System.out.println();
                
            }
                   

                
                
            }else if(beginningTwo==2){
                Stack<String> newStack = new Stack<String>();
                String[] array={
                //leg intermediate
        "Today's Leg Workout is:",
        "   Jump Squats - 3 sets of 10-12 repetitions",
        "Split Squats (Bulgarian Split Squats) - 3 sets of 12 repetitions per leg",
        "Single Leg Box Squats - 3 sets of 8-10 repetitions per leg",
        "Bulgarian Split Squats - 3 sets of 10-12 repetitions per leg",
         "Single Leg Glute Bridges - 3 sets of 12 repetitions per leg",
        "Walking Lunges with Twist - 3 sets of 10-12 lunges per leg",
        "Walking Lunges - 3 sets of 20 steps (10 per leg)",
        "Elevated Pistol Squats - 3 sets of 8-10 repetitions per leg",
        "Depth Jumps - 3 sets of 8-10 jumps",
        "Box Jumps (or Alternating Jump Lunges) - 3 sets of 12 repetitions",
        "Single-Leg Romanian Deadlifts - 3 sets of 10-12 repetitions per leg",
         "Box Step-Ups with Knee Drive - 3 sets of 10-12 repetitions per leg",
        "Jumping Lunges - 3 sets of 20 repetitions (10 per leg)"
    
            
                };
                int number=5;// user will input number
                int counter=0;
                while(counter<number){
                    Random randNumber= new Random();
                    int randomNumber= randNumber.nextInt(array.length);
                    newStack.push(array[randomNumber]);
                    counter++;
                }
            System.out.println("Today's workout is Leg Intermediate Workout");
            Mental.meditation(1);
            while(!newStack.isEmpty()){
               
                System.out.println();
                
                System.out.println(newStack.peek());
                newStack.pop();
                System.out.println();
                
            }
                   
            }else{

                //leg workout expert


                Stack<String> newStack = new Stack<String>();
                String[] array={
               "Barbell Back Squats - 4 sets of 8 repetitions",
                "Single-Leg Deadlift with Barbell - 4 sets of 8 repetitions per leg",
                "Pistol Squats - 4 sets of 6 repetitions per leg",
            "  Barbell Front Squats - 4 sets of 8 repetitions",
            "Barbell Lunges - 4 sets of 8-10 repetitions per leg",
                "Single-Leg Romanian Deadlifts with Barbell - 4 sets of 8 repetitions per leg",
            "Weighted Walking Lunges - 4 sets of 12-15 lunges per leg"
    
            
                };
                int number=5;
                int counter=0;
                while(counter<number){
                    Random randNumber= new Random();
                    int randomNumber= randNumber.nextInt(array.length);
                    newStack.push(array[randomNumber]);
                    counter++;
                }
            System.out.println("Today's Leg expert workout is");
            while(!newStack.isEmpty()){
               
                System.out.println();
                
                System.out.println(newStack.peek());
                newStack.pop();
                System.out.println();
                
            }
               
            }
        
        
        }else if(official==3){

           
            System.out.println("What is your expertise level?");
            System.out.println("1) Beginner");
            System.out.println("2) Intermediate");
            System.out.println("3) Expert");
            
            
           
            int beginningFour=Health.getInput(3);
                if(beginningFour==1){

                    //arms
                    
                Stack<String> newStack = new Stack<String>();
                String[] array={
        
             "Bicep Curls with Dumbbells: 3 sets of 10-15 reps",
             "Alternating Bicep Curls: 3 sets of 10-12 reps",
            "EZ-Bar Bicep Curls: 3 sets of 15-20 reps",
            "Hammer Curls with Dumbbells",
            "Concentration Curls with Dumbbell: 3 sets of 15-20 reps",
            "Resistance Band Bicep Curls: 3 sets of 10-12 reps",
            "Tricep Dips (using a bench or chair)",
             "Tricep Bench Press (with dumbbells or barbell)",
            "Tricep Kickbacks with Dumbbells - 3 sets of 12 repetitions",
            "Overhead Tricep Extensions with Dumbbell",
            "Close-Grip Bench Press",
            "Tricep Pushdowns (with cable machine or resistance band) - 3 sets of 12 repetitions",
            "Push-Ups (standard or modified)",
            "Diamond Push-Ups",
            "Plank to Push-Up",
            "Shoulder Press with Dumbbells"
    
            
                };
                int number=5;
                int counter=0;
                while(counter<number){
                    Random randNumber= new Random();
                    int randomNumber= randNumber.nextInt(array.length);
                    newStack.push(array[randomNumber]);
                    counter++;
                }
            System.out.println("Today's workout Arm beginner workoutis");
            Mental.meditation(1);
            while(!newStack.isEmpty()){
               
                System.out.println();
                
                System.out.println(newStack.peek());
                newStack.pop();
                System.out.println();
                
            }
             
                }else if(beginningFour==2){
                    //arm intermediate
                          
                Stack<String> newStack = new Stack<String>();
                String[] array={
                    
                    "Barbell Bicep Curls - 3 sets of 12 repetitions",
                    "Alternating Dumbbell Bicep Curls - 3 sets of 12 repetitions",
                    "Preacher Curls (using barbell or dumbbells) - 3 sets of 10 repetitions",
                    "Incline Dumbbell Curls - 3 sets of 12 repetitions",
                    "Cable Bicep Curls",
                    "Concentration Curls with Dumbbell - 3 sets of 12 repetitions",
                    "Hammer Curls with Dumbbells - 3 sets of 10 repetitions",
                    "EZ-Bar Curls 3 sets of 20 steps",
                    "Close-Grip Bench Press",
                    "Tricep Dips (weighted if possible)",
                    "Skull Crushers (lying tricep extensions)",
                    "Tricep Rope Pushdowns (with cable machine)",
                    "Overhead Tricep Extensions (with dumbbell or EZ-bar)",
                    "Tricep Kickbacks with Dumbbells",
                    "Tricep Bench Press (with dumbbells or barbell)",
                    "Tricep Pushdowns (with resistance band)"
    
            
                };
                int number=5;
                int counter=0;
                while(counter<number){
                    Random randNumber= new Random();
                    int randomNumber= randNumber.nextInt(array.length);
                    newStack.push(array[randomNumber]);
                    counter++;
                }
            System.out.println("Today's Arm intermediate workout is");
            Mental.meditation(1);
            while(!newStack.isEmpty()){
               
                System.out.println();
                
                System.out.println(newStack.peek());
                newStack.pop();
                System.out.println();
                
            }


                    
                    
                    
                }else{

                    //arm expert
                              
                Stack<String> newStack = new Stack<String>();
                String[] array={
                   
    "Barbell Bicep Curls",
    "Alternating Dumbbell Bicep Curls",
    "Preacher Curls (with barbell or EZ-bar)",
    "Incline Dumbbell Curls",
    "Concentration Curls with Dumbbell",
    "Muscle-ups (or Assisted Muscle-ups) - 4 sets of 4-6 repetitions",
    "L-sit to Handstand (or L-sit to Tuck Planche) - 4 sets of 10-15 seconds hold",
    "Cable Bicep Curls",
    "Hammer Curls with Dumbbells",
    "EZ-Bar Spider Curls",
    "Planche Push-ups - 4 sets of 5-8 repetitions",
    "L-sit Pull-ups - 4 sets of 6-8 repetitions",
    "Skull Crushers (lying tricep extensions)",
    "Overhead Tricep Extensions (with dumbbell or EZ-bar) - 4 sets of 6-8 repetitions",
    "Tricep Rope Pushdowns (with cable machine)",
    "Tricep Kickbacks with Dumbbells",
    "Press 2 to go back to workout menu"
    
            
                };
                int number=5;
                int counter=0;
                while(counter<number){
                    Random randNumber= new Random();
                    int randomNumber= randNumber.nextInt(array.length);
                    newStack.push(array[randomNumber]);
                    counter++;
                }
            System.out.println("Today's Arm Expert workout is");
            Mental.meditation(1);
            while(!newStack.isEmpty()){
               
                System.out.println();
                
                System.out.println(newStack.peek());
                newStack.pop();
                System.out.println();
                
            }
                   
                }
        }
        System.out.println("Press 3 if you are done!");
        Scanner newOp= new Scanner(System.in);
        int newerOption=newOp.nextInt();
        if(newerOption==3){
            Mental.meditation(1);
            System.out.println("Good Job at finishing today's workout! I am super proud of you! ");

        }
       
    }
}
