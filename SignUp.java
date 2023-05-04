import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;  
import java.io.FileReader;  


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
        
        User thisUser = new User(username, password);

        System.out.println("How much money would you like to add to your balance?");
        Integer balance = in.nextInt();
        //set user's balance properly.
        thisUser.updateBalance(balance);
        System.out.println("Success. You're ready to play!");

        //Add info to database here.
        try (FileWriter f = new FileWriter("userInfo.csv", true); 
        BufferedWriter b = new BufferedWriter(f); 
        PrintWriter p = new PrintWriter(b);) {
            p.println(username + "," + password + "," + balance.toString());
        } 
        catch (IOException i) { 
            i.printStackTrace(); 
        }
        return thisUser;
    }


    public boolean usernameIsUnique(String username){
        if (username.equals("guest")){
            return false;
        }
        String line = "";  
        try {  
            //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader("userInfo.csv")); 

            //checking to see if username is already in database 
            while ((line = br.readLine()) != null) {  
                String[] userInfo = line.split(",");
                if(username.equals(userInfo[0])) { 
                    return false;
                }  
            }  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }
        return true;
    }
}
