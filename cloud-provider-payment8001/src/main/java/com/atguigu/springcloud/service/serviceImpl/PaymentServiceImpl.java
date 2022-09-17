package com.atguigu.springcloud.service.serviceImpl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* @Description: payment实体类的服务类
        * @Author: longjian
        * @Date: 10:07 2022/6/22
        */

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
