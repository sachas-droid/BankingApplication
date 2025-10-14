package com.hexaware.bankmanagementsystem.controller;

import com.hexaware.bankmanagementsystem.entity.Payment;
import com.hexaware.bankmanagementsystem.service.PaymentModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentModuleController {
@Autowired
private PaymentModuleService paymentModuleService;

@GetMapping
public List<Payment> getPayments() {
return paymentModuleService.getAllPayments();
}
}
