package com.hotel.userservice.services;

import com.hotel.userservice.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUser();

    User getUser(String userId);

    void deteleUser(String userId);

}
