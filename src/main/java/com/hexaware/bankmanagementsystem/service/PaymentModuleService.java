package com.hexaware.bankmanagementsystem.service;

import com.hexaware.bankmanagementsystem.dao.PaymentModuleDao;
import com.hexaware.bankmanagementsystem.entity.Payment;
import com.hexaware.bankmanagementsystem.repository.PaymentModuleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PaymentModuleService {
    @Autowired
private JdbcTemplate jdbcTemplate;
   @Autowired
private PaymentModuleDao paymentModuleDao;

@Autowired
private PaymentModuleRepository paymentModuleRepository;

Logger logger = LoggerFactory.getLogger(PaymentModuleService.class);

static List<Payment> paymentList = new ArrayList<>();
static {
paymentList.add(new Payment(1,"sayan",100));
    paymentList.add(new Payment(2,"sayan2",200));
    paymentList.add(new Payment(3,"sayan3",300));

}
public List<Payment> getAllPayments() {
    List<Payment> paymentList = new ArrayList<>();
paymentModuleRepository.findAll().forEach( payment -> {paymentList.add(new Payment(payment.getAccountId(),payment.getUserName(),payment.getPaymentAmount()));});
return  paymentList;
}

}
