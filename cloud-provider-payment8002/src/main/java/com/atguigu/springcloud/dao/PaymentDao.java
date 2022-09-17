package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @Description: Payment表对应的dao接口
        * @Author: longjian
        * @Date: 9:34 2022/6/22
        */
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
