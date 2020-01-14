package es.uah.cc;

import es.uah.cc.domain.Statistics;
import es.uah.cc.domain.composite.CombinedBet;
import es.uah.cc.domain.composite.SimpleBet;
import es.uah.cc.domain.state.Lucky;
import es.uah.cc.domain.visitor.*;

import java.lang.reflect.*;
import java.util.ArrayList;

public class pruebas {
    public static void main(String args[]){

        SimpleBet sb1 = new SimpleBet("Benzema hat-trick",3.1);
        SimpleBet sb2 = new SimpleBet("3-1",2.4);
        SimpleBet sb3 = new SimpleBet("Messi marca",1.16);
        SimpleBet sb4 = new SimpleBet("Suarez Expulsado",2.75);

        CombinedBet cb1 = new CombinedBet("RMA-VAL", 1.5);
        CombinedBet cb2 = new CombinedBet("BAR-ATL",2.1);

        CombinedBet pepe = new CombinedBet("Apuesta", 1);

        cb1.addCombinedBet(sb1);
        cb1.addCombinedBet(sb2);
        cb2.addCombinedBet(sb3);
        cb2.addCombinedBet(sb4);
        pepe.addCombinedBet(cb1);
        pepe.addCombinedBet(cb2);

        System.out.println(pepe.getBonuss());

        Lucky l = new Lucky();
        System.out.println(l.toString());
        l.setBalance(500);
        System.out.println(l.lucky());
        System.out.println();
        l.setGain(350);
        System.out.println(l.lucky());
        l.setWins(-5);
        System.out.println(l.lucky());


        Visitor visitorcsv = new CsvVisitor();

        Visitor visitorjson = new JsonVisitor();


        FileElement fe = new FileElement(null);
        BodyElement be = new BodyElement(null);
        CloseElement ce = new CloseElement(null);


        fe.setName("Prueba3");
        Statistics s1= new Statistics(1,"Sandra",015);
        Statistics s2= new Statistics(2,"Pepe",45);
        Statistics s3= new Statistics(3,"Juan",17);
        ArrayList<Object> al = new ArrayList<>();
        al.add(s1);
        al.add(s2);
        al.add(s3);
        be.setObject(al);

        fe.setVisitor(visitorjson);
        be.setVisitor(visitorjson);
        ce.setVisitor(visitorjson);

        if(true){
            fe.visit();
            be.visit();
            ce.visit();
        }

        /*try{
            String classAttribute = s1.getClass().getFields()[1].getType().getName();
            System.out.println(classAttribute);
            /*String data = s1.getClass().getDeclaredField(classAttribute).getClass().toString();
            System.out.println(data);
        }catch (Exception e){
            e.printStackTrace();
        }*/









    }
}
