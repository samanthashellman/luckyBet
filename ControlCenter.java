import java.util.Scanner;

public class ControlCenter {
    // where the main user input happens
    // triggers remote control commands based on user input

    RemoteControl remote = new RemoteControl();
    User user;

    public ControlCenter(User u){
        user = u;
    }

    public void takeInput(){

        Scanner in = new Scanner(System.in);
        int i = 0;

        while (i != 6){
            System.out.println("What would you like to do now? Please input a number:");
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
        ControlCenter controlCenter = new ControlCenter(new User());
        controlCenter.takeInput();
    }

}
