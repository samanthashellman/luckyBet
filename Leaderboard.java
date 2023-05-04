import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;  
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList; 
import java.util.*;
public class Leaderboard implements Command, Observer{
    Integer rouletteMoneyWon = 0;
    String username;
    Integer slotMoneyWon = 0;
    User currUser;
    Boolean init = false;
    //eager instantation of singleton
    private static Leaderboard uniqueInstance = new Leaderboard();
    private Leaderboard() {}

    public static Leaderboard getInstance() {
        return uniqueInstance;
    }
    public void execute(User user){
        if(init==false) {
            user.registerObserver(this);

        }
        if(init!=false) {
            System.out.println("Here's the most current leaderboard");
            display();
        }

        init = true;
        
    }

    public void update(String user, Integer roulette, Integer slots) {
        this.rouletteMoneyWon = roulette;
        this.slotMoneyWon = slots;
        this.username = user;
        writeToCSV(username);

    }

    public void display() {

        List<Integer> rouletteScores = new ArrayList<Integer>();
        List<Integer> slotScores = new ArrayList<Integer>();
        Map<Integer, String> slotMap  = new HashMap<Integer, String>();
        Map<Integer, String> rouletteMap  = new HashMap<Integer, String>();

        
        String line = ""; 
        try {   
            BufferedReader br = new BufferedReader(new FileReader("leaderboard.csv")); 
            //get username, roulette score, and slot scores from csv and put them into individual lists. 
            while ((line = br.readLine()) != null) { 
                String[] leaderboard = line.split(","); 

                String test = leaderboard[1];
                String test2 = leaderboard[2];

                int rouletteIndiv = Integer.parseInt(test);
                int slotIndiv =Integer.parseInt(test2);

                rouletteScores.add(rouletteIndiv);
                slotScores.add(slotIndiv);

                rouletteMap.put(rouletteIndiv, leaderboard[0]);
                slotMap.put(slotIndiv, leaderboard[0]);
                
            }  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }

        Collections.sort(rouletteScores);
        Collections.sort(slotScores);
        Collections.reverse(slotScores);
        Collections.reverse(rouletteScores);

        System.out.println("\n*** ROULETTE TOP AMOUNTS WON ***");
        for(int i = 0; i<10; i++) {
            System.out.println((i+1)+". " + rouletteMap.get(rouletteScores.get(i)) + ": " + rouletteScores.get(i));

        }

        System.out.println("\n*** SLOTS TOP AMOUNTS WON ***");
        for(int i = 0; i<10; i++) {
            int num = i+1;
            System.out.println((num)+". " + slotMap.get(slotScores.get(i)) + ": " + slotScores.get(i));

        }



    }

    public void writeToCSV(String username) {

            try (FileWriter f = new FileWriter("leaderboard.csv", true); 
            BufferedWriter b = new BufferedWriter(f); 
            PrintWriter p = new PrintWriter(b);) {
                p.println("\n"+username + "," + rouletteMoneyWon.toString() + "," + slotMoneyWon.toString());
            } 
            catch (IOException i) { 
                i.printStackTrace(); 
            }
        
    }

    public void printLeaderboard() {

    }
}

