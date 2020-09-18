package com.jsjy.demo_01.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface yewuMapper {
    //查出archive表中数据
    @Select("SELECT id ,archive_no,unit_place FROM archive")
    List<Map<String ,Object>> getInfo();

    @Update("UPDATE archive set archive_no=#{archive_no} WHERE id=#{id}")
    int updatearchive(@Param("archive_no") String  archive_no , @Param("id") int id);
}
