package es.uah.cc.service;

import es.uah.cc.domain.Statistics;
import es.uah.cc.domain.visitor.*;
import es.uah.cc.repository.NavonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NavonioService {

    private NavonioRepository navonioRepository;

    @Autowired
    public NavonioService(NavonioRepository navonioRepository){
        this.navonioRepository=navonioRepository;
    }

    public ArrayList<Statistics> getStatistics(int id){
        return navonioRepository.getStadistics(id);
    }

    public void fileStatisticsJson(int id){
        System.out.println("Generar archivo JSON con id:"+id);
        file( navonioRepository.getStadistics(id),false);
    }

    public void fileStatisticsCSV(int id){
        System.out.println("Generar archivo CSV con id:"+id);
        file( navonioRepository.getStadistics(id),true);
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
