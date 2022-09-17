package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.handler.CustomerBlockHandler;
import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {
    /*其实这两个方法老师就是想说，如果在sentinel里面按照url配置，就会直接调用系统默认的兜底方案，如果按照注解中的value来配置的留空规则，就会调用我们自定义的兜底方案，就是说一定
    * 要在sentinel控制台里面正配置的资源要和我们在SentinelResource注解里面写的名字一样才会正确调用blockhandler方法*/
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource()
    {
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }
    public CommonResult handleException(BlockException exception)
    {
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl()
    {
        return new CommonResult(200,"按url限流测试OK",new Payment(2020L,"serial002"));
    }

/**
 * 自定义通用的限流处理逻辑，
 blockHandlerClass = CustomerBlockHandler.class
 blockHandler = handleException2
 上述配置：找CustomerBlockHandler类里的handleException2方法进行兜底处理
 */
    /**
     * 自定义通用的限流处理逻辑
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handleException2")
    public CommonResult customerBlockHandler()
    {
        return new CommonResult(200,"按客户自定义限流处理逻辑");
    }


}
