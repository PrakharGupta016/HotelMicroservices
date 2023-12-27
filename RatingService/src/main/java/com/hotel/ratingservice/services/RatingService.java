package com.hotel.ratingservice.services;

import com.hotel.ratingservice.enitites.Rating;

import java.util.List;

public interface RatingService {
    Rating create(Rating rating);

    List<Rating> getAll();

    List<Rating> getByUser(String userId);

    List<Rating> getByHotel(String hotelId);


}
