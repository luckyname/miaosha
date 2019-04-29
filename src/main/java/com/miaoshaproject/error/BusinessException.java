package com.miaoshaproject.error;

/**
 * @author ：shundong.wu
 * @date ：Created in 2019/4/29 9:26
 * @description：包装类业务异常类实现
 */
public class BusinessException extends Exception implements CommonError {
    private CommonError commonError;
    //直接接收EmBusinessError的传参用于构造业务处理
    public  BusinessException(CommonError commonError){
        super();
        this.commonError = commonError;
    }
    //接收自定义的errMsg  方式构造业务异常
    public BusinessException(CommonError commonError,String errMsg){
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);//修改msg
    }
    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
