import java.util.Scanner; 
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
public class Roulette implements Command{

    

    private int valueChipAmount;
    private int nonValueChipAmount;
    private int buyInAmount;
    private User currUser;
    private Dictionary<String, Integer> nonValChips= new Hashtable<>();
    boolean valueChip = false;
    boolean nonValChip = false;


    Roulette(User user) { 
        nonValueChipAmount = 0;
        valueChipAmount = 0;
        buyInAmount = 0;
        this.currUser = user;
    }
    public void execute(User user){
        System.out.println("Let's play Roulette!");
        setBuyIn();

    };

    //sets the amount of chips and type of chips the player would like to play with. Non-value means they can set chip cost themselves.
    public void setBuyIn() {
        boolean end = false;
        System.out.print("Would you like to play with value chips or non-value chips?:\n 1. Value Chip for 5$\n 2. Non-Value Chip or 3. start playing now \n");
        Scanner input = new Scanner(System.in); 
        int chip = input.nextInt();
        if(chip == 1) {
            valueChip = true;
            while(!end) {
                System.out.println("Value chip it is! How many would you like? Remember, value chips are 5.00 each." );
                int amountValue = input.nextInt();
                if(5*amountValue > currUser.getBalance()) {
                    System.out.println("Error. Looks like your balance is isn't large enough to purchase. Try again or go to the main menu and increase your balance.");
                }
                else if(amountValue>35) {
                    System.out.println("Error. The amount of additional chips exceeds the number of spots on the roulette table. Purchase less chips.");
                }
                else {
                    valueChipAmount += amountValue;
                    currUser.updateBalance(-5*amountValue);
                    buyInAmount += 5*amountValue;
                    System.out.print("You've purchased " + amountValue + " value chips for a total buy in of: " + buyInAmount + ".00.\n");  
                    return;
                }
            }
            
        }
        else if(chip == 2) {
            nonValChip = true;
            while(!end) {
                System.out.println("Non-Value chip it is! How many would you like?");
                int amountValue = input.nextInt();
                System.out.print("How much money would you like to set for each chip? Remember, it must be more than 5.00.\n");
                int costPerChip = input.nextInt();
                if(costPerChip*amountValue > currUser.getBalance()) {
                    System.out.println("Error. Looks like your balance is isn't large enough to purchase this amount. Try again or go to the main menu and increase your balance.");
                }
                else if(amountValue>35) {
                    System.out.println("Error. The amount of additional chips exceeds the number of spots on the roulette table. Purchase less chips.");
                }
                else {
                    nonValueChipAmount += amountValue;
                    currUser.updateBalance(-costPerChip*amountValue);
                    buyInAmount += costPerChip*amountValue;
                    System.out.print("You've purchased " + amountValue + " non-value chips. You now have: for a total buy in of: " + buyInAmount + ".\n");   
                }
            }
            
        }
        else if(chip == 3) {
            return;
        }
        else{
            System.out.println("Invalid entry. Enter a number 1 or 2.");
        }
        
        
    }

    private void addChipToTable(int placement) {
        
        nonValChips.put("chip"+nonValueChipAmount,placement);
    }
    private void chooseBet() {
        //add instructions eventually
        boolean end = false;
        while(!(end)) {
            System.out.println("Choose your bet:\n 1. The Straight Up\n 2. The 5 Number Bet\n 3. The Column Bet\n 4. The Odd or Even Bet\n 5. The High Or Low Bet");
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
                System.out.println("Invalid Entry. Try again.");
            }
        }
    }
  
    private void straightUpBet() {

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




}
