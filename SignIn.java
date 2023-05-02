import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;  
import java.io.FileReader; 

public class SignIn {

    public User verify(){
        // get username, password, check with database, then create user with their info

        Scanner in = new Scanner(System.in);

        // get username
        System.out.println("What's your username?");
        String username = in.next();
        
        Boolean isPresent = userExists(username);

        while (!isPresent){
            System.out.println("Username not found! Please try again.");
            username = in.next();
            isPresent = userExists(username);
        }

        // get password
        System.out.println("Great! What's your password?");
        String password = in.next();
        Boolean passwordCorrect = comparePassword(username, password);

        while (!passwordCorrect){
            System.out.println("Password incorrect. Please try again.");
            password = in.next();
            passwordCorrect = comparePassword(username, password);
        }

        System.out.println("Verifying...");
        System.out.println("Success! Welcome back.");
        
        
        return new User();
    }
    private Boolean userExists(String username) {
        Boolean userExists = false;

        String line = "";  
        try {  
            //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader("userInfo.csv")); 

            //checking to see if username in database 
            while ((line = br.readLine()) != null) {  
                String[] userInfo = line.split(",");
                if(username.equals(userInfo[0])) { 
                    userExists = true;
                }  
            }  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }

        return userExists;

    }
    
    private Boolean comparePassword(String username, String givenPassword){
        // returns null if username not in database, otherwise returns the associated password
        if (username.equals("guest")){
            return null;
        }
        String password = "";
        String line = ""; 
        Boolean correctPassword = false; 
        try {  
            //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader("userInfo.csv")); 

            //checking to see if username is already in database 
            while ((line = br.readLine()) != null) {  
                String[] userInfo = line.split(",");
                if(username.equals(userInfo[0])) { 
                    password = userInfo[1];
                }  
            }  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }
        if(givenPassword.equals(password)) {
            correctPassword = true;
        }

        return correctPassword;

        
    }



}
