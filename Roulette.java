import java.util.Scanner; 
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;
public class Roulette implements Command{

    

    private int buyInAmount;
    private User currUser;
    private Map<Integer, String> table  = new HashMap<Integer, String>(); //tester
    private List<Integer> alreadyPlaced = new ArrayList<Integer>();
    private int totalChipQuantity;
    private Boolean quit = false;
    private Boolean valueChipMode = false;
    private int buyIn;
    
    
    //balance has been hardcoded to 50 dollars.

    Roulette() { 
        buyInAmount = 0;
        initTable();
        //this.currUser = user; TODO: make constructor take in user param
        

    }
    public void execute(User user){
        System.out.println("Let's play Roulette!");
        initTable();
        chooseBet();
        if(quit==true) {
            return;
        }


    };

    //sets the amount of chips and type of chips the player would like to play with. Non-value means they can set chip cost themselves.
    public void setBuyIn() {
        boolean end = false;
        System.out.print("Would you like to play with value chips or non-value chips?:\n 1. Value Chip for 5$\n 2. Non-Value Chip\n 3. Exit Game\n");
        Scanner input = new Scanner(System.in); 
        int chip = input.nextInt();
        if(chip == 1) {
            buyIn = 5;
            while(!end) {
                System.out.print("Value chip it is! How many would you like? Remember, value chips are 5.00 each.\n" );
                int amountValue = input.nextInt();
                if(5*amountValue > 50) { //replace with user.getbalance()
                    System.out.print("Error. Looks like your balance is isn't large enough to purchase. Try again or go to the main menu and increase your balance.\n");
                }
                else if(amountValue>35) {
                    System.out.println("Error. The amount of additional chips exceeds the number of spots on the roulette table. Purchase less chips.\n");
                }
                else {
                    totalChipQuantity += amountValue;
                    //currUser.updateBalance(-5*amountValue);
                    buyInAmount += 5*amountValue;
                    System.out.print("You've purchased " + amountValue + " value chips for a total buy in of: " + buyInAmount + ".00.\n");  
                    return;
                }
            }
            
        }
        else if(chip == 2) {
            while(!end) {
                valueChipMode = true;
                System.out.println("Non-Value chip it is! How many would you like?");
                int amountValue = input.nextInt();
                System.out.print("How much money would you like to set for each chip? Remember, it must be more than 5.00.\n");
                buyIn = input.nextInt();
                if(buyIn*amountValue > 50 ) { //replace 50 w currUser.getBalance()
                    System.out.print("Error. Looks like your balance is isn't large enough to purchase this amount. Try again or go to the main menu and increase your balance.\n");
                }
                else if(amountValue>35) {
                    System.out.print("Error. The amount of additional chips exceeds the number of spots on the roulette table. Purchase less chips.\n");
                }
                else {
                    totalChipQuantity += amountValue;
                   // currUser.updateBalance(-costPerChip*amountValue);
                    buyInAmount += buyIn*amountValue;
                    System.out.print("You've purchased " + amountValue + " non-value chips or a total buy in of: " + buyInAmount + ".00.\n");  
                    return; 
                }
            }
            
        }
        else if(chip == 3) { 
            System.out.print("Now exiting Roulette\n");
            quit = true;
            return;
        }
        else{
            System.out.print("Invalid entry. Enter a number 1 2 or 3.\n");
        }
        
        
    }

    private void initTable() {
        for(int i = 0; i<37; i++) {
            String val = Integer.toString(i);
            table.put(i, val);      
        } 
        
    }

    //function to allow user to choose what bet they want to perform on table. TODO: insert instructions for each.
    private void chooseBet() {
        //add instructions eventually
        boolean end = false;
        while(!(end)) {
            System.out.print("Choose your bet:\n 1. The Straight Up\n 2. The 4 Number Bet\n 3. The Column Bet\n 4. The Odd or Even Bet\n 5. The High Or Low Bet\n 6. Quit Game\n");
            Scanner bet = new Scanner(System.in); 
            int betChoice = bet.nextInt();
            if(betChoice == 1) {
                straightUpBet();
                end = true;
            }
            else if (betChoice == 2) {
                fourNumBet();
                end = true;   
            }
            else if(betChoice ==3) {
                colBet();
                end = true;
            }
            else if(betChoice==4) {
                oddOrEvenBet();
                end = true;
            }
            else if(betChoice==5) {
                highOrLowBet();
                end = true;
            }
            else if (betChoice==6) {
                end=true;
                quit=true;

            }
            else {
                System.out.print("Invalid Entry. Try again.\n");
            }
        }
    }
  
