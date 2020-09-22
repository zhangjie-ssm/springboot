package com.jsjy.demo_01.controller;

import com.jsjy.demo_01.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OtherController {
    @Autowired
    private OtherService service;

    @RequestMapping(value = "getAll")
    public Map<String,Object> getALll(){
        Map<String, Object> aLll = service.getALll();
        System.out.println("获取数据库信息"+aLll);
        return aLll;
    }

    @RequestMapping(value = "getPerson02")
    public Map<String,Object> getPerson02(){
        return service.getPerson02();
    }

    //数据迁移测试
    @RequestMapping(value = "migrateInfo")
    public Map<String,Object> migrateInfo(){
        int i = service.migrate();
        Map map = new HashMap();
        if (i>0){
            map.put("迁移成功",map);
            return map;
        }else{
            map.put("迁移失败",map);
            return map;
        }
    }
}
