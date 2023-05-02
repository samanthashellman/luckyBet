import java.util.Scanner;

public class SignUp {
    

    public User createAccount(){
        // get username, password, add to database, and create new user
        Scanner in = new Scanner(System.in);

        // get username
        System.out.println("What username would you like to use?");
        String username = in.next();
        Boolean isUnique = usernameIsUnique(username);

        while (!isUnique){
            System.out.println("Sorry, that username is already taken! Please input a different one.");
            username = in.next();
            isUnique = usernameIsUnique(username);
        }

        // get password
        System.out.println("Great! What password would you like to use?");
        String password = in.next();


        System.out.println("Creating account....");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("Success!");

        User thisUser = new User(username, password);

        return thisUser;
    }


    public boolean usernameIsUnique(String username){
        // TODO: check if username is already in database, return true if it's unique
        if (username.equals("guest")){
            return false;
        }
        return true;
    }
}
