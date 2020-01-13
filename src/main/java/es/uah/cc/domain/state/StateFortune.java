package es.uah.cc.domain.state;

public class StateFortune implements State {

    @Override
    public void execute(Lucky l) {
        System.out.println("Tendra supersuerte");
    }

    @Override
    public int lucky(){
        return 1;
    }
}
