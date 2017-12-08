package com.xioruu.api.impl;

import com.xioruu.api.UserInfoApi;
import com.xioruu.domain.User;
import com.xioruu.dto.UserInfo;
import com.xioruu.manage.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author xiong
 */
@Service
public class UserInfoApiImpl implements UserInfoApi {
    private static Logger logger = Logger.getLogger(UserInfoApiImpl.class);

    @Autowired
    private UserService userService;


    @Override
    public UserInfo getUserInfo(int userId) {
        UserInfo userInfo = new UserInfo();
        User user = userService.getUserById(userId);
        BeanUtils.copyProperties(user, userInfo);
        return userInfo;
    }
}
