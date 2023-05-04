import java.util.ArrayList;
import java.util.*;

public class User implements Subject {
    
    String username;
    private List<Observer> observers;
    int moneyWonRoulette;
    int moneyWonSlots;
    int balance; // total money in account
    String password;
    // track power-ups too


    public User(String user, String pass){
        this.username = user;
        this.password = pass;
        balance = 0;
        moneyWonSlots = 0;
        moneyWonRoulette = 0;
        observers = new ArrayList<Observer>();
        notifyObservers();
    }
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(username,moneyWonRoulette,moneyWonSlots);
        }
    }
    public void setBalance(Integer balance) {
        this.balance = balance;
        
    }
    public int getBalance() {
        return balance;
    }
    public void updateBalance(int balance) {
        this.balance += balance;
    }
    public void updateMoneyWonRoulette(int money) {
        if(moneyWonRoulette>money) {
            return;
        }
        else {
            moneyWonRoulette = money;
            notifyObservers();
        }

    }

    public void updateMoneyWonSlots( int money ){
        if(moneyWonSlots>money) {
            return;
        }
        else {
            moneyWonSlots = money;
            notifyObservers();

        }

    }

}