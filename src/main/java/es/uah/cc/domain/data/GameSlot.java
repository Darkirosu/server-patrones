package es.uah.cc.domain.data;

import lombok.Getter;
import lombok.Setter;

public class GameSlot {
    private  int id;
    private  int reward;
    private  int bet;
    private  int winmoney;

    public GameSlot(int id,int reward, int bet, int winmoney) {
        this.id = id;
        this.reward = reward;
        this.bet = bet;
        this.winmoney = winmoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getWinmoney() {
        return winmoney;
    }

    public void setWinmoney(int winmoney) {
        this.winmoney = winmoney;
    }
}
