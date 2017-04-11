package login.dao;

import domain.User;

/**
 * Created by Rujiao Xiong on 2017/4/10.
 */
public interface UserMapper {
    void insertUser(User user);
    User getUser(int id);

}
