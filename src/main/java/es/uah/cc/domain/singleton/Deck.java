package es.uah.cc.domain.singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Deck {

    private  static Deck instance;

    private Deck(){

    }

    public static Deck getInstance(){
        if(instance==null){
            instance = new Deck();
        }
        return  instance;
    }

    public int  ValueCart(int cart){
        return cart%12;
    }

    public int  SuitsCart(int cart){
        if(0<=cart && cart <12){
            return 0;
        }else if(12<=cart && cart <24){
            return 1;
        }else if(12<=cart && cart <24){
            return 2;
        }else {
            return 3;
        }
    }

    public String SuitsCartName(int cart){
        if(0<=cart && cart <12){
            return "Espadas";
        }else if(12<=cart && cart <24){
            return "Picas";
        }else if(12<=cart && cart <24){
            return "Corazon";
        }else {
            return "Treboles";
        }
    }

    public int HandRanking(ArrayList<Integer> handPlayer){
        Collections.sort(handPlayer);
        if(RoyalFlush(handPlayer)){
            return 1;
        }else if(StraightFlush(handPlayer)){
            return 2;
        }else if(Quad(handPlayer)){
            return 3;
        }else if(FullHouse(handPlayer)){
            return 4;
        }else if(Flush(handPlayer)){
            return 5;
        }else if(Straight(handPlayer)){
            return 6;
        }else if(Threekind(handPlayer)){
            return 7;
        }else if(TwoPair(handPlayer)){
            return 8;
        }else if(OnePair(handPlayer)){
            return 9;
        }
        return 10;
    }

    public boolean RoyalFlush(ArrayList<Integer> handPlayer){
        ArrayList<Integer> suit=SuitHand(handPlayer);
        if(!suit.stream().allMatch(suit.get(0)::equals)){
            return false;
        }
        ArrayList<Integer> value=ValueHand(handPlayer);
        if(value.get(0)==0 && value.get(1)==8 && value.get(2)==9 && value.get(3)==10 && value.get(4)==11){
            return  true;
        }
        return false;
    }

    public boolean StraightFlush(ArrayList<Integer> handPlayer){
        ArrayList<Integer> suit=SuitHand(handPlayer);
        if(!suit.stream().allMatch(suit.get(0)::equals)){
            return false;
        }
        ArrayList<Integer> value=ValueHand(handPlayer);
        boolean aux=true;
        for (int i = 0; i < value.size()-1; i++) {
            if(value.get(i)+1!=value.get(i+1)){
                aux=false;
            }
        }
        return  aux;
    }

    public boolean Straight(ArrayList<Integer> handPlayer){
        ArrayList<Integer> value=ValueHand(handPlayer);
        boolean aux=true;
        for (int i = 0; i < value.size()-1; i++) {
            if(value.get(i)+1!=value.get(i+1)){
                aux=false;
            }
        }
        return  aux;
    }

    public boolean Quad(ArrayList<Integer> handPlayer){
        ArrayList<Integer> value=ValueHand(handPlayer);
        for (int i = 0; i < value.size() ; i++) {
            int aux = value.get(i);
            if(value.stream().filter(x->x==aux).count()==4){
                return true;
            }
        }

        return false;
    }

    public boolean FullHouse(ArrayList<Integer> handPlayer){
        handPlayer=ValueHand(handPlayer);
        ArrayList<Integer> aux = countRepit(handPlayer);
        if(aux.get(0)==3 && aux.get(1)==2){
            return true;
        }
        return false;
    }

    public boolean Flush(ArrayList<Integer> handPlayer){
        ArrayList<Integer> suit=SuitHand(handPlayer);
        if(suit.stream().allMatch(suit.get(0)::equals)){
            return false;
        }
        suit=SuitHand(handPlayer);
        if(!suit.stream().allMatch(suit.get(0)::equals)){
            return false;
        }
        return  true;
    }

    public boolean Threekind(ArrayList<Integer> handPlayer){
        handPlayer=ValueHand(handPlayer);
        ArrayList<Integer> aux = countRepit(handPlayer);
        if(aux.get(0)==3){
            return true;
        }
        return false;
    }

    public boolean TwoPair(ArrayList<Integer> handPlayer){
        handPlayer=ValueHand(handPlayer);
        ArrayList<Integer> aux = countRepit(handPlayer);
        if(aux.get(0)==2 && aux.get(1)==2){
            return true;
        }
        return false;
    }

    public boolean OnePair(ArrayList<Integer> handPlayer){
        handPlayer=ValueHand(handPlayer);
        ArrayList<Integer> aux = countRepit(handPlayer);
        if(aux.get(0)==2){
            return true;
        }
        return false;
    }


    private ArrayList<Integer> countRepit(ArrayList<Integer> hand){
        ArrayList<Integer> aux= hand.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> auxi = new ArrayList<>();
        for (int y = 0; y < aux.size(); y++) {
            int aux2 = aux.get(y);
            auxi.add((int) hand.stream().filter(x->x==aux2).count());
        }
        Collections.sort(auxi,Collections.reverseOrder());
        return auxi;
    }

    private ArrayList<Integer> SuitHand(ArrayList<Integer> handPlayer){
        ArrayList<Integer> tranformer = new ArrayList<>();
        for (int i = 0; i < handPlayer.size(); i++) {
            tranformer.add(SuitsCart(handPlayer.get(i)));
        }
        return tranformer;
    }

    private ArrayList<Integer> ValueHand(ArrayList<Integer> handPlayer){
        ArrayList<Integer> tranformer = new ArrayList<>();
        for (int i = 0; i < handPlayer.size(); i++) {
            tranformer.add(ValueCart(handPlayer.get(i)));
        }
        return tranformer;
    }
}


