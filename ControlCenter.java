import java.util.Scanner;

public class ControlCenter {
    // where the main user input happens
    // triggers remote control commands based on user input

    User user;
    RemoteControl remote = new RemoteControl(user);

    public ControlCenter(User u){
        user = u;
    }

    public void printOptions(){
        System.out.println("1: Play the slot machines");
        System.out.println("2: Play Roulette");
        System.out.println("3: Buy Power-ups");
        System.out.println("4: See leaderboard");
        System.out.println("5: Get help");
        System.out.println("6: Exit");
    }

    public void takeInput(){
        remote.buttonPushed(4, user);
        Scanner in = new Scanner(System.in);
        int i = 0;

        while (i != 6){
            System.out.println("What would you like to do now? Please input a number:");
            this.printOptions();
            i = in.nextInt();
            if (i>0 && i<7){
                remote.buttonPushed(i, user);
            }
            else{
                System.out.println("Input not recognized.");
            }
        }
        return;
    }

    public static void main(String[] args){
        User guest = new User(null,null);
        //System.out.println(guest.getBalance());
        ControlCenter controlCenter = new ControlCenter(guest);
        controlCenter.takeInput();
    }

}
