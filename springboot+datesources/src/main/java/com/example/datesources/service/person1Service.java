package com.example.datesources.service;

import com.example.datesources.mapper.test1.test1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class person1Service {
    @Autowired
    private test1 mapper1;

    @Transactional(transactionManager = "test1TransactionManager")
    public List<Map<String,Object>> getPerson01(){
        return mapper1.getPerson01();
    }
}
