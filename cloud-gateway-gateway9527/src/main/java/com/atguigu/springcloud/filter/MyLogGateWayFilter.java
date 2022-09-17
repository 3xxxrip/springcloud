package com.atguigu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@Slf4j
/** 
* @Description: 自定义过滤器，都要实现这两个接口，此外ServerWebExchange就是spring封装多少关于request，response那一套东西，换汤不还药
        * @Param: 
        * @return: 
        * @Author: longjian
        * @Date: 22:21 2022/8/7
        */

public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("执行了自定义的全局过滤器: MyLogGateWayFilter" + "hello"+new Date());
        //获取请求参数
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname==null){
            log.info("用户名为空，非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }
    //设置当前过滤器优先级，数值越大优先级越低
    @Override
    public int getOrder() {
        return 0;
    }
}
