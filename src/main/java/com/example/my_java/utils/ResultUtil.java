package com.example.my_java.utils;

public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setData(object);
        result.setMsg("success");
        return result;
    }
}
