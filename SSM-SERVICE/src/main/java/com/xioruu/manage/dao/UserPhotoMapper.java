package com.xioruu.manage.dao;

import com.xioruu.domain.UserPhoto;

public interface UserPhotoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPhoto record);

    int insertSelective(UserPhoto record);

    UserPhoto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPhoto record);

    int updateByPrimaryKeyWithBLOBs(UserPhoto record);
}