package es.uah.cc.domain.state;

public interface State {

    public void execute(Lucky l);

    public int lucky();
}
