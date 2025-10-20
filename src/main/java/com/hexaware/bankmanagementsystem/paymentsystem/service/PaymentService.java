package com.hexaware.bankmanagementsystem.paymentsystem.service;

import com.hexaware.bankmanagementsystem.paymentsystem.enity.Payment;
import com.hexaware.bankmanagementsystem.paymentsystem.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PaymentService {
@Autowired
private JdbcTemplate jdbcTemplate;

@Autowired
private PaymentRepository paymentRepository;


    public List<Payment> getAllPayments() {
        List<Payment> paymentList = new ArrayList<>();
        paymentRepository.findAll().forEach(payment -> {paymentList.add(new Payment(payment.getId(),payment.getUser_name(),payment.getPayment_amt()));});
        return paymentList;
    }
    public Payment addPayment(com.hexaware.bankmanagementsystem.paymentsystem.model.Payment payment) {
        Payment paymentEntity= new Payment(payment.getId(),payment.getUser_name(),payment.getPayment_amt());

        Payment savedPayment= paymentRepository.save(paymentEntity);

        return  new Payment(savedPayment.getId(),savedPayment.getUser_name(),savedPayment.getPayment_amt());
    }


    public void runQuery(String query) {
        //jdbcTemplate.execute(query);//DDL and DML
        jdbcTemplate.update(query);
    }

    public Payment getPaymentById(Integer id) {
        Optional<Payment> optionalPayment= paymentRepository.findById(id);
        if(optionalPayment.isPresent()) {
            return new Payment(optionalPayment.get().getId(),optionalPayment.get().getUser_name(),optionalPayment.get().getPayment_amt());
        }
        return null;
    }

    public Payment updatePaymentById(Integer id, Payment payment) {
        Optional<Payment> optionalPayment= paymentRepository.findById(id);
        if(optionalPayment.isPresent()) {
            Payment paymentEntity= optionalPayment.get();
            paymentEntity.setPayment_amt(payment.getPayment_amt());
            paymentEntity.setUser_name(payment.getUser_name());
            paymentRepository.save(paymentEntity);
        }
        return new Payment(id,payment.getUser_name(),payment.getPayment_amt());
    }

    public void deletePaymentById(int id) {
        paymentRepository.deleteById(id);
    }

}
