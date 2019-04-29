package com.miaoshaproject.controller;

import com.miaoshaproject.controller.viewobject.UserVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.impl.UserServiceImpl;
import com.miaoshaproject.service.model.UserModel;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @author ：shundong.wu
 * @date ：Created in 2019/4/28 15:40
 * @description：用户控制器11
 */
@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController extends BaseController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private HttpServletRequest httpServletRequest;
    //用户注册接口
    @RequestMapping(value = "/register",method = {RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    private  CommonReturnType register(
            @RequestParam(name = "iphone")String iphone,
            @RequestParam(name = "otpCode")String otpCode,
            @RequestParam(name = "name")String name,
            @RequestParam(name = "gender")Integer gender,
            @RequestParam(name = "age")Integer age,
            @RequestParam(name = "password")String password) throws BusinessException {
        //验证手机号和对应的 otpCode是否一致
        String inSesionOtpCode = (String) this.httpServletRequest.getSession().getAttribute(iphone);
        if(!com.alibaba.druid.util.StringUtils.equals(otpCode,inSesionOtpCode)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"短信验证吗不符合");
        }
        //用户注册
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setGender(new Byte(String.valueOf(gender.intValue())));
        userModel.setAge(age);
        userModel.setIphone(iphone);
        userModel.setRegisterMode("byphone");
        //对密码明文加密
        userModel.setEncrptPassword(MD5Encoder.encode(password.getBytes()));
        userService.register(userModel);
        return CommonReturnType.create(null);
    }




    //用户获取otp短信接口
    @RequestMapping(value = "/getopt",method = {RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name = "iphone") String iphone) {
    // 1.需要按照一定的规则生成OTP的验证码
        Random random = new Random();
        int radomInt = random.nextInt(99999);
        radomInt+=10000;
        String optCode = String.valueOf(radomInt);
    // 2.将OTP验证码同对应的用户手机号关联（redis最佳  暂时使用HttpSession)
        httpServletRequest.getSession().setAttribute(iphone,optCode);

    // 3.将OTP验证码通过短信的通道发送给用户(省略)
        System.out.println("telphone="+iphone +"    &otpCode="+optCode);
        return CommonReturnType.create(null);
    }


    @RequestMapping("/get")
    public @ResponseBody
    CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        UserModel userModel = userService.getUser(id);
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
//            userModel.setEncrptPassword("1321");
        }
        UserVO userVO = convertFromModel(userModel);
        //返回通用对象
        return CommonReturnType.create(userVO);
    }

    /**
     * @param userModel
     * @return
     */
    public UserVO convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }


}