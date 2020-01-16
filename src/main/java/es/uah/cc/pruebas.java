package es.uah.cc;

import es.uah.cc.domain.Statistics;
import es.uah.cc.domain.composite.CombinedBet;
import es.uah.cc.domain.composite.SimpleBet;
import es.uah.cc.domain.decorator.*;
import es.uah.cc.domain.games.SlotMachine;
import es.uah.cc.domain.proxy.Proxy;
import es.uah.cc.domain.proxy.ServerNormal;
import es.uah.cc.domain.proxy.ServerPremium;
import es.uah.cc.domain.proxy.ServiceInt;
import es.uah.cc.domain.pruebaclases;
import es.uah.cc.domain.state.Lucky;
import es.uah.cc.domain.visitor.*;

import java.lang.reflect.*;
import java.util.ArrayList;

public class pruebas {

    private static ServiceInt proxyi = new Proxy(new ServerNormal("Normal"));
    private static ServiceInt proxys = new Proxy(new ServerPremium("Special"));


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

        SlotMachine sm = new SlotMachine();
        sm.setLucky(l.lucky());
        int reward = sm.play();

        if(reward==-1){
            System.out.println("Perdistes");
        }else{
            System.out.println(sm.getRewards(reward));
            System.out.println(sm.getRewardsName(reward));
        }





        //Visitor visitorcsv = new CsvVisitor();

        Visitor visitors = new CsvVisitor();


        FileElement fe = new FileElement(null);
        BodyElement be = new BodyElement(null);
        CloseElement ce = new CloseElement(null);


        fe.setName("Prueba3");
        pruebaclases s1= new pruebaclases(1,"Sandra",015);
        pruebaclases s2= new pruebaclases(2,"Pepe",45);
        pruebaclases s3= new pruebaclases(3,"Juan",17);
        ArrayList<Object> al = new ArrayList<>();
        al.add(s1);
        al.add(s2);
        al.add(s3);
        be.setObject(al);

        fe.setVisitor(visitors);
        be.setVisitor(visitors);
        ce.setVisitor(visitors);

        if(false){
            fe.visit();
            be.visit();
            ce.visit();
        }

        Client c1 = new Client(1,"pepe","uno","11","pepe@ho",0);
        Client c2 = new Client(2,"Juan","Dr","22","ggg@ho",0);
        Account a1 = new NormalAccount(c1);
        Account a2 = new NormalAccount(c2);

        Decorator pa = new PremiumAccount(a1,124);
        System.out.println(pa.toString());
        System.out.println("El dinero es "+pa.getMoney());
        pa.addMoney(5);
        System.out.println("El dinero es "+pa.getMoney());
        Decorator sa = new SpecialAccount(a2,123);
        System.out.println(sa.toString());
        System.out.println("El dinero es "+sa.getMoney());
        sa.addMoney(5);
        System.out.println("El dinero es "+sa.getMoney());
        sa.getClient();

        System.out.println(proxys.service(sa));




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
