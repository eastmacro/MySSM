package backStageManage.service;

import backStageManage.dao.UserMapper;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by Rujiao Xiong on 2017/4/23.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public List<User> queryAllUsers() {
        return userMapper.getAllUser();
    }

    public User getUserById(int id) {
        return userMapper.getUser(id);

    }

    public void updateUser(User user){
        User orgUser = userMapper.getUser(user.getId());
        orgUser.setCredits(user.getCredits());
        userMapper.updateUser(orgUser);
    }


    public void updateUserPhoto(MultipartFile file, int id) throws IOException {
        userMapper.updateUserPhoto(file.getBytes(),id);


    }
}
