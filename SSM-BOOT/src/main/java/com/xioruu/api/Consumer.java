package com.xioruu.api;

import com.xioruu.dto.UserInfo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xiong
 */
public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext/applicationContext-dubbo-consumer.xml"});
        context.start();
        UserInfoApi demoService = (UserInfoApi) context.getBean("userInfoApi"); // get remote service proxy

        while (true) {
            try {
                Thread.sleep(1000);
                UserInfo userInfo = demoService.getUserInfo(1); // call remote method
                System.out.println(userInfo); // get result

            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }


        }


    }
}
