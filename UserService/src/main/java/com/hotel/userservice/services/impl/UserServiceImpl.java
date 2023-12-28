package com.hotel.userservice.services.impl;

import com.hotel.userservice.entities.Hotel;
import com.hotel.userservice.entities.Ratings;
import com.hotel.userservice.entities.User;
import com.hotel.userservice.exceptions.ResourceNotFoundException;
import com.netflix.servo.util.ClockWithOffset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.hotel.userservice.repositories.UserRepository;
import com.hotel.userservice.services.UserService;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
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
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with " + userId + "not found"));
        Ratings[] objRatings = restTemplate.getForObject("http://localhost:8082/ratings/user/"+user.getUserId(), Ratings[].class);
        logger.info("{}",objRatings);
//        user.setRatings(obj);
        List<Ratings> obj = Arrays.stream(objRatings).toList();
       List<Ratings> ratings =  obj.stream().map(rating->{
           Hotel hotel = restTemplate.getForObject("http://localhost:8081/hotels/"+rating.getHotelId(), Hotel.class);
           rating.setHotel(hotel);
           return rating;
       }).collect(Collectors.toList());
        user.setRatings(ratings);
       return user;
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
