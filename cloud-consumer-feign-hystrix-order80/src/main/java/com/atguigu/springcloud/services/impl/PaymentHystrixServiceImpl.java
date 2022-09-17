package com.atguigu.springcloud.services.impl;

import com.atguigu.springcloud.services.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务器down机paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务器down机paymentInfo_TimeOut";
    }
}
