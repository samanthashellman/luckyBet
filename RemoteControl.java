public class RemoteControl {
    // COMMAND PATTERN IMPLEMENTATION
    Command[] commands;
    User user;

    public RemoteControl (User u){
       Leaderboard leader = Leaderboard.getInstance(); //singleton

        commands = new Command[6];
        commands[0] = new Slots();
        commands[1] = new Roulette();
        commands[2] = leader;
        commands[3] = new HelpCenter();
        commands[4] = new Exit();
    }

    public void buttonPushed(int slot, User user){
        this.user = user;
        commands[slot-1].execute(user);
    }
}
