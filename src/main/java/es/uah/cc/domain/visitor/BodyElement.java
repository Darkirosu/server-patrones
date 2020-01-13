package es.uah.cc.domain.visitor;

import java.util.ArrayList;

public class BodyElement implements Element {

    private Visitor visitor;
    public ArrayList<Object> object;

    public ArrayList<Object> getObject() {
        return object;
    }

    public void setObject(ArrayList<Object> object) {
        this.object = object;
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
