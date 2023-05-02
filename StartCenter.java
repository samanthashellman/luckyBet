import java.util.Scanner;

public class StartCenter {
    // start of program, get user input to either make account, sign in, or play as guest

    public void printOptions(){
        System.out.println("1: Create account");
        System.out.println("2: Sign into an existing account");
        System.out.println("3: Play as guest (progress will not be saved)");
        System.out.println("4: Exit");
    }


    public void runProgram(){
        Scanner in = new Scanner(System.in);

        int i = 0;

        while (i != 4){
            System.out.println("What would you like to do now? Please input a number:");
            printOptions();
            i = in.nextInt();
            if (i==1){
                // sign up
                SignUp signUp = new SignUp();
                User thisUser = signUp.createAccount();
                ControlCenter thisGame = new ControlCenter(thisUser);
                thisGame.takeInput();
                return;
            }
            else if (i==2){
                // sign in
                SignIn signIn = new SignIn();
                User thisUser = signIn.verify();
                ControlCenter thisGame = new ControlCenter(thisUser);
                thisGame.takeInput();
                return;
            }
            else if (i==3){
                // play as guest
                System.out.println("Playing as guest...");
                User guest = new User(); 
                ControlCenter guestPlay = new ControlCenter(guest);
                guestPlay.takeInput();
                return;
            }
            else if (i==4){
                System.out.println("Exiting...");
                return;
            }
            else{
                System.out.println("Input not recognized. Please try again.");
            }
        }
        return;
    }

    public static void main(String[] args){
        StartCenter game = new StartCenter();
        game.runProgram();
    }
}
