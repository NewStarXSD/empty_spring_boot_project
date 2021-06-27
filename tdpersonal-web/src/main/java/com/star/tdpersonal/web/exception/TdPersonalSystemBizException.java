package com.star.tdpersonal.web.exception;

import com.star.tdpersonal.common.util.enums.ErrorMessageEnums;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: tdpersonal
 * @description: 统一业务异常
 * @author: xinsida
 * @create: 2021-06-20 20:20
 **/
@Data
@Accessors(chain = true)
public class TdPersonalSystemBizException extends RuntimeException {

    /**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    /**
     * 根据枚举创建异常
     *
     * @param errorMessageEnums
     */
    public TdPersonalSystemBizException(ErrorMessageEnums errorMessageEnums) {
        this.errorCode = errorMessageEnums.getErrorCode();
        this.errorMsg = errorMessageEnums.getErrorMsg();
    }

    /**
     * 根据错误码和错误信息自定义异常
     *
     * @param errorCode
     * @param errorMsg
     */
    public TdPersonalSystemBizException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
