package es.uah.cc.repository;

import es.uah.cc.domain.data.DecoratorBBDD;
import es.uah.cc.domain.data.Statistics;
import es.uah.cc.domain.data.State;
import es.uah.cc.domain.decorator.Client;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

@Mapper
public interface NavonioMapper {

    @Select("select id, name, bet,reward,date from statistics where id=#{id}")
    ArrayList<Statistics> getStatistics(int id);

    @Insert("INSERT INTO Statistics(id, name, bet,reward,date) VALUES (#{id},#{name},#{bet},#{reward},NOW())")
    void setStatistics(Statistics statistics);

    @Insert("INSERT INTO decoratorbbdd(id, kindaccount, number) VALUES (#{id},#{kindaccount},#{number})")
    void setDecorator(DecoratorBBDD decoratorbbdd);

    @Select("select id, kindaccount, number from decoratorbbdd where id=#{id}")
    DecoratorBBDD getDecorator(int id);

    @Select("select id, balance, gain , wins from state where id=#{id}")
    State getState(int id);

    @Update("update state set balance=#{balance}, gain=#{gain}, wins=#{wins} where id=#{id}")
    void updateState(State state);

    @Select("select id, name, username , password, money from client where id=#{id}")
    Client getClient(int id);

    @Insert("INSERT INTO client(name, username,password, money) VALUES (#{name},#{username},#{password},#{money})")
    void setClient(Client client);

    /*@Insert("INSERT INTO datatemperature(id_user, temperature, date) VALUES (#{id_user},#{temperature},NOW())")
    void setTemperature(DataTemperature dataTemperature);

    @Update("update status set manual=#{manual}, temperature=#{temperature}, active=#{activeManual} where id_user=#{id_user}")
    void setStatus(Status status);*/

}
