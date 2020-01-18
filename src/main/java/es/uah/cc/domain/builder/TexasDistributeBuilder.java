package es.uah.cc.domain.builder;

import java.util.ArrayList;
import java.util.Collections;

public class TexasDistributeBuilder extends DistributeBuilder {
    ArrayList<Integer> deckI;

    @Override
    public void start() {
        deckI = new ArrayList<>();
        for (int i = 0; i <52 ; i++) {
            deckI.add(i);
        }
    }

    @Override
    public void shufle() {
        Collections.shuffle(deckI);
    }

    @Override
    public void discard(int discard) {
        for (int i = 0; i < discard ; i++) {
            deckI.remove(0);
        }

    }

    @Override
    public ArrayList<Integer> distribute(int distribute) {
        ArrayList<Integer> aux= new ArrayList<>();
        for (int i = 0; i <distribute ; i++) {
            aux.add(deckI.get(0));
            deckI.remove(0);
        }
        return aux;
    }


}
