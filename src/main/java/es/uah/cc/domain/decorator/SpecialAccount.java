package es.uah.cc.domain.decorator;

public class SpecialAccount extends Decorator {

    private int accountNumber;
    private String kindAccount;

    public SpecialAccount(Account a, int accountNumber){
        super(a);
        this.accountNumber=accountNumber;
        setKind("Special");
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void addMoney(double money){
        super.getClient().addMoney(money*2);
    }

    @Override
    public double getMoney(){
        return super.getClient().getMoney();
    }

    @Override
    public String toString(){
        return super.toString() + " la cuenta bancaria "+ accountNumber;
    }

    @Override
    public String getKind() {
        return kindAccount;
    }

    @Override
    public void setKind(String kind) {
        this.kindAccount=kind;
    }

}