package com.hotel.ratingservice.services.impl;

import com.hotel.ratingservice.enitites.Rating;
import com.hotel.ratingservice.repositories.RatingRepository;
import com.hotel.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating create(Rating rating) {
        String randomId = UUID.randomUUID().toString();
        rating.setRatingId(randomId);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getByUser(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getByHotel(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
