package com.miaoshaproject.error;

/**
 *
 */
public enum EmBusinessError implements CommonError {
   //通用錯誤類型10000
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOWN_ERROR(10002,"未知错误"),
    //20000開頭為用戶信息相關錯誤定義
    USER_NOT_EXIST(20001,"用戶不存在"),
    USER_LOGIN_FAIL(20002,"用户手机或密码不正确");
    private  int errCode;
    private String errMsg;

    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
