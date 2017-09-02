package com.carlos.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Created by Administrator on 2017/9/1 0001.
 */
@Aspect
@Component
public class LogAspect {
    private static Logger logger= LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(* com.carlos.core.controller.*Controller.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        StringBuilder sb = new StringBuilder();
        for (Object arg : joinPoint.getArgs()) {
            if (arg != null) {
                sb.append("arg:" + arg.toString() + "|");
            }
        }
        logger.info("before method:" + sb.toString());
    }

    @After("execution(* com.carlos.core.controller.EmployeeHandler.*(..))")
    public void afterMethod() {
        logger.info("after method" + new Date());
    }
}
