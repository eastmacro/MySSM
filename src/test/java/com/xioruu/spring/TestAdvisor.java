package com.xioruu.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @author xiong
 */
@Component
public class TestAdvisor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("before method");
        System.out.println(methodInvocation.getMethod().toString());
        Object value = methodInvocation.proceed();
        System.out.println("after method  " + value.toString());
        return value;
    }
}
