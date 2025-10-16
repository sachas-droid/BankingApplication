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
import java.util.Optional;


@Service
public class PaymentModuleService {
    @Autowired
private JdbcTemplate jdbcTemplate;
//   @Autowired
//private PaymentModuleDao paymentModuleDao;

@Autowired
private PaymentModuleRepository paymentModuleRepository;

Logger logger = LoggerFactory.getLogger(PaymentModuleService.class);

//static List<Payment> paymentList = new ArrayList<>();
//static {
//paymentList.add(new Payment(1,"sayan",100));
//    paymentList.add(new Payment(2,"sayan2",200));
//    paymentList.add(new Payment(3,"sayan3",300));
//
//}
//public List<Payment> getAllPayments() {
//    return paymentModuleRepository.findAll();
//}
public List<Payment> getAllPayments() {
    List<Payment> paymentList = new ArrayList<>();
paymentModuleRepository.findAll().forEach( payment -> {paymentList.add(new Payment(payment.getAccountId(),payment.getUserName(),payment.getPaymentAmount()));});
return  paymentList;
}

//public Payment addPayment(Payment payment){
//com.hexaware.bankmanagementsystem.entity.Payment paymentEntity =new com.hexaware.bankmanagementsystem.entity.Payment(payment.getAccountId(),payment.getUserName(),payment.getPaymentAmount());
//paymentEntity.setAccount(accountService.getAccount(payment.getAccountId()));
//paymentEntity.setUser(UserService.getUser(payment.getUserName()));
//how to add payment amount?
//com.hexaware.bankmanagementsystem.entity.Payment  savedPayment = paymentModuleRepository.save(paymentEntity);
//retur new Payment(savedPayment.getAccountId(),savedPayment.getUserName(),savedPayment.getPaymentAmount());
//}

//public Payment getPayment(Integer id) {return paymentList.get(id);}
//public Payment updatePayment(Integer index, Payment payment){
//paymentList.set(index,payment);
//return payment;
//    }
//public void runQuery(String query){
//jdbcTemplate.update(query);
//}

public Payment getPaymentById(Integer id){
    Optional<com.hexaware.bankmanagementsystem.entity.Payment> optionalPayment =paymentModuleRepository.findById(id);
if(optionalPayment.isPresent()){
return new Payment(optionalPayment.get().getAccountId(), optionalPayment.get().getUserName(), optionalPayment.get().getPaymentAmount());
}
return null;
}

public Payment updatePaymentById(Integer id, Payment payment){
Optional<com.hexaware.bankmanagementsystem.entity.Payment> optionalPayment = paymentModuleRepository.findById(id);
if(optionalPayment.isPresent()){
com.hexaware.bankmanagementsystem.entity.Payment paymentEntity = optionalPayment.get();
paymentEntity.setPaymentAmount(payment.getPaymentAmount());
paymentModuleRepository.save(paymentEntity);
}
return new Payment(id,payment.getUserName(),payment.getPaymentAmount());
}

public void deletePaymentById(int id){paymentModuleRepository.deleteById(id);}

}
