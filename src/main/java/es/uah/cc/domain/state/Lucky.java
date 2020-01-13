package es.uah.cc.domain.state;

public class Lucky {

    private int gain;
    private int wins;
    private int balance;

    private State currentState;

    public Lucky(){
        this.gain=0;
        this.wins=0;
        this.balance=0;
    }

    public void setBalance(int newbalance) {
        balance += newbalance;
        if(balance>3000){
            balance=3000;
        }
        currentState = new StateBalance();
        currentState.execute(this);
        result();
    }

    public void setGain(int newGain) {
        gain += newGain;
        if(gain>750){
            gain=750;
        }else if(gain<-750){
            gain=-750;
        }
        currentState = new StateGain();
        currentState.execute(this);
        result();
    }

    public void setWins(int wins) {
        if(wins>0){
            if(this.wins>0){
                this.wins++;
            }else{
                this.wins=1;
            }
        }else{
            if(this.wins>0){
                this.wins--;
            }else{
                this.wins=-1;
            }
        }
        this.wins += wins;
        currentState = new StateBalance();
        currentState.execute(this);
        result();
    }

    public int getBalance() {
        return balance;
    }

    public int getGain() {
        return gain;
    }

    public int getWins() {
        return wins;
    }

    public void setCurrentState(State currentState){
        this.currentState=currentState;
    }

    public State getCurrentState() {
        return currentState;
    }

    @Override
    public String toString(){
        return  "wins=" +wins+" balance="+balance+" gain="+gain;
    }

    public void result(){
        currentState.execute(this);
    }

    public int lucky(){
        return currentState.lucky();
    }
}
