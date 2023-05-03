import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Slots implements Command{
    SlotTypes slotType;
    User currUser;

    public void pauseForDramaticEffect(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } 
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
  

    public void execute(User user){
        this.currUser = user;
        System.out.println("Let's play slots!");

        Scanner in = new Scanner(System.in);
        int i = 0;

        System.out.println("Which slot machine would you like to play? Please input a number:");

        System.out.println( "1: Fruit Frenzy");
        System.out.println( "2: Jurassic Jackpot");
        System.out.println( "3: World Tour");

        i = in.nextInt();
        if (i==1){
            slotType = new FruitFrenzy();
            System.out.println("Playing Fruit Frenzy...");
        }
        else if (i==2){
            slotType =  new JurassicJackpot();
            System.out.println("Playing Jurassic Jackpot...");
        }
        else if (i==3){
            slotType = new WorldTour();
            System.out.println("Playing World Tour...");
        }
        else{
            System.out.println("Input not recognized. Exiting...");
            return;
        }

        // Get user's bet amount
        System.out.println( "How much would you like to bet?");
        int bet = in.nextInt();

        // check that they have that much to bet
        if (bet > user.getBalance()){
            System.out.println("Sorry, you don't have enough money!");
            return;
        }
        else{
            System.out.println("Great, let's see what happens...");
        }
        
        String[] results = slotType.getResults();

        pauseForDramaticEffect(1);

        System.out.print(" | ");
        for (int j = 0; j < 3; j++){
            System.out.print(results[j]);
            System.out.print(" | ");
            pauseForDramaticEffect(1);
        }
        System.out.println();

        // give/subtract relevant amount from their balance
        if (results[0].equals(results[1]) || results[1].equals(results[2])){
            System.out.println( "You won!");
            user.updateBalance(bet*2);
            user.updateMoneyWonSlots(bet*2);
            System.out.println("$" + bet*2 + " added to your account!");
        }
        else{
            System.out.println( "Better luck next time...");
            user.updateBalance(bet*-1);
            System.out.println("$" + bet + " subtracted from your account");
        }

        pauseForDramaticEffect(1);
    };
}
