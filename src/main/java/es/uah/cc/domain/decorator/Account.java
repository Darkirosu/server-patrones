package es.uah.cc.domain.decorator;

public interface Account {

    public void addMoney(double m);

    public double getMoney();

    public Client getClient();

    public String getKind();

    public void setKind(String kind);

    @Override
    public String toString();


}
