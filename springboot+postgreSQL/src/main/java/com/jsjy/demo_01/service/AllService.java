package com.jsjy.demo_01.service;

import com.jsjy.demo_01.dao.person;
import com.jsjy.demo_01.mapper.AllPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllService {
    @Autowired
    private AllPerson mapper;

    public List<person> getall(){
        return mapper.getall();
    }

    public int addPerson(person p){
        return mapper.addPerson(p);
    }

    public int update(person pe){
        return mapper.update(pe);
    }

    public int del(int id){
        return mapper.del(id);
    }

    public List<person> getallbyid(int id){
        return mapper.getallbyid(id);
    }
}
