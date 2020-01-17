package es.uah.cc.domain.iterator;

import java.util.ArrayList;

public class AgregatorConcrete implements  Agregator {

    public ArrayList element;

    public AgregatorConcrete(ArrayList element) {
        this.element = element;
    }

    @Override
    public Iterator createIterator() {
        return new IteratorTexas(this);
    }
}
