package es.uah.cc.domain.visitor;

public class FileElement implements Element {

    private Visitor visitor;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileElement(Visitor visitor){
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
