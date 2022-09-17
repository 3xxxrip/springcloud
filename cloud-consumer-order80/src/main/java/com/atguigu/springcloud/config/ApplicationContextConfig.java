package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/** 
* @Description: 配置restTemplate，是spring提供的用于调用其他接口服务的类
        * @Param: 
        * @return: 
        * @Author: longjian
        * @Date: 21:14 2022/6/22
        */

@Configuration
public class ApplicationContextConfig {
    //这个注解的作用是赋予restTemplate负载均衡的能力，在配合eureka使用的时候同一个服务是集群形式的时候，就可以轮询哪个可以用，正确找到地址
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
