package com.miaoshaproject.service;

import com.miaoshaproject.service.model.UserModel;

/**
 *
 */
public interface UserService {
    /**
     * 通过用户id 拿到该用户信息
     * @param id
     */
    UserModel getUser(Integer id);
}
