package com.dsq.entity;

import java.util.List;
import java.util.Objects;

/**
 * Created by aa on 2019/7/17.
 */
public class ApiResultGenerator {

    public static ApiResult result(boolean flag, String msg, Object result, String jumpUrl, int rows, Throwable throwable) {
        ApiResult apiResult = ApiResult.newInstance();
        apiResult.setFlag(flag);
        apiResult.setMsg(msg == "" ? "success" : msg);
        apiResult.setResult(result);
        apiResult.setJumpUrl(jumpUrl);
        apiResult.setTime(System.currentTimeMillis());
        apiResult.setRows(rows);
        return apiResult;
    }

    public static ApiResult successResult(Object result) {
        int rows = 0;
        if(result instanceof List) {
            rows = ((List) result).size();
        }
        return result(true, "", result, "", rows, null);
    }

    public static ApiResult errorResult(Object result, Throwable throwable) {

        return result(true, Objects.toString(result), result, "", 0, throwable);
    }


}
