package es.uah.cc.service;

import es.uah.cc.domain.data.DecoratorBBDD;
import es.uah.cc.domain.data.GameSlot;
import es.uah.cc.domain.data.State;
import es.uah.cc.domain.data.Statistics;
import es.uah.cc.domain.decorator.*;
import es.uah.cc.domain.other.Fproxy;
import es.uah.cc.domain.other.SlotMachine;
import es.uah.cc.domain.proxy.Proxy;
import es.uah.cc.domain.proxy.ServerNormal;
import es.uah.cc.domain.proxy.ServerPremium;
import es.uah.cc.domain.proxy.ServiceInt;
import es.uah.cc.domain.state.Lucky;
import es.uah.cc.domain.visitor.*;
import es.uah.cc.repository.NavonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;



@Service
public class NavonioService {

    private static ServiceInt proxyi = new Proxy(new ServerNormal("Normal"));
    private static ServiceInt proxys = new Proxy(new ServerPremium("Special"));
    private NavonioRepository navonioRepository;

    @Autowired
    public NavonioService(NavonioRepository navonioRepository){
        this.navonioRepository=navonioRepository;
    }

    public ArrayList<Statistics> getStatistics(int id){
        return navonioRepository.getStadistics(id);
    }


    public GameSlot playslot(GameSlot gameSlot){
        SlotMachine sm = new SlotMachine();
        Lucky l = new Lucky();
        System.out.println("---Creamos state y lo añadimos");
        State state = navonioRepository.getState(gameSlot.getId());
        System.out.println("---Creamos state y lo añadimos");
        l.setBalance(state.getBalance());
        l.setGain(state.getGain());
        l.setWins(state.getWins());

        sm.setLucky(l.lucky());
        int reward = sm.play();
        System.out.println("pasa");

        if(reward==-1){
            System.out.println("Perdistes");
            gameSlot.setReward(-1);
            gameSlot.setWinmoney(-50);
        }else{
            System.out.println(sm.getRewards(reward));
            System.out.println(sm.getRewardsName(reward));
            gameSlot.setWinmoney(sm.getRewards(reward));
        }
        gameSlot.setReward(reward);
        return gameSlot;

    }

    public void fileStatisticsJson(int id){
        System.out.println("Generar archivo JSON con id:"+id);
        file( navonioRepository.getStadistics(id),false);
    }

    public void fileStatisticsCSV(int id){
        System.out.println("Generar archivo CSV con id:"+id);
        ArrayList<Object> obj = new ArrayList<>();
        ArrayList<Statistics> data = navonioRepository.getStadistics(id);
        file( navonioRepository.getStadistics(id),true);
    }

    public void setClient(Client client){
        navonioRepository.setClient(client);
    }

    public Client getClient(int id){
        return  navonioRepository.getClient(id);
    }

    public DecoratorBBDD getDecorator(int id){
        return navonioRepository.getDecorator(id);
    }

    public boolean enterNormal(int id){
        Client client = getClient(id);
        DecoratorBBDD d =getDecorator(id);
        Account account = new NormalAccount(client);
        Fproxy f = new Fproxy();
        if(d==null){
            return f.proxyi(account);
        }else{
            System.out.println("cliente especial/premium");
            if(d.isKindAccount()){
                return f.proxyipremium(account,d.getNumber());
            }else{
                return f.proxyispecial(account,d.getNumber());
            }
        }
    }

    public boolean enterSpecial(int id){
        Client client = getClient(id);
        DecoratorBBDD d =getDecorator(id);
        Account account = new NormalAccount(client);
        Fproxy f = new Fproxy();
        if(d==null){
            System.out.println("cliente normal: "+account.getKind());
            return f.proxys(account);
        }else{
            System.out.println("cliente especial/premium");
            if(d.isKindAccount()){
                return f.proxsspremium(account,d.getNumber());
            }else{
                return f.proxysspecial(account,d.getNumber());
            }

        }

    }

    private void file(ArrayList<Statistics> statistics, boolean csv){
        Visitor visitors;
        if(csv){
            visitors = new CsvVisitor();
        }else{
            visitors = new JsonVisitor();
        }
        FileElement fe = new FileElement(null);
        BodyElement be = new BodyElement(null);
        CloseElement ce = new CloseElement(null);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        fe.setName(timestamp.getTime()+"");
        ArrayList<Object> obj = new ArrayList<>();
        obj.addAll(statistics);
        be.setObject(obj);
        fe.setVisitor(visitors);
        be.setVisitor(visitors);
        ce.setVisitor(visitors);
        fe.visit();
        be.visit();
        ce.visit();
    }

    /*public Users getAccess(Users user){
        Users userAux = chairRepository.getUser(user);
        if(userAux!=null){

            return comparePassword(user,userAux);
        }
        return userdefault;
    }

    public DataTemperature getLastTemperature(int id){
        return chairRepository.getLastTemperature(id);
    }

    private Users comparePassword(Users usercheck, Users usercorrect){
        if(usercheck.getPassword().equals(usercorrect.getPassword())){
            return usercorrect;
        }

        return userdefault;
    }
    */
}
