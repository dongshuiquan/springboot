package com.dsq.result;

/**
 * Created by aa on 2019/7/21.
 */
public class ApiResult {

    public ApiResult(String msg) {
        this.msg = msg;
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
