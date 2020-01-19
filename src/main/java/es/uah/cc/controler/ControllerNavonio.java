package es.uah.cc.controler;

import es.uah.cc.domain.data.GameSlot;
import es.uah.cc.domain.data.Statistics;
import es.uah.cc.domain.decorator.Client;
import es.uah.cc.service.NavonioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin
public class ControllerNavonio {

    private NavonioService navonioService;

    @Autowired
    public ControllerNavonio(NavonioService navonioService){
        this.navonioService=navonioService;
    }

    @RequestMapping(value = "/playslot", method = RequestMethod.POST)
    public GameSlot getPlayslot(@RequestBody GameSlot gameSlot){
        return navonioService.playslot(gameSlot);
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


    @RequestMapping(value = "/statistics/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<Statistics> getStatistics(@PathVariable("id") int id) {
        return navonioService.getStatistics(id);
    }

    @RequestMapping(value = "/statisticsjson/{id}", method = RequestMethod.GET)
    public @ResponseBody
    void filejson(@PathVariable("id") int id) {
        navonioService.fileStatisticsJson(id);
    }

    @RequestMapping(value = "/statisticscsv/{id}", method = RequestMethod.GET)
    public @ResponseBody
    void fileCSV(@PathVariable("id") int id) {
        navonioService.fileStatisticsCSV(id);
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Client getClient(@PathVariable("id") int id) {
        return navonioService.getClient(id);
    }

    @RequestMapping(value = "/enternormal/{id}", method = RequestMethod.GET)
    public @ResponseBody
    boolean getAccessN(@PathVariable("id") int id) {
        return navonioService.enterNormal(id);
    }

    @RequestMapping(value = "/enterspecial/{id}", method = RequestMethod.GET)
    public @ResponseBody
    boolean getAccessS(@PathVariable("id") int id) {
        return navonioService.enterSpecial(id);
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public @ResponseBody
    void setClient(@RequestBody Client client) {
        navonioService.setClient(client);
    }


}
