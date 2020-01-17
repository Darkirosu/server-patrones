package es.uah.cc.domain.abstractfactory;

public class PokerHoldem implements Poker {


    @Override
    public PlayTexas playTexas() {
        return null;
    }

    @Override
    public PlayHoldem playHoldem() {
        return new PlayHoldem();
    }
}
