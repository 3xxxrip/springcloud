package com.atguigu.springcloud.services;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/** 
* @Description: 微服务组件
        * @Param: 
        * @return: 
        * @Author: longjian
        * @Date: 17:53 2022/7/27
        */

@Component
// 服务提供者提供的服务名称，即 application.name，就是我们要用的微服务名称，以方便找到注册在eureka里面的相应服务
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {
    //对应服务提供者（8001、8002）Controller 中定义的方法，也就是我们要调用的微服务方法
    @RequestMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
