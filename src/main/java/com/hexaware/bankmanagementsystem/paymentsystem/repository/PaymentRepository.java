package com.hexaware.bankmanagementsystem.paymentsystem.repository;

import com.hexaware.bankmanagementsystem.paymentsystem.enity.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment,Integer> {
}
