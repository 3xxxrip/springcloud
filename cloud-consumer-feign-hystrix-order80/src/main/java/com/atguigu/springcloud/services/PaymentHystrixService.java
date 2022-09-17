package com.atguigu.springcloud.services;


import com.atguigu.springcloud.services.impl.PaymentHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/** 
* @Description: 这种通过openfeign来实现服务降级的只需要在fallback里面写好当前接口的一个类，并且类要重写接口方法，方法内容就是这两个远程方法在出现异常的时候会处理的逻辑
        * @Param: 
        * @return: 
        * @Author: longjian
        * @Date: 23:25 2022/8/4
        */

@Component
//解耦降级逻辑
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentHystrixServiceImpl.class)
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
