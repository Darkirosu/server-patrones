package es.uah.cc.domain.builder;

import java.util.ArrayList;

public class Distribute {

    private ArrayList<Integer> deckOfCats;


    public Distribute() {
        this.deckOfCats = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            deckOfCats.get(i);
        }
    }

    public ArrayList<Integer> getDeckOfCats() {
        return deckOfCats;
    }

    public void setDeckOfCats(ArrayList<Integer> deckOfCats) {
        this.deckOfCats = deckOfCats;
    }

    @Override
    public String toString() {
        return "";
    }
}
