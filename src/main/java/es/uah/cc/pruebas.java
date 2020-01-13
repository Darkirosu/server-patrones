package es.uah.cc;

import es.uah.cc.domain.composite.CombinedBet;
import es.uah.cc.domain.composite.SimpleBet;
import es.uah.cc.domain.games.SlotMachine;
import es.uah.cc.domain.state.Lucky;
import es.uah.cc.domain.visitor.ElementCSV;
import es.uah.cc.domain.visitor.Visitor;
import es.uah.cc.domain.visitor.VisitorFile;

public class pruebas {
    public static void main(String args[]){
        Lucky l = new Lucky();
        System.out.println(l.toString());
        l.setBalance(500);
        System.out.println(l.lucky());
        System.out.println();
        l.setGain(350);
        System.out.println(l.lucky());
        l.setWins(-5);
        System.out.println(l.lucky());

        Visitor visitor = new VisitorFile();



        ElementCSV csv = new ElementCSV(null);

        csv.setVisitor(visitor);


        csv.visit();

    }
}
