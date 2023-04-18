import java.util.Scanner;


public class Slots implements Command{
    SlotTypes slotType;

    public void execute(User user){
        System.out.println("Let's play slots!");

        Scanner in = new Scanner(System.in);
        int i = 0;

        //while (i > 3){
            System.out.println("Which slot machine would you like to play? Please input a number:");
            // TODO: print options
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
        //}

        // Get user's bet amount
        System.out.println( "How much would you like to bet?");
        int bet = in.nextInt();

        // TODO: check that they have that much to bet
        
        String[] results = slotType.getResults();

        System.out.print(" | ");
        for (int j = 0; j < 3; j++){
            System.out.print(results[j]);
            System.out.print(" | ");
        }
        System.out.println();

        // TODO: check if they won - give/subtract relevant amount from their balance

        if (results[0].equals(results[1]) || results[1].equals(results[2])){
            System.out.println( "You won!");
        }
        else{
            System.out.println( "Better luck next time...");
        }
    };
}
