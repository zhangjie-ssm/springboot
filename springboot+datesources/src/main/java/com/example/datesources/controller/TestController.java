package com.example.datesources.controller;

import com.example.datesources.service.person1Service;
import com.example.datesources.service.person2Service;
import com.example.datesources.service.person3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private person1Service service1;
    @Autowired
    private person2Service service2;
    @Autowired
    private person3Service service3;

    @RequestMapping("/getPerson01")
    public List<Map<String,Object>> getPerson01() {
        return service1.getPerson01();
    }

    @RequestMapping("/getPerson02")
    public List<Map<String,Object>> getPerson02() {
        return service2.getPerson02();
    }

    //查询新增
    @RequestMapping("/getAdd")
    public Map<String,Object> getAdd(){
        List<Map<String,Object>> person01 = service1.getPerson01();
        List<Map<String,Object>> person02 = service2.getPerson02();
        Map map = new HashMap();
        int count1 = 0;
        for (int i=0;i<person01.size();i++){
            Map<String, Object> map1 = person01.get(i);
            service3.addPerson03(map1);
            count1++ ;
        }
        int count2 = 0;
        for (int i=0;i<person02.size();i++){
            Map<String, Object> map2 = person02.get(i);
            service3.addPerson03(map2);
            count2++ ;
        }
        map.put("test_01表新增到test_03",count1);
        map.put("test_02表新增到test_03",count2);
        return map;
    }
}
