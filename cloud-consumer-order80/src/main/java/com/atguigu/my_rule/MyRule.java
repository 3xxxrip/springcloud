package com.atguigu.my_rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* @Description:  切换ribbon的负载均衡策略，切换为random，如果需要切换负载均衡策略只要把该策略加入到ioc容器里面即可
        * @Param:
        * @return:
        * @Author: longjian
        * @Date: 11:42 2022/7/26
        */

@Configuration
public class MyRule{
    @Bean
    public IRule getMyRule(){
        return new RandomRule();
    }
}
