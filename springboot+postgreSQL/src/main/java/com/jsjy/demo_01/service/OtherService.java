package com.jsjy.demo_01.service;

import com.jsjy.demo_01.dao.person;
import com.jsjy.demo_01.mapper.OtherSource;
import com.jsjy.demo_01.mapper.yewuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OtherService {
    @Autowired
    OtherSource mapper;

    @Autowired
    yewuMapper mp;

    @Autowired
    private yewuService service;

    public Map<String,Object> getALll(){
        return mapper.getALll();
    }

    public int addPerson02(person per){
        return mapper.addPerson02(per);
    }

    public Map<String,Object> getPerson02(){
        return mapper.getPerson02();
    }

    //迁移demo
    public int migrate(){
        List<Map<String, Object>> info = mp.getdemo_1();
        System.out.println("从数据获取到的数据"+info);
        person p = new person();
        int count = 0;
        for (int i=0;i<info.size();i++){
            Map<String, Object> map = info.get(i);
            p.setId((Integer) map.get("id"));
            p.setName((String) map.get("name"));
            p.setAge((Integer) map.get("age"));
            mapper.addPerson02(p);
            count++;
        }
        System.out.println("更新了"+count+"次");
        return count;
    }
}
