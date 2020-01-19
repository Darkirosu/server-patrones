package es.uah.cc.domain.other;

import java.util.Random;

public class SlotMachine {

    private final int[] rewards=new int[] {50,100,200,250,500,1000,1250,1500,1750,2000};
    private final String[] rewardsName=new String[] {"Moneda oro","Saco de monedas","Moneda plata","Cofre de oro","Corazon","Diamante","Tridente","Espada","Corona","Lingote de oro"};
    int lucky;
    Random rm;

    public SlotMachine(){
        this.lucky=0;
        this.rm = new Random();
    }

    public void setLucky(int lucky) {
        this.lucky = lucky;
    }

    public int getLucky() {
        return lucky;
    }

    public String getRewardsName(int i) {
        return rewardsName[i];
    }

    private int random(int operacion){
        int r =  rm.nextInt(operacion);
        return r;
    }

    public int getRewards(int r) {
        return rewards[r];
    }

    public int play(){
        int prize= random(10);
        System.out.println(prize);
        if(random((2-lucky))==0){
            if(random((5-(lucky*2)))==0){
                return  prize;
            }else{
                return -1;
            }
        }else{
            return -1;
        }

    }
}
