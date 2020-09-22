package com.jsjy.demo_01.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Map;


@Mapper
@Primary
@Configuration
@ConfigurationProperties("datasource")
public interface yewuMapper {
    //查出archive表中数据
    @Select("SELECT id ,archive_no,unit_place FROM archive")
    List<Map<String ,Object>> getInfo();

    @Update("UPDATE archive set archive_no=#{archive_no} WHERE id=#{id}")
    int updatearchive(@Param("archive_no") String  archive_no , @Param("id") int id);

    //测试从demo_1把数据迁移到demo_2
    @Select("SELECT * FROM person01")
    List<Map<String ,Object>> getdemo_1();
}
