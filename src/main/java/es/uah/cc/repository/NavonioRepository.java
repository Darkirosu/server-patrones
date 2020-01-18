package es.uah.cc.repository;

import es.uah.cc.domain.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NavonioRepository {

    private NavonioMapper navonioMapper;

    @Autowired
    public NavonioRepository(NavonioMapper navonioMapper){
        this.navonioMapper=navonioMapper;
    }

    public ArrayList<Statistics> getStadistics(int id){
        return navonioMapper.getStatistics(id);
    }


    /*public List<Users> getUsers(){
        return chairMapper.getUsers();
    }*/


}
