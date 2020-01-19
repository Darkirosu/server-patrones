package es.uah.cc.domain.data;

public class State {
    private  int id;
    private int balance;
    private  int gain;
    private int wins;

    public State(int id, int balance, int gain, int wins) {
        this.id = id;
        this.balance = balance;
        this.gain = gain;
        this.wins = wins;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getGain() {
        return gain;
    }

    public void setGain(int gain) {
        this.gain = gain;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
