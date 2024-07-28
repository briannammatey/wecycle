import java.util.*;
import java.util.concurrent.TimeUnit;
public class Health{

//linked list and hash tables for mental health


//food plan can be mire organized, like what are your dietary restrictions


//workout plan can be more organized and have more sections

//person should pick food plan and workout plan
//use more object orientated programming

static Scanner scan;
    public static void mainMenu(){
        System.out.println("Select a section!");
          System.out.println("1) Daily Calorie Intake");
          System.out.println("2) Workout Plan");
          System.out.println("3) Food Plan");
          System.out.println("4) Mental Health");
    }
    
    public static int getInput(int numberChoices) {
	
		int selectedChoice=0;
		while(true) {
		try {
		
		selectedChoice = scan.nextInt();
		if(selectedChoice>0 && selectedChoice<numberChoices+1) {
		return selectedChoice;
		}
		
		}catch(Exception ex) {
			
			System.out.println("Please enter a number between 1 and " + numberChoices);
			scan =new Scanner(System.in);
		}
		
		}
		
	}
	
    
   

    
    
    public static void main(String[] args) {
        
        System.out.println("****************************************");
        System.out.println("Welcome to our Health Expert simulator");
        System.out.println("****************************************");
        Scanner start=new Scanner(System.in);
        System.out.println(" * Enter 4 to begin *");
        
        //error checking to see valid input
        int input=-1;
        while(true){
        try{
        String firstQ= start.next();
        input = Integer.parseInt(firstQ);
        
            break;
        
        }catch(NumberFormatException e){
            System.out.println("Not a valid input, please try again.");
        }
        }


        if(input!=4){
           throw new IllegalArgumentException("Invalid Argument, Please try again");
        }else{
           mainMenu();
        

         while(true){
            Scanner startingOption=new Scanner(System.in);
            int firstOption= startingOption.nextInt();
         if(firstOption==1){
            CalorieTracker.firstOption();
            mainMenu();
         }else if(firstOption==2){
            Workout.secondOption();
            Workout.playAgain();
            mainMenu();
         }else if(firstOption==3){
            Food.thirdOption();
            mainMenu();
         }else{
            Mental.fourthOption();
            mainMenu();
           
            
         }


        }
      

        }
    }
}