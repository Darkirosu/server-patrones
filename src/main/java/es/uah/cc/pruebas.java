package es.uah.cc;

import es.uah.cc.domain.Statistics;
import es.uah.cc.domain.state.Lucky;
import es.uah.cc.domain.visitor.*;

import java.lang.reflect.*;
import java.util.ArrayList;

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


        Visitor visitorcsv = new CsvVisitor();

        Visitor visitorjson = new JsonVisitor();


        FileElement fe = new FileElement(null);
        BodyElement be = new BodyElement(null);
        CloseElement ce = new CloseElement(null);


        fe.setName("Prueba1");
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

        try{
            String classAttribute = s1.getClass().getFields()[1].getType().getName();
            System.out.println(classAttribute);
            /*String data = s1.getClass().getDeclaredField(classAttribute).getClass().toString();
            System.out.println(data);*/
        }catch (Exception e){
            e.printStackTrace();
        }









    }
}
