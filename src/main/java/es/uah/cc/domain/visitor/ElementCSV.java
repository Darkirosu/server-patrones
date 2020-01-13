package es.uah.cc.domain.visitor;

public class ElementCSV implements Element {

    private Visitor visitor;

    public void setVisitor(Visitor visitor){
        this.visitor=visitor;
    }

    public ElementCSV(Visitor visitor){
        this.visitor=visitor;
    }


    @Override
    public void visit(){
        visitor.visitor(this);
    }
}
