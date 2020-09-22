package com.example.datesources.mapper.test3;

import org.apache.ibatis.annotations.Insert;


import java.util.Map;


public interface test3 {

    @Insert("insert into person03 values (#{id},#{name},#{age})")
    int addPerson03 (Map map);
}
