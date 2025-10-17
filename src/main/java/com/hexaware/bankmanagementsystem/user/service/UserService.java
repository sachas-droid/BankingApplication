package com.hexaware.bankmanagementsystem.user.service;


import com.hexaware.bankmanagementsystem.user.model.User;
import com.hexaware.bankmanagementsystem.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(user -> {userList.add(new User(user.getUserId(),user.getUserName(),user.getUserAddress(),user.getUserPhoneNumber()));});
        return userList;

    }

    public User addUser(User user) {

        com.hexaware.bankmanagementsystem.user.entity.User savedUser= userRepository.save(new com.hexaware.bankmanagementsystem.user.entity.User(user.getUserId(),user.getUserName(),user.getUserAddress(),user.getUserPhoneNumber()));
        return new User(user.getUserId(),user.getUserName(),user.getUserAddress(),user.getUserPhoneNumber());
    }

    public User getUserbyId(Integer id) {
        Optional<com.hexaware.bankmanagementsystem.user.entity.User> optionalUser= userRepository.findById(id);
        if(optionalUser.isPresent()) {
            com.hexaware.bankmanagementsystem.user.entity.User userEntity = optionalUser.get();
            return new User(userEntity);
        }
        return null;
    }

    public User updateUserById(Integer id, User user) {
        Optional<com.hexaware.bankmanagementsystem.user.entity.User> optionalUser= userRepository.findById(id);
        if(optionalUser.isPresent()) {
            com.hexaware.bankmanagementsystem.user.entity.User userEntity = optionalUser.get();
            userEntity.setUserName(user.getUserName());
            userEntity.setUserAddress(user.getUserAddress());
            userEntity.setUserPhoneNumber(user.getUserPhoneNumber());

            userRepository.save(userEntity);
            return new User(userEntity);

        }
        return null;
    }

    public void deleteUserById(Integer id) {
        Optional<com.hexaware.bankmanagementsystem.user.entity.User> optionalUser= userRepository.findById(id);
        if(optionalUser.isPresent()) {
            com.hexaware.bankmanagementsystem.user.entity.User userEntity = optionalUser.get();
            userRepository.delete(userEntity);
        }
    }
}