package com.jsjy.demo_01.mapper;

import com.jsjy.demo_01.dao.person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Map;

@Mapper
public interface OtherSource {

    @Select("select count(*) from t_archive")
    Map<String,Object> getALll();

    @Select("select * from person02")
    Map<String,Object> getPerson02();

    @Update("INSERT INTO person02 VALUES (#{id},#{name},#{age})")
    int addPerson02(person per);
}
