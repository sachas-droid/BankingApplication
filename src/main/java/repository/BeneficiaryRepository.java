package com.hexaware.beneficiary.repository;

import com.hexaware.beneficiary.entity.BeneficiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BeneficiaryRepository extends JpaRepository<BeneficiaryEntity, Long> {

    // Find by Account Number
    Optional<BeneficiaryEntity> findByAccountNumber(String accountNumber);

    // Find by Ifsc code
    List<BeneficiaryEntity> findByIfscCode(String ifscCode);

    // Find by Beneficiary Name
    List<BeneficiaryEntity> findByName(String name);

    // Optional: Find by Beneficiary Name and Ifsc code
    List<BeneficiaryEntity> findByNameAndIfscCode(String name, String ifscCode);

    // Check if exists by Account Number
    boolean existsByAccountNumber(String accountNumber);
}