package es.uah.cc.domain.data;

import java.util.ArrayList;

public class PlayPokerTexas {
    private int id;
    private int bet;
    private ArrayList<Integer> hand;
    private ArrayList<Integer> player1;
    private ArrayList<Integer> player2;
    private ArrayList<Integer> player3;
    private int gain;
    private int win;

    public PlayPokerTexas(int id, int bet, ArrayList<Integer> hand, ArrayList<Integer> player1, ArrayList<Integer> player2, ArrayList<Integer> player3, int gain, int win) {
        this.id = id;
        this.bet = bet;
        this.hand = hand;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.gain = gain;
        this.win = win;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public ArrayList<Integer> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Integer> hand) {
        this.hand = hand;
    }

    public ArrayList<Integer> getPlayer1() {
        return player1;
    }

    public void setPlayer1(ArrayList<Integer> player1) {
        this.player1 = player1;
    }

    public ArrayList<Integer> getPlayer2() {
        return player2;
    }

    public void setPlayer2(ArrayList<Integer> player2) {
        this.player2 = player2;
    }

    public ArrayList<Integer> getPlayer3() {
        return player3;
    }

    public void setPlayer3(ArrayList<Integer> player3) {
        this.player3 = player3;
    }

    public int getGain() {
        return gain;
    }

    public void setGain(int gain) {
        this.gain = gain;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }
}
