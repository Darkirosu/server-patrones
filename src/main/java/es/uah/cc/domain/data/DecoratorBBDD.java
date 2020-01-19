package es.uah.cc.domain.data;

public class DecoratorBBDD {
    private  int id;
    private  boolean kindAccount;
    private int number;

    public DecoratorBBDD(int id, boolean kindAccount, int number) {
        this.id = id;
        this.kindAccount = kindAccount;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isKindAccount() {
        return kindAccount;
    }

    public void setKindAccount(boolean kindAccount) {
        this.kindAccount = kindAccount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
