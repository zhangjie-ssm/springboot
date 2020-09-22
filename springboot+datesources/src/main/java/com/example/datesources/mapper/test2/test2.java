package com.example.datesources.mapper.test2;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface test2 {
    @Select("select * from person02")
    List<Map<String,Object>> getPerson02();

    @Insert("insert into person02 values (#{id},#{name},#{age})")
    int addPerson02(Map map);
}
