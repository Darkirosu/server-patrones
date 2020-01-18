package es.uah.cc.domain.builder;

import java.util.ArrayList;

public abstract class DistributeBuilder {

    protected Distribute distribute;

    public Distribute getDistribute() {
        return distribute;
    }

    public void crearNuevaPizza() {
        distribute = new Distribute();
    }


    public abstract void start();

    public abstract void shufle();

    public abstract void discard(int i);

    public abstract ArrayList<Integer> distribute(int i);
}
