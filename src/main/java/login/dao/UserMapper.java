package login.dao;

import domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Rujiao Xiong on 2017/4/10.
 */
public interface UserMapper {
    void insertUser(User user);
    void updateUser(User user);
    User getUser(int id);
    User getUserByEmail(String emailAddress);
    List<User> getAllUser();
    int getMatchCount(@Param("emailAddress") String emailAddress,@Param("password") String password);


}
