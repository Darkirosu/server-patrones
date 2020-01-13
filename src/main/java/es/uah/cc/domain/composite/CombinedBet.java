package es.uah.cc.domain.composite;

import java.util.ArrayList;

public class CombinedBet extends Bet {

    private ArrayList<Bet> bets;

    public CombinedBet(String name,double bonus){
        super(name,bonus);
        bets = new ArrayList<>();
    }

    @Override
    public void addCombinedBet(Bet b) {
        bets.add(b);
    }

    @Override
    public void deleteCombinedBet(Bet b) {
        bets.remove(b);
    }

    @Override
    public double getBonuss() {
        double sum = super.getBonuss();
        for (Bet bet: bets){
            sum *= bet.getBonuss();
        }
        return sum;
    }
}
