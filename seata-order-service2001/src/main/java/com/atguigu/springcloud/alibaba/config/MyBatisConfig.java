package com.atguigu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
/**
* @Description: 其实这个不写应该也没什么事
        * @Param:
        * @return:
        * @Author: longjian
        * @Date: 15:04 2022/9/4
        */

@Configuration
@MapperScan("com.atguigu.springcloud.alibaba.dao")
public class MyBatisConfig {
}
