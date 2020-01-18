package es.uah.cc.domain.builder;

import java.util.ArrayList;

public class Croupier {

    private DistributeBuilder distributeBuilder;
    private ArrayList<Integer> player1;
    private ArrayList<Integer> player2;
    private ArrayList<Integer> player3;
    private ArrayList<Integer> player4;
    private ArrayList<Integer> table;

    public ArrayList<Integer> getPlayer1() {
        return player1;
    }

    public ArrayList<Integer> getPlayer2() {
        return player2;
    }

    public ArrayList<Integer> getPlayer3() {
        return player3;
    }

    public ArrayList<Integer> getPlayer4() {
        return player4;
    }

    public ArrayList<Integer> getTable() {
        return table;
    }

    public void setDistributeBuilder(DistributeBuilder pb) {
        distributeBuilder = pb;
    }

    public Distribute getDistribute() {
        return distributeBuilder.getDistribute();
    }

    public void distributeTexas() {
        distributeBuilder.start();
        distributeBuilder.shufle();
        distributeBuilder.discard(3);
        player1=distributeBuilder.distribute(5);
        distributeBuilder.discard(1);
        player2=distributeBuilder.distribute(5);
        distributeBuilder.discard(1);
        player3=distributeBuilder.distribute(5);
        distributeBuilder.discard(1);
        player4=distributeBuilder.distribute(5);
    }

    public void distributeHoldem() {
        distributeBuilder.start();
        distributeBuilder.shufle();
        distributeBuilder.discard(3);
        player1=distributeBuilder.distribute(2);
        distributeBuilder.discard(1);
        player2=distributeBuilder.distribute(2);
        distributeBuilder.discard(1);
        player3=distributeBuilder.distribute(2);
        distributeBuilder.discard(1);
        player4=distributeBuilder.distribute(2);
        distributeBuilder.discard(1);
        table=distributeBuilder.distribute(3);
    }
}
