package es.uah.cc.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Statistics {
    public int id;
    public String name;
    public int bet;
    public int reward;
    public Date date;

    public Statistics(int id, String name, int bet, int reward, Date date) {
        this.id = id;
        this.name=name;
        this.bet=bet;
        this.reward=reward;
        this.date=date;

    }


}
