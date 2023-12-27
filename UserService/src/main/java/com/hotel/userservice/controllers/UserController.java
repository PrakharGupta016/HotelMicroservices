package com.hotel.userservice.controllers;

import com.hotel.userservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hotel.userservice.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/")
    ResponseEntity<User> createUser(@RequestBody User user)
    {

        User createdUser = userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping("/{userId}")
    ResponseEntity<User> getSingleUser(@PathVariable String userId)
    {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/")
    ResponseEntity<List<User>> getAllUser()
    {
        List<User> user = userService.getAllUser();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }



}
