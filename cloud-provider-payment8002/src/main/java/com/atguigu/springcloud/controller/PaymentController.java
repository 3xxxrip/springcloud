package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    /** 
    * @Description: 创建订单
            * @Param: [payment]
            * @return: com.atguigu.springcloud.pojo.CommonResult
            * @Author: longjian
            * @Date: 10:55 2022/6/22
            */
    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        //springmvc接受json参数需要在参数上面加@RequestBody注解
        int result = paymentService.create(payment);
        log.info("插入结果:"+result);
        if(result>0){
            return new CommonResult(200, "插入数据库成功"+serverPort,result);
        }else {
            return new CommonResult(444, "插入数据库失败",null);
        }
    }
    /** 
    * @Description: 
            * @Param: [id]
            * @return: com.atguigu.springcloud.pojo.CommonResult
            * @Author: longjian
            * @Date:10:55 2022/6/22
            */
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(null!=payment){
            return new CommonResult(200, "查询成功"+serverPort,payment);
        }else{
            return new CommonResult(444, "没有对应记录",null);
        }
    }
}
