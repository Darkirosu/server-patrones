package es.uah.cc.domain.state;

public class StateGain implements State{

    @Override
    public void execute(Lucky l){
        State fortune= new StateFortune();
        State ordinary = new StateOrdinary();
        State unlucky = new StateUnlucky();
        System.out.println("Estado  gain "+l.toString());
        if(l.getWins()>=500){
            System.out.println("Inserto bastante dinero");
            l.setCurrentState(fortune);
        }else if(l.getWins()<=500 && l.getWins()>=250){
            System.out.println("Inserto algo dinero");
            l.setCurrentState(ordinary);
        }else{
            l.setCurrentState(unlucky);
            System.out.println("Inserto poco dinero");
        }
    }

    @Override
    public int lucky(){
        return -5;
    }
}
