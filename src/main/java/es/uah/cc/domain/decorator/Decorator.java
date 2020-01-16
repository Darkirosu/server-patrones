package es.uah.cc.domain.decorator;

public abstract class Decorator implements Account {

    private Account account;
    private String kindAccount;

    public Decorator(Account account){
        this.account= account;
    }

    public String getKindAccount() {
        return kindAccount;
    }

    public void setKindAccount(String kindAccount) {
        this.kindAccount = kindAccount;
    }

    @Override
    public Client getClient(){
        return account.getClient();
    }

    @Override
    public abstract void addMoney(double i);

    @Override
    public abstract double getMoney();

}
