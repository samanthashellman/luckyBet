import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;  
import java.io.FileReader; 
public class Leaderboard implements Command, Observer{
    Integer rouletteMoneyWon = 0;
    String username;
    Integer slotMoneyWon = 0;
    User currUser;
    Boolean init = false;
    //eager instantation of singleton
   // private static Leaderboard uniqueInstance = new Leaderboard();
    public Leaderboard() {}

   /*  public static Leaderboard getInstance() {
        return uniqueInstance;
    }*/
    public void execute(User user){
        if(init==false) {
            user.registerObserver(this);

        }
        if(init!=false) {
            System.out.println("Here's the most current leaderboard");
        }

        init = true;
        
    }

    public void update(String user, Integer roulette, Integer slots) {
        this.rouletteMoneyWon = roulette;
        this.slotMoneyWon = slots;
        this.username = user;
        writeToCSV(username);

    }

    public void writeToCSV(String username) {
        String line = ""; 
       /*  Boolean alreadyPresent = false; 
        try {  
            //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader("leaderboard.csv")); 

            //checking to see if username is already in database 
            while ((line = br.readLine()) != null) {  
                String[] board = line.split(",");
                if(username.equals(board[0])) { 
                    alreadyPresent = true;
                    //change roulette and slots strings to ints
                    Integer roulette = Integer.parseInt(board[1]); 
                    Integer slots = Integer.parseInt(board[2]);
                    if(rouletteMoneyWon>roulette) {
                        board[1] = "test";
                    }
                    else if(slotMoneyWon > slots) {
                        board[2] = "test2";
                    }
                    //see if user won higher than their previous amt, if already in csv. 
                }  
            }

        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }*/
       // if(!alreadyPresent) {
            try (FileWriter f = new FileWriter("leaderboard.csv", true); 
            BufferedWriter b = new BufferedWriter(f); 
            PrintWriter p = new PrintWriter(b);) {
                p.println(username + "," + rouletteMoneyWon.toString() + "," + slotMoneyWon.toString());
            } 
            catch (IOException i) { 
                i.printStackTrace(); 
            }

      //  }
        
        

    }

    public void printLeaderboard() {

    }
}

