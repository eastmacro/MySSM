package com.xioruu.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @author xiong
 */
@Component
public class TestAdvisor2 implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("2before method");
        System.out.println(methodInvocation.getMethod().toString());
        Object value = methodInvocation.proceed();
        System.out.println("2after method  " + value.toString());
        return value;
    }
}
