package es.uah.cc.domain.proxy;

import es.uah.cc.domain.decorator.*;

import java.util.ArrayList;

public class Proxy implements ServiceInt {


    private ServiceInt server;


    public Proxy(ServiceInt server) {
        this.server = server;
    }



    @Override
    public boolean service(Account account) {
        return server.service(account);
    }
}
