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

    /**
     * 用户登录
     * @param iphone 用户注册后的手机
     * @param passoword 用户加密后的密码
     */
    UserModel login(String iphone ,String encrptPasssword) throws BusinessException;
}
