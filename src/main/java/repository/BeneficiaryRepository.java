package com.hexaware.beneficiary.repository;

import com.hexaware.beneficiary.entity.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeneficiaryRepository extends JpaRepository<com.hexaware.beneficiary.entity.Beneficiary, Integer> {
    com.hexaware.beneficiary.entity.Beneficiary findByAccountNumber(String accountNumber);
    List<com.hexaware.beneficiary.entity.Beneficiary> findByBankName(String bankName);
}