package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    /** 
    * @Description: 创建订单
            * @Param: [payment]
            * @return: com.atguigu.springcloud.pojo.CommonResult
            * @Author: longjian
            * @Date: 10:55 2022/6/22
            */
    @RequestMapping("/payment/zk")
    public String paymentZk(){
        return "springcloud with zookeeper: "+serverPort+"\t"+ UUID.randomUUID();
    }
}
