package com.hexaware.beneficiary.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BeneficiaryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<com.hexaware.beneficiary.entity.Beneficiary> getAllBeneficiaries() {
        String sql = "SELECT * FROM beneficiary";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new com.hexaware.beneficiary.entity.Beneficiary(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("account_number"),
                rs.getString("ifsc_code"),
                rs.getString("bank_name")
        ));
    }

    public int addBeneficiary(com.hexaware.beneficiary.entity.Beneficiary beneficiary) {
        String sql = "INSERT INTO beneficiary (name, account_number, ifsc_code, bank_name) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                beneficiary.getName(),
                beneficiary.getAccountNumber(),
                beneficiary.getIfscCode(),
                beneficiary.getBankName());
    }

    public int deleteBeneficiaryById(int id) {
        String sql = "DELETE FROM beneficiary WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateBeneficiary(com.hexaware.beneficiary.entity.Beneficiary beneficiary) {
        String sql = "UPDATE beneficiary SET name = ?, account_number = ?, ifsc_code = ?, bank_name = ? WHERE id = ?";
        return jdbcTemplate.update(sql,
                beneficiary.getName(),
                beneficiary.getAccountNumber(),
                beneficiary.getIfscCode(),
                beneficiary.getBankName(),
                beneficiary.getId());
    }
}