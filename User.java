
public class User {
    
    String username;
    int moneyWonRoulette;
    int moneyWonFruit;
    int moneyWonJur;
    int moneyWonWorld;
    int balance; // total money in account
    String password;
    // track power-ups too

    public User(){
        balance = 100; // starting balance

     }

    public int getBalance() {
        return balance;
    }
    public void updateBalance(int balance) {
        this.balance += balance;
    }
    public void updateMoneyWonRoulette(int money) {
        moneyWonRoulette += money;

    }

    public void updateMoneyWonFruit( int money ){
        moneyWonFruit += money;

    }
    public void updateMoneyWonJur(int money) {
        moneyWonJur += money;

    }
    public void updateMoneyWonWorld(int money) {
        moneyWonWorld += money;

    }
}