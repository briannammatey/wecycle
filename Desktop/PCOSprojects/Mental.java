import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Mental {
    

    public static void playAgain(){
        
        System.out.println("Would you like to go back to Mental Health menu");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int optionOf=Health.getInput(2);
        
        if(optionOf==1){
            fourthOption();;
        }
    }

    public static void hashFunction(String date ,String content){
        Hashtable<String, String> table= new Hashtable<>(100);
        table.put(date, content);
        //deal with if it is in the samw bucket



    }
    public static void meditation(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("you interuped your relaxing sesion >:(");
            
        }
    }

    public static void quietTime(int seconds){
        int counter=0;
        while(counter!=seconds+1){
            System.out.println("Time: " +counter + " seconds");
            meditation(1);
            counter++;
                    
                    

                }
    }

    public static void fourthOption(){
        System.out.println("*******************************************************");
        System.out.println("Welcome to you're mental health plan");
        System.out.println("*******************************************************");
        Scanner begin = new Scanner(System.in);
        
        System.out.println("press 8 to begin");
        if(begin.nextInt()==8){
            Scanner choice= new Scanner(System.in);

            System.out.println("Select a section:");
            System.out.println("1) Breathing and Meditation excersises ");
            System.out.println("2) Mental health advice");
            System.out.println("3) Daily Journal");
            int mental=Health.getInput(3);
            if(mental==1){
                System.out.println("******************************************************");
                System.out.println("Welcome to your Breathing and Meditation portion");
                System.out.println("******************************************************");
                meditation(3);
                System.out.println("Let's start shall we: ");
                meditation(1);
                System.out.println("This next portion is a breathing excercise, and will be slow paced and should last 2 minutes");
                Scanner choicesOne = new Scanner(System. in);
                
                System.out.println("press 7 to begin");
                if(choicesOne.nextInt()==7){
                    
                    System.out.println("First you are going to breathe in for 10 seconds");
                    meditation(1);
                    quietTime(10);
                    System.out.println("Now Breathe out");

                    meditation(5);
                    Scanner secondMed = new Scanner(System.in);
                    System.out.println("Press 8 to go to the next breathing excersise ");
                    if(secondMed.nextInt()==8){
                    System.out.println(" We are now going to do our second line of meditating but this time I \n want you to imagine yourself  in a peacefull place, floating");
                    meditation(3);
                    System.out.println("It can be at a beach, an island, or a special resort");
                    meditation(8);
                    System.out.println("Let's start");
                    meditation(1);
                    System.out.println("Now breathe in ");
                    quietTime(10);
                    System.out.println("Now breathe out");
                    System.out.println("Good Job!");
                    System.out.println("Now we are on our last breathing excercise, this time I want you to take the \n biggest breath and hold it in ");
                    Scanner thirdMed= new Scanner(System.in);
                    System.out.println("Press 9 to do your third and final excercise");
                    if(thirdMed.nextInt()==9){
                        meditation(2);
                        System.out.println("Okay let's get started");
                        meditation(1);
                        quietTime(10);

                    }
                    meditation(2);
                    System.out.println("You are done with your meditation excercise wooooohooooooo! ");
                    playAgain();
                
                
                }
                }
               
                



            }else if(mental==2){
                System.out.println("**********************************************");
                System.out.println("This is our mental health advice selection");
                System.out.println("**********************************************");
                System.out.println("How are you feeling today, press the selection to indicate the feeling that most alligns to you");
                Scanner feeling = new Scanner(System.in);
                
                System.out.println("1) Happy/ Excited");
                System.out.println("2) Sad/ Depressed");
                System.out.println("3) Bored/ Unfufilled");
                System.out.println("4) Tired");
                System.out.println("5) Stressed/ Overwhelmed");
                System.out.println("6) Fine");
                if(feeling.nextInt()==1){
                    System.out.println("\n" + //
                                                "If you're feeling happy, it's wonderful to savor and embrace this positive state. Happiness is a great motivator, so use this energy to engage in activities that reinforce and sustain your joy. Spend time with people who uplift you, share your happiness with others, and spread positivity. Practicing gratitude by acknowledging and appreciating the good things in your life can enhance your sense of well-being. Pursue your passions and hobbies, as doing what you love can deepen your happiness. Consider setting new goals or challenges for yourself, as personal growth and achievement can contribute to long-term fulfillment. Maintain a balanced lifestyle by taking care of your physical health through regular exercise, a healthy diet, and sufficient rest. Lastly, embrace the present moment, enjoy your accomplishments, and continue to cultivate an optimistic and resilient mindset. Sharing your happiness can also inspire and uplift those around you, creating a positive ripple effect in your community.");

                }else if(feeling.nextInt()==2){
                    System.out.println("Feeling sad is a natural part of life, but it's important to take steps to nurture your well-being during tough times. First, acknowledge your emotions without judgment and allow yourself to feel them fully. Sometimes, writing down your thoughts or talking to a trusted friend can help you process what you're experiencing.\n Engage in activities that bring you comfort and joy, whether it's spending time in nature, listening to music, or pursuing a hobby.\n Taking care of your physical health by eating well, exercising, and getting enough sleep can also positively impact your mood. Remember, \nit's okay to seek professional support if your sadness feels overwhelming or persistent. Surround yourself with positive influences, and remind yourself that it's okay to ask for help—you don't have to go through this alone");

                }else if(feeling.nextInt()==3){
                    System.out.println("If you're feeling bored, it's a great opportunity to explore new interests and activities that can bring excitement and fulfillment into your life. Consider picking up a new hobby or revisiting an old one, such as painting, cooking, reading, or gardening.\n Learning something new, like a language, musical instrument, or a craft, can also be stimulating and rewarding. Physical activity, such as going for a walk, exercising, or trying out a new sport, can boost your mood and energy levels. Connecting with friends or family, whether in person or virtually, can provide social interaction and new experiences.\n Volunteering or helping others can give you a sense of purpose and make your time feel more meaningful. Lastly, sometimes boredom can be a signal that it's time to set new goals or take on a new challenge, so consider what you've always wanted to achieve and take the first step towards it");

                }else if(feeling.nextInt()==4){
                    System.out.println("When feeling stressed, it's crucial to take proactive steps to manage and reduce your stress levels. Start by identifying the source of your stress and acknowledging your feelings without self-criticism. Practicing mindfulness and deep breathing exercises can help calm your mind and body. Regular physical activity, such as yoga, walking, or any form of exercise you enjoy, can significantly reduce stress.\n Make sure to take breaks and give yourself time to relax and recharge, whether it's through reading, listening to music, or spending time in nature. Maintaining a healthy diet and getting enough sleep are also essential for managing stress effectively. \nAdditionally, consider talking to a trusted friend or family member about what's bothering you, as sharing your concerns can provide relief and perspective. If stress becomes overwhelming, seeking professional help from a therapist or counselor can provide you with effective coping strategies and support. Remember, \nit's important to take care of yourself and prioritize your well-being.");
                }else if(feeling.nextInt()==5){
                    System.out.println("If you're feeling fine and content, it's a great time to focus on maintaining and even enhancing your well-being. \nContinue engaging in activities that bring you joy and satisfaction, whether it's spending time with loved ones, pursuing hobbies, or taking on new challenges. Use this period of stability to set and work towards personal goals, whether they're related to your career, education, health, or personal growth.\n Practicing gratitude can help you appreciate the positive aspects of your life and foster a more optimistic outlook. It's also a good time to build and maintain healthy habits, such as regular exercise, balanced nutrition, and adequate sleep, to keep your physical and mental health in check. Stay connected with your social circle and contribute to your community, as these interactions can provide a sense of purpose and fulfillment. Embrace this time of well-being to explore new opportunities, learn new skills, and enjoy the present moment");
                }


            }else if(mental==3){
                System.out.println("Welcome to your personal diary!");
                System.out.println("You will have the opportunities to add a entry or delete an entrey!");
                Scanner scanner = new Scanner(System.in);
        Diary diary = new Diary();
        int choiceThree;

        do {
            System.out.println("1. Add Entry");
            System.out.println("2. Delete Entry");
            System.out.println("3. View All Entries");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choiceThree = scanner.nextInt();

            switch (choiceThree) {
                case 1:
                    System.out.println("Enter entry content:");
                    scanner.nextLine(); // Consume newline left-over
                    String content = scanner.nextLine();
                    diary.addEntry(content);
                    break;
                case 2:
                    System.out.println("Enter entry date to delete (in milliseconds since epoch):");
                    String dateStr = scanner.nextLine();
                    diary.deleteEntry(dateStr);
                    break;
                case 3:
                    diary.printAllEntries();
                    break;
                case 4:
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choiceThree != 4);

        scanner.close();
            
            
            }


        }
        
       



        


        
    }
   
}