    private void straightUpBet() {
        setBuyIn();
        System.out.print("Welcome to straight up bet!Here, the rules are simple:\n You must choose a single spot for each of your chips to go on. If your number comes up you'll receive x35 off your initial bet.\nGood Luck!\n");
        int count = 1; //to track how many chips we've put down on the table.
        while(count<totalChipQuantity+1) {
            Scanner input = new Scanner(System.in);
            System.out.print("Select spot for Chip " + count + ":\n");
            int place = input.nextInt();
            
            //edge case for invalid int
            if(place>36 || place<0 && place!=00) {
                System.out.print("Invalid entry, choose a valid roulette placement.\n");
            }
            else if(!alreadyPlaced.contains(place)) {
                table.put(place, "X"); //successfully marking roulette table place w/ chip.
                count++;
                alreadyPlaced.add(place);
            }
            //edge case if they pick place they've already chosen
            else if(alreadyPlaced.contains(place)){
                System.out.print("You've already placed a chip here! Try another spot.\n");
                System.out.print(table.get(place)+"\n"); //debug statement
            }
        }
        displayTable();
        spinWheel(35); //35:1 for a single number bet.
        
        
       
        }

        //Function for spinning roulette wheel. param is dependent upon what bet player chooses. 
        private void spinWheel(int multiplier) {
            System.out.print("Let's start playing!\nSpinning the wheel\n");
            pauseForDramaticEffect(1);
            System.out.print("...\n");
            pauseForDramaticEffect(1);
            System.out.print("...\n");
            pauseForDramaticEffect(1);
            System.out.print("...\n");
            System.out.print("The number is!!!! ");
            pauseForDramaticEffect(1);

            int randomNum = ThreadLocalRandom.current().nextInt(0, 37);
            System.out.print(randomNum + "\n");
            if(alreadyPlaced.contains(randomNum)) {
                int amountWon = multiplier*buyIn;
                System.out.print("Congrats! Your number has come up. You have won " + amountWon +".00. Your balance will be update accordingly.\n");
            }
            else {
                System.out.print("Your number did not come up! Better luck next time.\n");

            }
        

    }
    private void pauseForDramaticEffect(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } 
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    private void fourNumBet() {
        Boolean betSuccessful = false;
        while(!betSuccessful){
            System.out.print("Welcome to the 4 Number Bet.\n Your chips will be place on 0,1,2 and 3.\nYou will received x8 your buy-in if one of these numbers is chosen.\nSet your buy (min. 15.00):\n");
            Scanner input = new Scanner(System.in);
            buyIn = input.nextInt();
            if(buyIn<15) {
                System.out.print("Your buy-in is too low! Remember it has a minimum of 15.00!\n");
            }
            else if(50<buyIn){ //replace w/ currUser.getBalance()
                System.out.print("Looks like you don't have enough money in you balance to enter a buy-in this large. Try again.\n");
            }
            else{
                //update balance w/ buy in here
                table.put(0, "X");
                table.put(1, "X");
                table.put(2, "X");
                table.put(3, "X");
                alreadyPlaced.add(0);
                alreadyPlaced.add(1);
                alreadyPlaced.add(2);
                alreadyPlaced.add(3);
                displayTable();
                spinWheel(8);
                break;
            }

        }

    }
    private void colBet() {
        int col = 1;
        while(true){
            System.out.print("Welcome to the Column Bet.\n You may choose column 1,2, or 3.\nYou will received x2 your buy-in if one of these numbers in your column is chosen.\nSet your buy in (min. 40.00):\n");
            Scanner input = new Scanner(System.in);
            buyIn = input.nextInt();
            if(buyIn<40) {
                System.out.print("Your buy-in is too low! Remember it has a minimum of 15.00!\n");
            }
            else if(50<buyIn){ //replace w/ currUser.getBalance()
                System.out.print("Looks like you don't have enough money in you balance to enter a buy-in this large. Try again.\n");
            }
            else{
                while(true) {
                    System.out.print("Perfect! Now let's get started. Which column would you like to bet on? 1,2, or 3?\n");
                    displayTable();
                    col = input.nextInt();

                    if(col<1&&col>3) {
                        System.out.print("Invalid entry, please pick column 1,2, or 3\n");
                    }
                    else {
                        System.out.print("Column " + col + " it is!\n");
                        if(col == 1) {
                            for(int i=1; i<37; i+=3) {
                                table.put(i, "X");
                                alreadyPlaced.add(i);
                                
                            }
                        }
                        else if(col == 2) {
                            for(int i=2; i<38; i+=3) {
                                table.put(i, "X");
                                alreadyPlaced.add(i);
                            }
                            System.out.print("Case 2");

                        }
                        else if(col==3) {
                            for(int i=3; i<39; i+=3) {
                                table.put(i, "X");
                                alreadyPlaced.add(i);
                            }
                        }

                    }
                        displayTable();
                        spinWheel(2);
                        break;
                        
                }
                break;
                    
            }

        }
        return;
    }
        

    private void oddOrEvenBet() {

    }
    private void highOrLowBet() {

    }
    private void displayTable() {
        System.out.print("  ---------------\n"); 
        int count = 0;
        System.out.print("      |  " + table.get(0)+"  |\n");
        while(count<36) {
            
            for(int j=0; j<3; j++) {
                System.out.print("| ");
                count++;
                System.out.print(table.get(count)); 
                if(count<10 || table.get(count)=="X") { //spacing purposes
                    System.out.print("   "); 
                }
                else{
                    System.out.print("  "); 
                }
            }
            System.out.print("|\n");
        }
        System.out.print("  ---------------\n");
        System.out.print("  ONE  TWO  THREE\n");
        System.out.print("  ---------------\n");
        

        
    }




}
