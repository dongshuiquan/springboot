package com.dsq.advice;

import com.dsq.entity.ApiResult;
import com.dsq.entity.ApiResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aa on 2019/7/18.
 */

@ControllerAdvice(annotations = Controller.class)
@ResponseBody
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus
    public ApiResult exceptionHandler(Exception e) {
        return ApiResultGenerator.errorResult(e.getMessage(), e);
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus
    public ApiResult runtimeExceptionHandler(Exception e) {
        return ApiResultGenerator.errorResult(e.getMessage(), e);
    }


}
