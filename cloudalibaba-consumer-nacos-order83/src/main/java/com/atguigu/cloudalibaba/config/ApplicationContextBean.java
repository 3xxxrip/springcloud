package com.atguigu.cloudalibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/** 
* @Description: 把RestTemplate注入到ioc容器并且开启负载均衡,nacos支持的是spring原生的loadbalance
        * @Param: 
        * @return: 
        * @Author: longjian
        * @Date: 21:11 2022/8/18
        */

@Configuration
public class ApplicationContextBean {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

}
