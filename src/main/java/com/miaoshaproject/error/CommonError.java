package com.miaoshaproject.error;

/**
 * @author ：shundong.wu
 * @date ：Created in 2019/4/29 9:10
 * @description：
 */
public interface CommonError {
     int getErrCode();
     String getErrMsg();
     public CommonError setErrMsg(String errMsg);
}
