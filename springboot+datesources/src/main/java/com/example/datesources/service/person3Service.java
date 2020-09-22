package com.example.datesources.service;

import com.example.datesources.mapper.test3.test3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class person3Service {
    @Autowired
    private test3 mapper3;
    @Transactional(transactionManager = "test3TransactionManager")
    public int addPerson03(Map map){
        return mapper3.addPerson03(map);
    }

}
