package es.uah.cc.domain.decorator;

public class NormalAccount implements Account {

    private Client client;
    private  String kindAccount;


    public NormalAccount(Client c){
        this.client=c;
        setKind("Normal");
    }


    @Override
    public void addMoney(double m) {
        this.client.setMoney(m);
    }

    @Override
    public double getMoney() {
       return this.client.getMoney();
    }


    @Override
    public Client getClient() {
        return this.client;
    }

    @Override
    public String getKind() {
        return kindAccount;
    }

    @Override
    public void setKind(String kind) {
        this.kindAccount=kind;
    }

    @Override
    public String toString() {
        return client.toString();
    }
}
