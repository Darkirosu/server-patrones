package es.uah.cc.domain.other;

import es.uah.cc.domain.decorator.*;
import es.uah.cc.domain.proxy.Proxy;
import es.uah.cc.domain.proxy.ServerNormal;
import es.uah.cc.domain.proxy.ServerPremium;
import es.uah.cc.domain.proxy.ServiceInt;

public class Fproxy {
    private static ServiceInt proxyi = new Proxy(new ServerNormal("Normal"));
    private static ServiceInt proxys = new Proxy(new ServerPremium("Special"));

    public Fproxy() {
    }

    public boolean proxyi(Account account){
        return proxyi.service(account);
    }

    public boolean proxyispecial(Account account, int d){
        Decorator a = new SpecialAccount(account,d);
        return proxyi.service(a);
    }

    public boolean proxyipremium(Account account, int d){
        Decorator a = new PremiumAccount(account,d);
        return proxyi.service(a);
    }

    public boolean proxys(Account account){
        return proxys.service(account);
    }

    public boolean proxysspecial(Account account, int d){
        Decorator a = new SpecialAccount(account,d);
        return proxys.service(a);
    }

    public boolean proxsspremium(Account account, int d){
        Decorator a = new PremiumAccount(account,d);
        return proxys.service(a);
    }

}
