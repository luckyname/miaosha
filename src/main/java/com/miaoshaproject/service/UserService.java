package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
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

    /**
     * 根据opt 手机验证码 注册用户
     * @param userModel
     */
    void register(UserModel userModel) throws BusinessException;
}
