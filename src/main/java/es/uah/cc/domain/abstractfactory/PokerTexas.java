package es.uah.cc.domain.abstractfactory;

public class PokerTexas implements Poker {

    @Override
    public PlayTexas playTexas() {
        return new PlayTexas();
    }

    @Override
    public PlayHoldem playHoldem() {
        return null;
    }

}
