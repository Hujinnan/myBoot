package com.hjn.controller;

import com.hjn.bean.Boby;
import com.hjn.respository.BobyRespository;
import com.hjn.service.BobyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by xiaoz on 2017/7/1.
 */

@RestController
public class BobyController {

    @Autowired
    private BobyService bobyService;

    @Autowired
    private BobyRespository bobyRespository;

    @GetMapping(value = "addboby")
    public Boby  bobyAdd(@Valid Boby boby, BindingResult bindingResult){

        if(bindingResult.hasFieldErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
       // Boby boby=new Boby();
        boby.setAge(boby.getAge());
        boby.setName(boby.getName());
        return bobyRespository.save(boby);

    }

    @RequestMapping(value = "addtwo")
    public void bobyTwo(){
        bobyService.insertTwo();

    }
}
