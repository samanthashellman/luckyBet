import java.util.Scanner; 
public class Roulette implements Command{

    

    private Boolean valueChip;
    private Boolean nonValueChip;
    private int valueChipAmount;
    private int nonValueChipAmount;
    private int totalChip;
    private int buyInAmount;
    private User currUser;

    Roulette(User user) { 
        nonValueChipAmount = 0;
        valueChipAmount = 0;
        this.currUser = user;
    }
    public void execute(User user){
        System.out.println("Let's play Roulette!");
    };

    public void setChip() {
        System.out.print("Choose your buy-in:\n 1. Value Chip for 5$\n 2. Non-Value Chip");
        Scanner input = new Scanner(System.in); 
        int chip = input.nextInt();
        if(chip == 1) {
            System.out.print("Value chip it is! How many would you like? You currently have: " + valueChipAmount + " value chips and " + nonValueChipAmount + "non-value chips. For a total of: "  + totalChip + "chips. Making your buy in amount: " + buyInAmount + ".00.\n Remember, value chips are 5.00 each." );
            int amountValue = input.nextInt();
            

        }
    }

}
