package com.atguigu.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
* @Description: 返回前端的消息实体类
        * @Author: longjian
        * @Date: 9:29 2022/6/22
        */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
