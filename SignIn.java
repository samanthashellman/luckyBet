import java.util.Scanner;

public class SignIn {

    public User verify(){
        // get username, password, check with database, then create user with their info

        Scanner in = new Scanner(System.in);

        // get username
        System.out.println("What's your username?");
        String username = in.next();
        String correctPass = getPassword(username);

        while (correctPass == null){
            System.out.println("Username not found! Please try again.");
            username = in.next();
            correctPass = getPassword(username);
        }

        // get password
        System.out.println("Great! What's your password?");
        String password = in.next();

        while (!password.equals(correctPass)){
            System.out.println("Password incorrect. Please try again.");
            password = in.next();
        }

        System.out.println("Verifying...");
        System.out.println("Success! Welcome back.");
        
        
        return new User();
    }
    
    public String getPassword(String username){
        // returns null if username not in database, otherwise returns the associated password
        if (username.equals("guest")){
            return null;
        }
        return "correctPass";
    }

}
