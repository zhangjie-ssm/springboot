package com.example.datesources.service;


import com.example.datesources.mapper.test2.test2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Service
public class person2Service {
    @Autowired
    private test2 mapper2;

    @Transactional(transactionManager = "test2TransactionManager")
    public List<Map<String,Object>> getPerson02(){
        return mapper2.getPerson02();
    }

    public int addPerson02(Map map){
        return mapper2.addPerson02(map);
    }
}
