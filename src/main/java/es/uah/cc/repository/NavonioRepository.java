package es.uah.cc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NavonioRepository {

    private NavonioMapper navonioMapper;

    @Autowired
    public NavonioRepository(NavonioMapper navonioMapper){
        this.navonioMapper=navonioMapper;
    }

    /*public List<Users> getUsers(){
        return chairMapper.getUsers();
    }*/


}
