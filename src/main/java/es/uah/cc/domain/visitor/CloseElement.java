package es.uah.cc.domain.visitor;

public class CloseElement implements Element {

    private Visitor visitor;

    public CloseElement(Visitor visitor){
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
