package com.hexaware.beneficiary.controller;

import com.hexaware.beneficiary.entity.Beneficiary;
import com.hexaware.beneficiary.service.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/beneficiaries")
public class BeneficiaryController {
    @Autowired
    private BeneficiaryService service;
    @GetMapping
    public List<Beneficiary> getAll() {
        List<Beneficiary> entities = service.findAll();
        return entities.stream()
                .map(this::convertToModel)
                .toList(); // Java 16+, use .collect(Collectors.toList()) if on Java 8
    }
    @PostMapping
    public Beneficiary create(@RequestBody Beneficiary model) {
        Beneficiary entity = convertToEntity(model);
        Beneficiary saved = service.save(entity);
        return convertToModel(saved);
    }
    private Beneficiary convertToEntity(Beneficiary model) {
        Beneficiary entity = new Beneficiary();
        entity.setId(Long.valueOf(model.getId())); // Make sure both use Long!
        entity.setName(model.getName());
        entity.setAccountNumber(model.getAccountNumber());
        entity.setBankName(model.getBankName());
        entity.setIfscCode(model.getIfscCode());
        return entity;
    }
    private Beneficiary convertToModel(Beneficiary entity) {
        Beneficiary model = new Beneficiary();
        model.setId(Long.valueOf(entity.getId()));
        model.setName(entity.getName());
        model.setAccountNumber(entity.getAccountNumber());
        model.setBankName(entity.getBankName());
        model.setIfscCode(entity.getIfscCode());
        return model;
    }
}
