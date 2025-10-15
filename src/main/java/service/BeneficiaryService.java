package com.hexaware.beneficiary.service;

import com.hexaware.beneficiary.entity.Beneficiary;
import com.hexaware.beneficiary.repository.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryService {

    @Autowired
    private BeneficiaryRepository repository;

    public List<Beneficiary> findAll() {
        return repository.findAll();
    }

    public Beneficiary findById(Long id) {
        return repository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Beneficiary not found with id: " + id));
    }

    public Beneficiary save(Beneficiary beneficiary) {
        return repository.save(beneficiary);
    }

    public void delete(Long id) {
        repository.deleteById(Math.toIntExact(id));
    }
}