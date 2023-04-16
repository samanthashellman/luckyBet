public class RemoteControl {
    // COMMAND PATTERN IMPLEMENTATION
    Command[] commands;

    public RemoteControl (){
        commands = new Command[9];
        commands[0] = new Slots();
        commands[1] = new Roulette();
        commands[2] = new PowerUps();
        commands[3] = new Leaderboard();
        commands[4] = new HelpCenter();
        commands[5] = new Exit();
    }

    public void buttonPushed(int slot, LuckyBet luckyBet){
        commands[slot-1].execute(luckyBet);
    }
}
