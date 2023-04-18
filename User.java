
public class User {
    
    String username;
    int moneyWonRoulette;
    int moneyWonFruit;
    int moneyWonJur;
    int moneyWonWorld;
    int balance; //same as money?? i dunno.
    String password;
    // track power-ups too

    public User(){ }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
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