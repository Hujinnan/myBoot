package com.hjn.controller;
import com.hjn.bean.girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaoz on 2017/6/19.
 */


@RestController
public class HelloController {

    @Autowired
    private girl gl;

    @RequestMapping(value={"/hello","hi"},method = RequestMethod.GET)
    public String say(){

        return gl.getCupSize();
    }
}
