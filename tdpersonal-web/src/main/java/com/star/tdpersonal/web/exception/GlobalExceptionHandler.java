package com.star.tdpersonal.web.exception;

import com.alibaba.fastjson.JSONObject;
import com.star.tdpersonal.common.util.common.LoggerNames;
import com.star.tdpersonal.common.util.enums.ErrorMessageEnums;
import com.star.tdpersonal.common.util.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @program: tdpersonal
 * @description: 统一异常处理
 * @author: xinsida
 * @create: 2021-06-20 20:24
 **/
@RestControllerAdvice
@Slf4j(topic = LoggerNames.COMMON_ERROR)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = TdPersonalSystemBizException.class)
    public ResultVO arkTookBoxSystemBizExceptionHandler(HttpServletRequest request, TdPersonalSystemBizException e) {
        Map<?, ?> inputParamMap = request.getParameterMap();
        String requestPath = request.getRequestURI();
        log.error("path = {} time = {}, param = {}",
                requestPath, System.currentTimeMillis(),
                JSONObject.toJSONString(inputParamMap), e);
        return ResultVO.failed(e.getErrorCode(), e.getErrorMsg());
    }

    @ExceptionHandler(value = Exception.class)
    public ResultVO exceptionHandler(HttpServletRequest request, NullPointerException e) {
        Map<?, ?> inputParamMap = request.getParameterMap();
        String requestPath = request.getRequestURI();
        log.error("path = {} time = {}, param = {}",
                requestPath, System.currentTimeMillis(),
                JSONObject.toJSONString(inputParamMap), e);
        return ResultVO.failed(ErrorMessageEnums.SYSTEM_ERROR);
    }

}
