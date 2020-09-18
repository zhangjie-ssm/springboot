package com.jsjy.demo_01.controller;

import com.jsjy.demo_01.dao.person;
import com.jsjy.demo_01.service.AllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AllController {
    @Autowired
    private AllService service;

    @RequestMapping(value = "/test")
    public List<person> getAll(){
        List<person> getall = service.getall();
        System.out.println("获取数据"+getall);
        return getall;
    }

    @RequestMapping(value = "/add")
    public int addPerson(person p){
        int i = service.addPerson(p);
        System.out.println("新增成功"+i);
        return i;
    }

    @RequestMapping(value = "/update")
    public int update(person pe){
        int i = service.update(pe);
        System.out.println("修改成功"+i);
        return i;
    }

    @RequestMapping(value = "/del")
    public int del(int id){
        int del = service.del(id);
        System.out.println("删除成功"+del);
        return del;
    }

    @RequestMapping(value = "/getMap")
    public List<Map<String ,Object>> getAllMapp(){
       List<Map<String ,Object>> list =  service.getAllMapp();
        System.out.println("map集合");
        return list;
    }
}
