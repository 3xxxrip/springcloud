package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import org.springframework.stereotype.Component;
/*这个组件是给openFeign准备的，如果没有在调用远程接口的时候出现的异常，这个类可以作为fallback类返回调用者，在@FeignClient注解里面的fallback配置*/
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回,没有该流水信息",new Payment(id, "errorSerial......"));
    }
}
