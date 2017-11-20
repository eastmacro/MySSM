package manage.service;

import domain.User;
import manage.dao.UserMapper;
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

    public void loginSuccess(User user,String lastIp) {
        user.setLastIp(lastIp);
        user.setLastVisitTime(new Date());
        user.setCredits(user.getCredits() + 5);
        userMapper.updateUser(user);

    }






}
