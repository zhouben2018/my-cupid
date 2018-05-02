package com.zben.cupid.result;

import lombok.Data;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午1:58 2018/4/26
 */
@Data
public class Result<T> {

    private boolean success = false;
    private T data;
    private String msg = "";
    private String code = "500";

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setData(data);
        result.setSuccess(true);
        result.setCode("200");
        result.setMsg("success");
        return result;
    }

    public static <T> Result<T> fail(String code, String msg) {
        Result<T> result = new Result<T>();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

























