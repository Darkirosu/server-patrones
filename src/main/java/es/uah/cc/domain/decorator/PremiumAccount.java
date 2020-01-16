package es.uah.cc.domain.decorator;

public class PremiumAccount extends Decorator {

    private int bankNumber;
    private String kindAccount;

    public PremiumAccount(Account a, int bankNumber){
        super(a);
        this.bankNumber = bankNumber;
        setKind("Premium");
    }

    public int getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(int bankNumber) {
        this.bankNumber = bankNumber;
    }

    @Override
    public void addMoney(double money){
        super.getClient().addMoney(money);
    }

    @Override
    public double getMoney() {
        return super.getClient().getMoney();
    }

    @Override
    public String getKind() {
        return null;
    }

    @Override
    public String toString(){
        return super.toString() + " el numero de cuenta es "+bankNumber;
    }


    @Override
    public void setKind(String kind) {
        this.kindAccount=kind;
    }


}