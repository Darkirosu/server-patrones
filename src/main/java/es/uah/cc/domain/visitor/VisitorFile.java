package es.uah.cc.domain.visitor;

import java.io.File;

public class VisitorFile implements Visitor {




    @Override
    public void visitor(ElementCSV elementCSV){
        System.out.println("Soy el csv");

    }
}
