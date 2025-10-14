package com.hexaware.bankmanagementsystem.repository;

import com.hexaware.bankmanagementsystem.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PaymentModuleRepository extends JpaRepository<Payment , Integer> {

}
