package com.xioruu.api;

import com.xioruu.dto.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @author xiong
 */

@Service
public interface UserInfoApi {

    UserInfo getUserInfo(int userId);
}
