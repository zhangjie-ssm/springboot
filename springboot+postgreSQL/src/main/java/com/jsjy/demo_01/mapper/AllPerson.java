package com.jsjy.demo_01.mapper;

import com.jsjy.demo_01.dao.person;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AllPerson {
    @Select("select * from test_demo")
    List<person> getall();

    @Select("select * from test_demo where id = #{id}")
    List<person> getallbyid(int id);

    @Insert("INSERT INTO test_demo (id,name,age)VALUES(#{id},#{name},#{age})")
    int addPerson(person p);

    @Update("UPDATE test_demo set name=#{name},age=#{age} WHERE id=#{id}")
    int update(person pe);

    @Delete("DELETE from test_demo WHERE id =#{id}")
    int del(int id);
}
