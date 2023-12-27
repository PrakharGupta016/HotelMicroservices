package com.hotel.hotelservice.services;

import com.hotel.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel getSingle(String hotelId) ;

}
