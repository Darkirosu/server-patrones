package es.uah.cc.domain.abstractfactory;

import es.uah.cc.domain.singleton.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public abstract class Play {

    private int player;
    private ArrayList<ArrayList<Integer>> pokerhand;
    private int bet;

    public abstract int winPlayer();


    public void addnewHandPlayer(ArrayList<Integer> hand){
        pokerhand.add(hand);
    }

    public void addnewCartPlayer(int hand, int player){
        pokerhand.get(player).add(hand);
    }

    public ArrayList<Integer> getHandPlayer(int player){
        return pokerhand.get(player);
    }

    public int valueHand(int player){
        ArrayList<Integer> handPlayer = pokerhand.get(1);

        return 0;
    }




}
