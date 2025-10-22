package com.hexaware.bankmanagementsystem.paymentsystem.controller;

import com.hexaware.bankmanagementsystem.paymentsystem.enity.Payment;
import com.hexaware.bankmanagementsystem.paymentsystem.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {

        this.paymentService = paymentService;
    }


//    @GetMapping
//    public List<Payment> getAllPayments() {
//        return paymentService.getAllPayments();
//    }
    @GetMapping
    public ResponseEntity<List<Payment>>  getAllPayments() {
        return new ResponseEntity<>(paymentService.getAllPayments(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Payment> addPayment(@RequestBody com.hexaware.bankmanagementsystem.paymentsystem.model.Payment payment){
        return new ResponseEntity<>(paymentService.addPayment(payment),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable("id") Integer id){
        return new ResponseEntity<>(paymentService.getPaymentById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable("id") Integer id,@RequestBody Payment payment){

        return new ResponseEntity<>(paymentService.updatePaymentById(id,payment),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentById(@PathVariable("id") int id){
        paymentService.deletePaymentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/runQuery")
    public ResponseEntity<Void> runQuery(@RequestBody String query){
        paymentService.runQuery(query);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
