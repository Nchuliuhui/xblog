package com.xp.util;

import com.xp.dto.Result;

/**
 * Created by xp on 2017/8/6.
 */
public class ResultUtil {

    public static Result success(String msg , Object data){
        Result result = new Result();
        result.setCode(200);
        result.setSuccess(true);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public static Result success(Object data){
        return ResultUtil.success("操作成功!",data);
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setSuccess(false);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

}
