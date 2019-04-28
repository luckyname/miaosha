package com.miaoshaproject.response;

/**
 * @author ：shundong.wu
 * @date ：Created in 2019/4/28 17:22
 * @description：
 */
public class CommonReturnType {
    //表明对应请求返回的处理结果 "success" 或者 "fail"
    private String status;
    //若status = success 则返回data内返回前端需要的 json数据
    //若status = fail 则返回 data内使用通用的 错误代码格式
    private Object data;

    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result,String status) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return  type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
