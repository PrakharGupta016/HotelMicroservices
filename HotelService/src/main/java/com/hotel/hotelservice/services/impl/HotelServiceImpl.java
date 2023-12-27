package com.hotel.hotelservice.services.impl;

import com.hotel.hotelservice.entities.Hotel;
import com.hotel.hotelservice.repositories.HotelRepository;
import com.hotel.hotelservice.services.HotelService;
import com.hotel.hotelservice.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        String randomId = UUID.randomUUID().toString();
        hotel.setHotelId(randomId);
        return   hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getSingle(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("hotel not found with id "+hotelId));
    }
}
