package com.gs.handler;

import com.gs.exception.BaseException;
import com.gs.exception.message.ErrorInfo;
import com.gs.web.BaseResult;
import com.gs.web.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 所有未捕抓错误返回系统出错
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResult handleException(Exception e) {
        logger.error("", e);
        return ResultUtils.error(ErrorInfo.UNKNOWN_ERROR.getCode(), ErrorInfo.UNKNOWN_ERROR.getDesc());
    }

    /**
     * 处理参数异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    @ResponseBody
    public BaseResult handleMissControllerParameter(Exception e) {
        return ResultUtils.error(ErrorInfo.MISS_PARAM.getCode(), ErrorInfo.MISS_PARAM.getDesc());
    }

    /**
     * 处理业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public BaseResult handleBaseException(BaseException e) {
        logger.error("", e);
        return ResultUtils.error(e.getErrorInfo().getCode(), e.getErrorInfo().getDesc());
    }

}