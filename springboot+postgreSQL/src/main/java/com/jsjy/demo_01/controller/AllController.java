package com.jsjy.demo_01.controller;

import com.jsjy.demo_01.dao.person;
import com.jsjy.demo_01.service.AllService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.util.List;

@RestController
public class AllController {
    @Autowired
    private AllService service;

    private static Logger log = Logger.getLogger(AllController.class);

    @RequestMapping(value = "/test")
    public List<person> getAll(){
        List<person> getall = service.getall();
        log.info("日志添加成功");
        System.out.println("获取数据"+getall);
        return getall;
    }

    @RequestMapping(value = "/getallbyid")
    public List<person> getallbyid(int id){
        List<person> getallbyid = service.getallbyid(id);
        System.out.println("根据id查询"+getallbyid);
        return getallbyid;
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
}
