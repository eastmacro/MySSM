package login;

import login.dao.UserMapper;
import domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Rujiao Xiong on 2017/4/10.
 */
public class TestMapper {
    private ApplicationContext applicationContext;


    @Before
    public void setAppCon(){

    }


    @Test
    public void getUSer(){

        applicationContext = new ClassPathXmlApplicationContext(new String[]{
                "applicationContext.xml"
        });
        UserMapper userMapper = (UserMapper) applicationContext.getBean("UserMapper");
        User user = userMapper.getUser(1);
        System.out.println(user.toString());

    }


}
