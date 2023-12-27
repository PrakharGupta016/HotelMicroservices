package com.hotel.hotelservice.controllers;

import com.hotel.hotelservice.entities.Hotel;
import com.hotel.hotelservice.services.HotelService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping("/")
    ResponseEntity<Hotel> create(@RequestBody Hotel hotel)
    {
        return new ResponseEntity<>(hotelService.create(hotel), HttpStatus.CREATED);
    }
    @GetMapping("/")
    ResponseEntity<List<Hotel>> getAll()
    {
        return new ResponseEntity<>(hotelService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/{hotelId}")
    ResponseEntity<Hotel> getAll(@PathVariable String hotelId)
    {
        return new ResponseEntity<>(hotelService.getSingle(hotelId),HttpStatus.OK);
    }
}
