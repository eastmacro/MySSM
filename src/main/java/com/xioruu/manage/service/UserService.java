package com.xioruu.manage.service;

import com.xioruu.domain.User;
import com.xioruu.domain.UserPhoto;
import com.xioruu.manage.dao.UserMapper;
import com.xioruu.manage.dao.UserPhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Rujiao Xiong on 2017/4/23.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserPhotoMapper userPhotoMapper;


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


    public void updateUserPhoto(MultipartFile file, int userId) throws IOException {
        UserPhoto userPhoto = new UserPhoto();
        userPhoto.setPhoto(file.getBytes());
        int photoId = userPhotoMapper.insert(userPhoto);
        userMapper.updateUserPhoto(photoId,userId);
    }

    public void deleteByPrimaryKey(int id){
        userMapper.deleteByPrimaryKey(id);
    }

    public void insertUser(User user) {
        user.setCreateTime(new Date());
        userMapper.insertUser(user);
    }
}
