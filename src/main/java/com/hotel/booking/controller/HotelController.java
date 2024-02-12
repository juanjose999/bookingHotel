package com.hotel.booking.controller;

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
@RequestMapping("/v1/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<HotelResponseDto>> getAllHotel(){
        try{
            List<HotelResponseDto> hoteles = hotelService.getAllHotel();
            return ResponseEntity.ok(hoteles);
        }catch (Exception e){
            System.err.println("error in the getAllHotels: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{HotelId}")
    public ResponseEntity<HotelResponseDto> findHotelById(@PathVariable String hotelId){
        try{
            return new ResponseEntity<>(hotelService.findHotelById(hotelId), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity("the user " + hotelId + " doesn't in the data base.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{hotelId}")
    public ResponseEntity<Boolean> updateHotel(@PathVariable String hotelId, @RequestBody HotelDto hotelDto){
        try{
            Boolean isUpdateHotel = hotelService.updateHotel(hotelId, hotelDto);
            if(isUpdateHotel){
                return new ResponseEntity("the hotel update is ok.", HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (NoSuchElementException e){
            return new ResponseEntity("the user " + hotelId + " doesn't in the data base." , HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String hotelId){
        return new ResponseEntity<>(hotelService.deleteHotel(hotelId), HttpStatus.OK);
    }
}
