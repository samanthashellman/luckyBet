import java.util.Scanner; 
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.*;
public class Roulette implements Command{

    

    private int valueChipAmount;
    private int nonValueChipAmount;
    private int buyInAmount;
    private User currUser;
    private Dictionary<Integer, String> chips= new Hashtable<>();
    private boolean valueChip = false;
    private boolean nonValChip = false;
    private int totalChipQuantity;
    
    
    //balance has been hardcoded to 50 dollars.

    Roulette() { 
        nonValueChipAmount = 0;
        valueChipAmount = 0;
        buyInAmount = 0;
        //this.currUser = user; TODO: make constructor take in user param
        initTable();

    }
    public void execute(User user){
        System.out.println("Let's play Roulette!");
        setBuyIn();
        chooseBet();


    };

    //sets the amount of chips and type of chips the player would like to play with. Non-value means they can set chip cost themselves.
    public void setBuyIn() {
        boolean end = false;
        System.out.print("Would you like to play with value chips or non-value chips?:\n 1. Value Chip for 5$\n 2. Non-Value Chip\n 3. Exit Game\n");
        Scanner input = new Scanner(System.in); 
        int chip = input.nextInt();
        if(chip == 1) {
            valueChip = true;
            while(!end) {
                System.out.print("Value chip it is! How many would you like? Remember, value chips are 5.00 each.\n" );
                int amountValue = input.nextInt();
                if(5*amountValue > 50) { //replace with user.getbalance()
                    System.out.print("Error. Looks like your balance is isn't large enough to purchase. Try again or go to the main menu and increase your balance.");
                }
                else if(amountValue>35) {
                    System.out.print("Error. The amount of additional chips exceeds the number of spots on the roulette table. Purchase less chips.");
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
            nonValChip = true;
            while(!end) {
                System.out.print("Non-Value chip it is! How many would you like?");
                int amountValue = input.nextInt();
                System.out.print("How much money would you like to set for each chip? Remember, it must be more than 5.00.\n");
                int costPerChip = input.nextInt();
                if(costPerChip*amountValue > 50) {
                    System.out.print("Error. Looks like your balance is isn't large enough to purchase this amount. Try again or go to the main menu and increase your balance.\n");
                }
                else if(amountValue>35) {
                    System.out.print("Error. The amount of additional chips exceeds the number of spots on the roulette table. Purchase less chips.\n");
                }
                else {
                    nonValueChipAmount += amountValue;
                   // currUser.updateBalance(-costPerChip*amountValue);
                    buyInAmount += costPerChip*amountValue;
                    System.out.print("You've purchased " + amountValue + " non-value chips or a total buy in of: " + buyInAmount + ".00.\n");  
                    return; 
                }
            }
            
        }
        else if(chip == 3) { //TODO: implement end game function.
            return;
        }
        else{
            System.out.print("Invalid entry. Enter a number 1 2 or 3.\n");
        }
        
        
    }

    private void initTable() {
        for(int i = 1; i<36; i++) {
            String key = Integer.toString(i);
            chips.put(i,key);
        } 
        
    }

    //function to allow user to choose what bet they want to perform on table. TODO: insert instructions for each.
    private void chooseBet() {
        //add instructions eventually
        boolean end = false;
        while(!(end)) {
            System.out.print("Choose your bet:\n 1. The Straight Up\n 2. The 5 Number Bet\n 3. The Column Bet\n 4. The Odd or Even Bet\n 5. The High Or Low Bet\n");
            Scanner bet = new Scanner(System.in); 
            int betChoice = bet.nextInt();
            if(betChoice == 1) {
                straightUpBet();
                end = true;
            }
            else if (betChoice == 2) {
                fiveNumBet();
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
            else {
                System.out.print("Invalid Entry. Try again.\n");
            }
        }
    }
  
    private void straightUpBet() {

        System.out.print("Welcome to straight up bet! Here you must choose a single spot for each of your chips to go on.\n");
        int count = 1; //to track how many chips we've put down on the table.
        Scanner input = new Scanner(System.in); 
        while(count<totalChipQuantity+1) {
            System.out.print("Select spot for Chip " + count + ":\n");
            String place = input.next();
            Integer value = Integer.parseInt(place); //change input into string for key-value comparison.
            //edge case for invalid int
            if(value>35 || value<0) {
                System.out.print("Invalid entry, choose a number between 0 and 35.\n");
            }
            else if(chips.get(place)==place) {
                chips.put(value, "X");
                chips.toString();//successfully marking roulette table place w/ chip.
                count++;
                System.out.print("worked");
            }
            //edge case if they pick place they've already chosen
            else{
                System.out.print("Name: " + value);
                System.out.print("Key: " + chips.get(place));
                System.out.print("You've already placed a chip here! Try another spot.\n");
            }
            

            

        }


    }
    private void fiveNumBet() {

    }
    private void colBet() {

    }
    private void dozensBet() {

    }
    private void oddOrEvenBet() {

    }
    private void highOrLowBet() {

    }
    private void displayTable() {
        System.out.print(" -----------------------------\n");
        System.out.print("|\n|"); 

        
    }




}
