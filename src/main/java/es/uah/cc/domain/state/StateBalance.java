package es.uah.cc.domain.state;

public class StateBalance implements State {


    @Override
    public void execute(Lucky l){
        State fortune= new StateFortune();
        State ordinary = new StateOrdinary();
        State unlucky = new StateUnlucky();
        System.out.println("Estado  balance "+l.toString());
        if(l.getBalance()>=2000){
            System.out.println("Buenas apuestas");
            l.setCurrentState(unlucky);
        }else if(l.getBalance()<=2000 && l.getBalance()>=1000){
            System.out.println("Apuesta normal");
            l.setCurrentState(ordinary);
        }else{
            l.setCurrentState(fortune);
            System.out.println("Malas apuestas");
        }
    }

    @Override
    public int lucky(){
        return -5;
    }
}
