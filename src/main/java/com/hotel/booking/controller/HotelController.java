package com.hotel.booking.controller;


import com.hotel.booking.model.dto.booking.BookingDto;
import com.hotel.booking.model.dto.booking.BookingResponseDto;
import com.hotel.booking.model.dto.hotel.HotelDto;
import com.hotel.booking.model.dto.hotel.HotelResponseDto;
import com.hotel.booking.service.booking.BookingService;
import com.hotel.booking.model.dto.hotel.HotelDto;
import com.hotel.booking.model.dto.hotel.HotelResponseDto;
import com.hotel.booking.service.hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/v1/hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<HotelResponseDto>> getAllHotels() {
        try {
            List<HotelResponseDto> hotelResponseDto = hotelService.getAllHotels();
            return ResponseEntity.ok(hotelResponseDto);
        } catch (Exception e) {
            System.err.println("Error in getAllHotels: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponseDto> findHotelById(@PathVariable String idHotel) {
        try {
            return new ResponseEntity<>(hotelService.findHotelById(idHotel), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("The hotel " + idHotel + " doesn't exist in the database.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<HotelResponseDto> saveHotel(@RequestBody HotelDto hotelDto) {
        return new ResponseEntity<>(hotelService.saveHotel(hotelDto), HttpStatus.CREATED);
    }

    @PutMapping("/{idHotel}")
    public ResponseEntity<HotelResponseDto> updateHotel(@PathVariable String idHotel, @RequestBody HotelDto hotelDto) {
        try {
            Boolean isUpdateHotel = hotelService.updateHotel(idHotel, hotelDto);

            if (isUpdateHotel) {
                return new ResponseEntity("The hotel update is successful.", HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity("The hotel " + idHotel + " doesn't exist in the database.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idHotel}")
    public ResponseEntity<Boolean> deleteHotel(@PathVariable String idHotel) {
        return new ResponseEntity<>(hotelService.deleteHotel(idHotel), HttpStatus.OK);
    }

}