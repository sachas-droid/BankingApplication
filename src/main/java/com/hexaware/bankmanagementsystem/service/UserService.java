package com.hexaware.bankmanagementsystem.service;

import com.hexaware.bankmanagementsystem.dao.UserDao;
import com.hexaware.bankmanagementsystem.model.User;
import com.hexaware.bankmanagementsystem.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {

        com.hexaware.bankmanagementsystem.entity.User savedUser= userRepository.save(new com.hexaware.bankmanagementsystem.entity.User(user.getUserId(),user.getUserName(),user.getUserAddress(),user.getUserPhoneNumber()));
        return new User(user.getUserId(),user.getUserName(),user.getUserAddress(),user.getUserPhoneNumber());
    }

    public User getUserbyId(Integer id) {
        Optional<com.hexaware.bankmanagementsystem.entity.User> optionalUser= userRepository.findById(id);
        if(optionalUser.isPresent()) {
            com.hexaware.bankmanagementsystem.entity.User userEntity = optionalUser.get();
            return new User(userEntity);
        }
        return null;
    }

    public User updateUserById(Integer id, User user) {
        Optional<com.hexaware.bankmanagementsystem.entity.User> optionalUser= userRepository.findById(id);
        if(optionalUser.isPresent()) {
            com.hexaware.bankmanagementsystem.entity.User userEntity = optionalUser.get();
            userEntity.setUserName(user.getUserName());
            userEntity.setUserAddress(user.getUserAddress());
            userEntity.setUserPhoneNumber(user.getUserPhoneNumber());

            userRepository.save(userEntity);
            return new User(userEntity);

        }
        return null;
    }

    public void deleteUserById(Integer id) {
        Optional<com.hexaware.bankmanagementsystem.entity.User> optionalUser= userRepository.findById(id);
        if(optionalUser.isPresent()) {
            com.hexaware.bankmanagementsystem.entity.User userEntity = optionalUser.get();
            userRepository.delete(userEntity);
        }
    }
}