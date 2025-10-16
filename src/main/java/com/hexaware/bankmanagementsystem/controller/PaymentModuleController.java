package com.hexaware.bankmanagementsystem.controller;

import com.hexaware.bankmanagementsystem.entity.Payment;
import com.hexaware.bankmanagementsystem.service.PaymentModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentModuleController {
//@Autowired
//private PaymentModuleService paymentModuleService;
//    @GetMapping
//    public List<Payment> getAllPayments(){
//        return paymentModuleService.getAllPayments();
//    }
    private final PaymentModuleService paymentModuleService;
public PaymentModuleController(PaymentModuleService paymentModuleService){
    this.paymentModuleService =paymentModuleService;
}
@GetMapping
    public ResponseEntity<List<Payment>> getAllPayments(){
return new ResponseEntity<>(paymentModuleService.getAllPayments(), HttpStatus.OK);
}


//@PostMapping
//public ResponseEntity<Payment> addPayment(@RequestBody Payment payment){
//return new ResponseEntity<>(paymentModuleService.addPayment(payment),HttpStatus.OK);
//    }

//@GetMapping("/{id}")
//public ResponseEntity<Payment> getPayment(@PathVariable("id") Integer index){
//    return new ResponseEntity<>(paymentModuleService.getPayment(index),HttpStatus.OK);
//}

@PutMapping("/{id}")
public ResponseEntity<Payment> updatePaymentById(@PathVariable("id") Integer index,@RequestBody Payment payment){
    return new ResponseEntity<>(paymentModuleService.updatePaymentById(index,payment),HttpStatus.OK);
    }

@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentById(@PathVariable("id") int id){
        paymentModuleService.deletePaymentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
