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
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers() {
        String sql = "select * from User";


        return jdbcTemplate.query(sql,((rs, rowNum) -> new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4))));
    }
}