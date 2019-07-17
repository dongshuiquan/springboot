package com.dsq.advice;

import com.dsq.entity.ApiResult;
import com.dsq.entity.ApiResultGenerator;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aa on 2019/7/18.
 */

@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseStatus
    public ApiResult runtimeExceptionHandler(Exception e) {
        return ApiResultGenerator.errorResult(e.getMessage(), e);
    }
}
