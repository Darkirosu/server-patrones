package es.uah.cc.domain.decorator;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


public class Client {

    private int id;
    private String name;
    private String username;
    private String password;
    private String email;
    private double money;
    private ArrayList<Integer> gain;

    public Client(int id, String name, String username, String password, String email, double money) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.money = money;
        this.gain= new ArrayList<>();
        this.gain.add(0);
        this.gain.add(0);
        this.gain.add(0);
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void addMoney(double money) {
        this.money += money;
    }

    public ArrayList<Integer> getGain() {
        return gain;
    }

    public void setGain(ArrayList<Integer> gain) {
        this.gain = gain;
    }

    public void addGain(int gain) {
        this.gain.add(gain);
        this.gain.remove(0);
    }
}
