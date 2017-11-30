package com.xioruu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author xiong
 */
@Component
public class Person {

    @Autowired
    private HelloWorld helloWorld;

    public int saySomething() {
        int i = 1;
        int res = helloWorld.sayHelloWorld();
        System.out.println(res);
        return i;

    }

    public int say2(){
        return saySomething();
    }


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("person");
        person.say2();
    }


}
