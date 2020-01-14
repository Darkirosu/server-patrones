package es.uah.cc.domain.visitor;

import java.util.ArrayList;
import java.util.Arrays;

public class BodyElement implements Element {

    private Visitor visitor;
    public ArrayList<Object> object;

    public ArrayList<Object> getObject() {
        return object;
    }

    public void setObject(Object[] objects) {
        for(Object ob:objects){
            this.object.add(ob);
        }
    }

    public void setObject(ArrayList<Object> objects) {
       this.object=objects;
    }

    public BodyElement(Visitor visitor){
        this.visitor=visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    @Override
    public void  visit(){
        visitor.visitor(this);
    }

}
