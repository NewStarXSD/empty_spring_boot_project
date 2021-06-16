package com.star.tdpersonal.common.util.enums;

/**
 * @program: tdpersonal
 * @description: 错误消息枚举
 * @author: xinsida
 * @create: 2021-06-16 11:14
 **/
public enum ErrorMessageEnums {

    SYSTEM_ERROR("SYSTEM_ERROR","系统错误"),
    PARAM_INVALID("PARAM_INVALID","参数异常");

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    ErrorMessageEnums(String errorCode,String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ErrorMessageEnums{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

}
