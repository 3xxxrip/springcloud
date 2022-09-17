package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() throws InterruptedException {
        return "----testA";
    }
    @GetMapping("/testB")
    public String testB() throws InterruptedException {
        Thread.sleep(8000);
        return "------testB";
    }
    //测试降级规则RT,qps要>=5
    @GetMapping("/testD")
    public String testD() throws InterruptedException {
        Thread.sleep(1000);
        log.info("testD,测试RT"+Thread.currentThread().getName());
        return "------testD";
    }
    //测试降级规则异常比例,qps要>=5
    @GetMapping("/testE")
    public String testE() throws InterruptedException {
        log.info("testE");
        int age=10/0;
        return "------testE";
    }
    //测试异常数量，时间窗口期一定要大于一分钟，因为异常数量是按照分钟来统计的，如果小于一分钟，则在窗口期之后还有可能继续进入熔断状态
    //懒得写代码了，就是和上面差不多的，有异常的

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealHandler_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1, @RequestParam(value = "p2",required = false) String p2){
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1+p2);
        return "testHotKey";
    }
    public String dealHandler_testHotKey(String p1, String p2, BlockException exception)
    {
        return "-----dealHandler_testHotKey";
    }
}
