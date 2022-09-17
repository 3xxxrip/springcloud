package com.atguigu.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
* @Description: payment实体类
        * @Param:
        * @return:
        * @Author: longjian
        * @Date:9:27 2022/6/22
        */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
