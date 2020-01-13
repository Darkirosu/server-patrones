package es.uah.cc.domain.visitor;

public interface Visitor {

    public void visitor(FileElement element);

    public void visitor(BodyElement element);

    public void visitor(CloseElement element);
}
