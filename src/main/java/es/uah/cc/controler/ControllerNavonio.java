package es.uah.cc.controler;

import es.uah.cc.service.NavonioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class ControllerNavonio {

    private NavonioService navonioService;

    @Autowired
    public ControllerNavonio(NavonioService navonioService){
        this.navonioService=navonioService;
    }

   /* @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<Users> getUsers(){
        return chairService.getUsers();
    }

    @RequestMapping(value = "/temperatures", method = RequestMethod.POST)
    public List<DataTemperature> getTemperature(@RequestBody Users user){
        return chairService.getTemperature(user.getId());
    }

    @RequestMapping(value = "/status/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Status getStatus( @PathVariable("id") int id){
        return chairService.getStatus(id);
    }*/


}
