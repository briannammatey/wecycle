import java.util.Scanner;

public class CalorieTracker {
    static int dailyCalorieCounter=0;

    
    public static void dailyCalorieCounterFunction(int intaking){
        if(intaking!=000 && intaking>0){
            dailyCalorieCounter+=intaking;

        }
    }
   
    
    public static void firstOption(){
        System.out.println("** Welcome your Daily Calorie Intake **");
        System.out.println();
        boolean next=false;
        while(next!=true){
        Scanner calorie = new Scanner(System.in);
            System.out.println("What is your calorie goal for today ? If you are unsure an average person should intake 1600-2200");
            

            int calorieGoal =-1;
            
            while(true){
                try{
                    String caloring= calorie.next();
                    calorieGoal=Integer.parseInt(caloring);
                    break;
                }catch(NumberFormatException e){
                    System.out.println("Not a valid input, please try again.");
                }
            
        

                
        
            }if(calorieGoal<0){
                System.out.println("Please put a number greater than 0");
            }else{
            
            
            
            Scanner counter =new Scanner(System.in);
            System.out.println("Type in each calorie you have intaking today, Type 000 to exit. To start over type in -100");
            //int counterTotal= counter.nextInt();
            boolean stop=false;
            
            while(stop==false){
            int intake=-1;

                while(true){
                    try{
                    String inputting= counter.next();
                    intake = Integer.parseInt(inputting);
                    
                    break;
                    
                    }catch(NumberFormatException e){
                        System.out.println("Not a valid input, please try again.");
                    }
                    }
            
             
             //int intake= counter.nextInt();
                if(intake==-100){
                    dailyCalorieCounter=0;
                    System.out.println("counter resetted");
                }
               else if(intake!=000){
                if(intake<0){
                    System.out.println("Please enter an intake greater than 0");
                }else{
                dailyCalorieCounterFunction(intake);
                }
                
               }else{

                
               stop=true;
                break;
                
               }
              
               
            }
        
                System.out.println("You're have taken "+ dailyCalorieCounter+ " today");
                if(calorieGoal<dailyCalorieCounter){
                    System.out.println("You have gone over your calorie goal today");
                }else if(calorieGoal>dailyCalorieCounter){
                    System.out.println("You have taken less than your calorie goal today");
                }else{
                    System.out.println("You have met your calorie goal today");
                }
                Scanner finalOption= new Scanner(System.in);
                System.out.println("Press 4 to go to main menu! Press any button to restart the program");
                if(finalOption.nextInt()==4){
                    next=true;
                    break;
                }

        

            }   
         
        }
        }





}

