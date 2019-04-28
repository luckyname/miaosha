package com.miaoshaproject.controller;

import com.miaoshaproject.controller.viewobject.UserVO;
import com.miaoshaproject.service.impl.UserServiceImpl;
import com.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：shundong.wu
 * @date ：Created in 2019/4/28 15:40
 * @description：用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/get")
    public @ResponseBody
    UserVO getUser(@RequestParam(name = "id") Integer id) {
        UserModel userModel = userService.getUser(id);
        return convertFromModel(userModel);
    }

    /**
     *
     * @param userModel
     * @return
     */
    public UserVO convertFromModel(UserModel userModel) {
        if (userModel == null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }
}
