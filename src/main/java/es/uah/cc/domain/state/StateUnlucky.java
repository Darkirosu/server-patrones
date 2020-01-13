package es.uah.cc.domain.state;

public class StateUnlucky implements State {

    @Override
    public void execute(Lucky l) {
        System.out.println("La fornuta no te sonrie");
    }

    @Override
    public int lucky(){
        return -1;
    }
}
