package es.uah.cc.domain.state;

public class StateOrdinary implements State {

    @Override
    public void execute(Lucky l) {
        System.out.println("Si buena suerte ni mala suerte");
    }

    @Override
    public int lucky(){
        return 0;
    }
}
