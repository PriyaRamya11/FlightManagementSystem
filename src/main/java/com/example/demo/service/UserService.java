package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();

    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(String userid) {
        User user = userRepository.getById(userid);
        userRepository.delete(user);
    }

    public User getsingleUser(String userid) {
        return userRepository.getUserByUserid(userid);
    }
}
