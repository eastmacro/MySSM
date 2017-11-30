package com.xioruu.manage.service;

import com.xioruu.domain.User;
import com.xioruu.manage.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Rujiao Xiong on 2017/4/7.
 */
@Service
public class LoginService {


    @Autowired
    private UserMapper userMapper;

    public boolean hasMatchUser(String emailAddress,String password) {
        int match = userMapper.getMatchCount(emailAddress, password);
        return match > 0;

    }

    public User getUserByEmail(String emailAddress) {
        return userMapper.getUserByEmail(emailAddress);
    }


    public void loginSuccess(String emailAddress,String lastIp) {
        User user = userMapper.getUserByEmail(emailAddress);
        user.setLastIp(lastIp);
        user.setLastVisitTime(new Date());
        user.setCredits(user.getCredits() + 5);
        userMapper.updateUser(user);
    }





}
