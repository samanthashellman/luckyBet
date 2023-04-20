import java.util.Scanner;

public class HelpCenter implements Command{

    public void printOptions(){
        System.out.println("1: Check my balance");
        System.out.println("2: How to play slots");
        System.out.println("3: How to play roulette");
        System.out.println("4: Exit help");
    }

    public void execute(User user){
        System.out.println("Welcome to the help center!");
        
        Scanner in = new Scanner(System.in);
        int i = 0;

        while (i != 4){
            System.out.println("What can we help you with?");
            this.printOptions();
            i = in.nextInt();
            if (i==1){
                System.out.println("Your current balance is: $" + user.getBalance());
            }
            else if (i==2){
                System.out.println("Find more info here: https://entertainment.howstuffworks.com/how-to-play-slot-machines.htm");
            }
            else if (i==3){
                System.out.println("Find more info here: https://www.888casino.com/blog/roulette-strategy-guide/how-to-play-roulette");         
            }
            else if (i==4){
                System.out.println("Exiting...");
            }
            else{
                System.out.println("Input not recognized.");
            }
        }
        return;
    };
}
