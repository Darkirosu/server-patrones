package es.uah.cc.service;

import es.uah.cc.domain.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NavonioService {

    private NavonioService navonioService;

    @Autowired
    public NavonioService(NavonioService navonioService){
        this.navonioService=navonioService;
    }

    public ArrayList<Statistics> getStatistics(int id){
        return navonioService.getStatistics(id);
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
