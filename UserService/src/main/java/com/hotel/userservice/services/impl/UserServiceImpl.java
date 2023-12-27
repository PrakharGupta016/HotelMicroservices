package com.hotel.userservice.services.impl;

import com.hotel.userservice.entities.User;
import com.hotel.userservice.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.userservice.repositories.UserRepository;
import com.hotel.userservice.services.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setUserId(id);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty())
        {
            throw new ResourceNotFoundException("user with " + userId + "not found");
        }
        return user.get();
    }

    @Override
    public void deteleUser(String userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty())
        {
            throw new ResourceNotFoundException("user with " + userId + "not found");
        }
        userRepository.delete(user.get());
    }


}
