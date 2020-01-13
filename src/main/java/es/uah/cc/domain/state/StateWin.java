package es.uah.cc.domain.state;

public class StateWin implements State {

    @Override
    public void execute(Lucky l){
        State fortune= new StateFortune();
        State ordinary = new StateOrdinary();
        State unlucky = new StateUnlucky();
        System.out.println("Estado  wins "+l.toString());
        if(l.getWins()>=4){
            System.out.println("En racha");
            l.setCurrentState(unlucky);
        }else if(l.getWins()<=4 && l.getWins()>=-4){
            System.out.println("Sin racha");
            l.setCurrentState(ordinary);
        }else{
            l.setCurrentState(fortune);
            System.out.println("En mala racha");
        }
    }

    @Override
    public int lucky(){
        return -5;
    }
}
