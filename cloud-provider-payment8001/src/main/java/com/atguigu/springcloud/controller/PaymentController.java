package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private DiscoveryClient discoveryClient;
    /** 
    * @Description: 创建订单
            * @Param: [payment]
            * @return: com.atguigu.springcloud.pojo.CommonResult
            * @Author: longjian
            * @Date: 10:55 2022/6/22
            */
    @PostMapping("/payment/create")
//    requestbody注解的作用就是获取post请求里面的传过来的参数，以键值对的形式保存
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
    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service:services) {
            log.info(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
