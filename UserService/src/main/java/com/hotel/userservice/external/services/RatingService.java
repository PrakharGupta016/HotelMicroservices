package com.hotel.userservice.external.services;

import com.hotel.userservice.entities.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @PostMapping("/ratings/")
    public Ratings createRating(Ratings rating );

    @PutMapping("/ratings/{ratingId}")
    public Ratings updateRating(@PathVariable  String ratingId,Ratings rating);

}
