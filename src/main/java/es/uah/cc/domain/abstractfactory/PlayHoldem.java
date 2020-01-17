package es.uah.cc.domain.abstractfactory;

import es.uah.cc.domain.singleton.Deck;

import java.util.ArrayList;

public class PlayHoldem extends Play {

    Deck deck = Deck.getInstance();

    private ArrayList<ArrayList<Integer>> pokerHand;

    private ArrayList<Integer> tableHand;

    public ArrayList<Integer> getTableHand() {
        return tableHand;
    }

    public void setTableHand(ArrayList<Integer> tableHand) {
        this.tableHand = tableHand;
    }

    public void addNewHandPlayer(ArrayList<Integer> hand){
        pokerHand.add(hand);
    }

    public void addNewCartPlayer(int hand, int player){
        pokerHand.get(player).add(hand);
    }

    public ArrayList<ArrayList<Integer>> getPokerHand() {
        return pokerHand;
    }

    public void setPokerHand(ArrayList<ArrayList<Integer>> pokerHand) {
        this.pokerHand = pokerHand;
    }




    @Override
    public int winPlayer() {
        for (int i = 0; i < pokerHand.size(); i++) {
            for (int j = 0; j < tableHand.size(); j++) {
                pokerHand.get(i).add(tableHand.get(j));
            }
        }

        ArrayList<Integer> bestHand = new ArrayList<>();
        for (int i = 0; i < pokerHand.size(); i++) {
            bestHand.add(deck.HandRanking(pokerHand.get(i)));
        }
        int aux=bestHand.get(0);
        int auxbest=0;
        for (int i = 1; i < bestHand.size() ; i++) {
            if (aux<bestHand.get(i)){
                auxbest=i;
                aux=bestHand.get(i);
            }
        }
        return auxbest;
    }
}
