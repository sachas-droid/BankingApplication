package com.hexaware.bankmanagementsystem.service;

import com.hexaware.bankmanagementsystem.entity.BeneficiaryEntity;
import com.hexaware.bankmanagementsystem.model.Beneficiary;
import com.hexaware.bankmanagementsystem.repository.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BeneficiaryService {

    @Autowired
    private BeneficiaryRepository repository;

    //  Create new com.hexaware.bankmangementsystem.beneficiary
    public Beneficiary create(Beneficiary model) {
        BeneficiaryEntity entity = toEntity(model);
        BeneficiaryEntity saved = repository.save(entity);
        return toModel(saved);
    }

    // Get all beneficiaries
    public List<Beneficiary> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    //  Get com.hexaware.bankmangementsystem.beneficiary by ID
    public Optional<Beneficiary> getById(Long id) {
        return repository.findById(id)
                .map(this::toModel);
    }

    //  Update com.hexaware.bankmangementsystem.beneficiary by ID
    public Optional<Beneficiary> update(Long id, Beneficiary model) {
        return repository.findById(id).map(existing -> {
            existing.setName(model.getName());
            existing.setAccountNumber(model.getAccountNumber());
            existing.setIfscCode(model.getIfscCode());
            BeneficiaryEntity updated = repository.save(existing);
            return toModel(updated);
        });
    }

    //  Delete com.hexaware.bankmangementsystem.beneficiary by ID
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private BeneficiaryEntity toEntity(Beneficiary model) {
        BeneficiaryEntity entity = new BeneficiaryEntity();

        // Only set ID if updating; for create, let DB auto-generate
        if (model.getId() != null) {
            entity.setId(model.getId());
        }

        entity.setName(model.getName());
        entity.setAccountNumber(model.getAccountNumber());
        entity.setIfscCode(model.getIfscCode());
        return entity;
    }

    private Beneficiary toModel(BeneficiaryEntity entity) {
        return new Beneficiary(
                entity.getId(),
                entity.getName(),
                entity.getAccountNumber(),
                entity.getIfscCode()
        );
    }
}