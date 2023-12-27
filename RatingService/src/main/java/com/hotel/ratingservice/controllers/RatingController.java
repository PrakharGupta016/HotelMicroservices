package com.hotel.ratingservice.controllers;

import com.hotel.ratingservice.enitites.Rating;
import com.hotel.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PostMapping("/")
    ResponseEntity<Rating> create(@RequestBody Rating rating)
    {
        return new ResponseEntity<>(ratingService.create(rating), HttpStatus.CREATED);
    }
    @GetMapping("/")
    ResponseEntity<List<Rating>> getAll()
    {
        return new ResponseEntity<>(ratingService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    ResponseEntity<List<Rating>> getAllByUserId(@PathVariable String userId)
    {
        return new ResponseEntity<>(ratingService.getByUser(userId),HttpStatus.OK);
    }
    @GetMapping("/hotel/{hotelId}")
    ResponseEntity<List<Rating>> getAllByHotelId(@PathVariable String hotelId)
    {
        return new ResponseEntity<>(ratingService.getByHotel(hotelId),HttpStatus.OK);
    }
}
