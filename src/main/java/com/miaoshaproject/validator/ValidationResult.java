package com.miaoshaproject.validator;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：shundong.wu
 * @date ：Created in 2019/4/30 10:09
 * @description：效验
 */
public class ValidationResult {
    //效验结果是否有错
    private boolean hasErrors = false;

    //存放错误信息的Map
    private Map<String,String> errorMsgMap = new HashMap<>();

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public Map<String, String> getErrorMsgMap() {
        return errorMsgMap;
    }

    public void setErrorMsgMap(Map<String, String> errorMsgMap) {
        this.errorMsgMap = errorMsgMap;
    }

    //实现通用的通过格式化字符串信息获取错误结果的msg方法
    public String getErrMsg(){
        String join = StringUtils.join(errorMsgMap.values().toArray(), ",");
        return join;
    }
}
