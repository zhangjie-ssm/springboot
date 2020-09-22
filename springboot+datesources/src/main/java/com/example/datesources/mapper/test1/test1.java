package com.example.datesources.mapper.test1;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface test1 {
    @Select("select * from person01")
    List<Map<String,Object>> getPerson01();
}
