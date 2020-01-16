package es.uah.cc.domain.proxy;

import es.uah.cc.domain.decorator.*;

import java.util.ArrayList;

public class ServerNormal implements  ServiceInt {

    private String name;
    private ArrayList<String> kindPermitted;



    public ServerNormal(String name){
        this.name=name;
        kindPermitted = new ArrayList<>();
        kindPermitted.add("Premium");
        kindPermitted.add("Special");
        kindPermitted.add("Normal");
    }


    @Override
    public boolean service(Account account) {
        if(kindPermitted.contains(account.getKind())){
            return true;
        }else{
            return false;
        }
    }
}
