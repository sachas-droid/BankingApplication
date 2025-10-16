package com.hexaware.bankmanagementsystem.dao;

import com.hexaware.bankmanagementsystem.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class PaymentModuleDao {
@Autowired
private JdbcTemplate jdbcTemplate;

public List<Payment> getAllPayment(){
    String sql ="select * from payment";
//return jdbcTemplate.query(sql, new RowMapper<Payment>() {
//    @Override
//    public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
//        return new Payment(rs.getInt(1), rs.getString(2));
//    }
//});

return jdbcTemplate.query(sql,((rs, rowNum) -> new Payment(rs.getInt(1),rs.getString(2),rs.getInt(3))));
}
}
