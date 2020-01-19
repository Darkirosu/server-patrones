package es.uah.cc.repository;

import es.uah.cc.domain.data.DecoratorBBDD;
import es.uah.cc.domain.data.State;
import es.uah.cc.domain.data.Statistics;
import es.uah.cc.domain.decorator.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class NavonioRepository {

    private NavonioMapper navonioMapper;

    @Autowired
    public NavonioRepository(NavonioMapper navonioMapper){
        this.navonioMapper=navonioMapper;
    }


    public void setStatistics(Statistics statistics){
        navonioMapper.setStatistics(statistics);
    }

    public ArrayList<Statistics> getStadistics(int id){
        return navonioMapper.getStatistics(id);
    }

    public void setDecorator(DecoratorBBDD decoratorBBDD){
        navonioMapper.setDecorator(decoratorBBDD);
    }

    public DecoratorBBDD getDecorator(int id){
        return navonioMapper.getDecorator(id);
    }

    public void updateState(State state){
        navonioMapper.updateState(state);
    }

    public State getState(int id){
       return navonioMapper.getState(id);
    }

    public Client getClient(int id){
        return navonioMapper.getClient(id);
    }
    public void setClient(Client client){
        navonioMapper.setClient(client);
    }

    /*public List<Users> getUsers(){
        return chairMapper.getUsers();
    }*/


}
