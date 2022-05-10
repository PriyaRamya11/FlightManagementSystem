package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        User createuser = userService.createUser(user);
        return user;
    }

    @DeleteMapping("/{userid}/delete")
    public ResponseEntity<?> deleteUserById(@PathVariable("userid") String userid) {
        userService.deleteUserById(userid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<?> getuserById(@PathVariable String userid){
        return  ResponseEntity.status(HttpStatus.OK).body(userService.getsingleUser(userid));
    }
}
