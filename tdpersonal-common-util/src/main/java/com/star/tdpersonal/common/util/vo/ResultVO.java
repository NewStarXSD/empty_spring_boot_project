package com.star.tdpersonal.common.util.vo;

import com.star.tdpersonal.common.util.enums.ErrorMessageEnums;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: tdpersonal
 * @description: 统一页面返回视图数据类
 * @author: xinsida
 * @create: 2021-06-19 21:17
 **/
@Data
public class ResultVO<T> implements Serializable {

    /**
     * 访问结果
     */
    private Boolean success;

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
    public static <T> ResultVO<T> succeed() {
        return succeed(null);
    }

    /**
     * 调用成功
     *
     * @param data 返回的数据
     * @param <T>  数据类型
     * @return
     */
    public static <T> ResultVO<T> succeed(T data) {
        ResultVO<T> res = new ResultVO<T>();
        res.setSuccess(true);
        res.setData(data);
        return res;
    }

    /**
     * 调用失败
     *
     * @param errorMessageEnums 错误枚举
     * @param <T>               数据类型
     * @return
     */
    public static <T> ResultVO<T> failed(ErrorMessageEnums errorMessageEnums) {
        ResultVO<T> res = new ResultVO<T>();
        res.setSuccess(false);
        res.setErrorCode(errorMessageEnums.getErrorCode());
        res.setErrorMessage(errorMessageEnums.getErrorMsg());
        return res;
    }

    /**
     * 调用失败
     *
     * @param errorCode 错误码
     * @param errorMsg  错误信息
     * @param <T>       数据类型
     * @return
     */
    public static <T> ResultVO<T> failed(String errorCode, String errorMsg) {
        ResultVO<T> res = new ResultVO<T>();
        res.setSuccess(false);
        res.setErrorCode(errorCode);
        res.setErrorMessage(errorMsg);
        return res;
    }

}
