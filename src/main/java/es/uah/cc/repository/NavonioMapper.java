package es.uah.cc.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface NavonioMapper {

    /*@Select("select id, name,password, job,surname,age ,admin, username from user")
    List<Users> getUsers();

    @Insert("INSERT INTO datatemperature(id_user, temperature, date) VALUES (#{id_user},#{temperature},NOW())")
    void setTemperature(DataTemperature dataTemperature);

    @Update("update status set manual=#{manual}, temperature=#{temperature}, active=#{activeManual} where id_user=#{id_user}")
    void setStatus(Status status);*/

}
