package es.uah.cc.domain.composite;

import lombok.Getter;
import lombok.Setter;

public abstract class Bet {

    private String name;
    private double bonus;

    public Bet(String name, double bonus){
        this.bonus=bonus;
        this.name=name;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setBonus(double bonus){
        this.bonus=bonus;
    }

    public String getName(){
        return this.name;
    }

    public double getBonus(){
        return this.bonus;
    }




    public abstract void addCombinedBet(Bet b);

    public abstract void deleteCombinedBet(Bet b);

    public  double getBonuss(){
        return this.bonus;
    }





}
