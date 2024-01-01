package com.hotel.userservice;

import com.hotel.userservice.entities.Ratings;
import com.hotel.userservice.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {
    @Autowired
    RatingService ratingService;
    @Test
    void contextLoads() {
    }
//    @Test
//    void createRating()
//    {   Ratings ratings = Ratings.builder().rating(9).build();
//        ratingService.createRating(ratings);
//        System.out.println(ratings);
//    }

}
