package com.jsjy.demo_01.controller;

import com.jsjy.demo_01.service.yewuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class yewuController {
    @Autowired
    private yewuService service;

    @RequestMapping(value = "/getInfo")
    public Map<String,Object> getInfo(){
        Map<String, Object> info = service.getInfo();
        System.out.println("获取数据"+info);
        return info;
    }
}
