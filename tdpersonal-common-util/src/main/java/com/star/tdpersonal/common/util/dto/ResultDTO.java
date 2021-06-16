package com.star.tdpersonal.common.util.dto;

import com.star.tdpersonal.common.util.enums.ErrorMessageEnums;

import java.io.Serializable;

/**
 * @program: tdpersonal
 * @description: 通用数据返回封装类
 * @author: xinsida
 * @create: 2021-06-16 10:59
 **/
public class ResultDTO<T> implements Serializable {

    /**
     * 访问结果
     */
    private boolean success = true;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 数据
     */
    private T data;

    /**
     * 调用成功
     *
     * @return
     */
    public static <T> ResultDTO<T> succeed() {
        return succeed(null);
    }

    /**
     * 调用成功
     *
     * @param data 返回的数据
     * @param <T>  数据类型
     * @return
     */
    public static <T> ResultDTO<T> succeed(T data) {
        ResultDTO<T> resultDTO = new ResultDTO<T>();
        resultDTO.setSuccess(true);
        resultDTO.setData(data);
        return resultDTO;
    }

    /**
     * 调用失败
     *
     * @param errorMessageEnums 错误枚举
     * @param <T>               数据类型
     * @return
     */
    public static <T> ResultDTO<T> failed(ErrorMessageEnums errorMessageEnums) {
        ResultDTO<T> resultDTO = new ResultDTO<T>();
        resultDTO.setSuccess(false);
        resultDTO.setErrorCode(errorMessageEnums.getErrorCode());
        resultDTO.setErrorMessage(errorMessageEnums.getErrorMsg());
        return resultDTO;
    }

    /**
     * 调用失败
     *
     * @param errorCode 错误码
     * @param errorMsg  错误信息
     * @param <T>       数据类型
     * @return
     */
    public static <T> ResultDTO<T> failed(String errorCode, String errorMsg) {
        ResultDTO<T> resultDTO = new ResultDTO<T>();
        resultDTO.setSuccess(false);
        resultDTO.setErrorCode(errorCode);
        resultDTO.setErrorMessage(errorMsg);
        return resultDTO;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "success=" + success +
                ", errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", data=" + data +
                '}';
    }
}
