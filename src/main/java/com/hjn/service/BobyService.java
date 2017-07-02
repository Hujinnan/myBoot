package com.hjn.service;

import com.hjn.bean.Boby;
import com.hjn.respository.BobyRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xiaoz on 2017/7/1.
 */

@Service
public class BobyService {
    @Autowired
    private BobyRespository bobyRespository;

    @Transactional
    public void insertTwo(){
        Boby boby1=new Boby();
        boby1.setAge(18);
        boby1.setName("wangw");
        Boby boby2=new Boby();
        boby2.setAge(20);
        boby2.setName("zhaol");
        bobyRespository.save(boby1);
        bobyRespository.save(boby2);
    }
}
