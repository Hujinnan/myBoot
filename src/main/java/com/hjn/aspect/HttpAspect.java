package com.hjn.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiaoz on 2017/7/1.
 */

@Aspect
@Component
public class HttpAspect {

    private final static org.slf4j.Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.hjn.controller.BobyController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void logBefore(JoinPoint joinPoint){

        ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=requestAttributes.getRequest();

        logger.info("url={}",request.getRequestURL());
        logger.info("methon={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class_methon={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void logAfter(){
        logger.info("after log");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void daAfterReturning(Object object){
        logger.info("response={}",object);
    }
}
