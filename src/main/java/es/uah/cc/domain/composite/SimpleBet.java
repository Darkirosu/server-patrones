package es.uah.cc.domain.composite;

public class SimpleBet extends Bet {

    public  SimpleBet(String name, double bonus){
        super(name,bonus);
    }

    @Override
    public void addCombinedBet(Bet b) {
        
    }

    @Override
    public void deleteCombinedBet(Bet b) {

    }

    @Override
    public double getBonuss() {
        return super.getBonuss();
    }


}
