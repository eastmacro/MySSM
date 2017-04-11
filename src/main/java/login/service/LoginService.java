package login.service;

import login.dao.LoginDao;
import login.dao.UserMapper;
import domain.LoginLog;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Rujiao Xiong on 2017/4/7.
 */
@Service
public class LoginService {


    @Autowired
    private LoginDao dao;

    @Autowired
    private UserMapper userMapper;

    public boolean hasMatchUser(String emailAddress,String password) {
        int match = dao.getMatchCount(emailAddress, password);
        return match > 0;

    }

    public User getUserByEmail(String emailAddress) {
        return dao.getByUserEmail(emailAddress);
    }

    public void loginSuccess(User user) {
        user.setCredits(user.getCredits() + 5);
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getId());
        loginLog.setLoginDate(new Date());
        loginLog.setIP(user.getLastIP());
        dao.updateLoginInfo(user);
        dao.insertLoginLog(loginLog);

    }

    public List<User> queryAllUsers() {
        return dao.getAllUsers();
    }

    public User getUserById(int id) {
        return userMapper.getUser(id);

    }

}
