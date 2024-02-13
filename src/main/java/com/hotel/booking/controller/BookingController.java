package com.hotel.booking.controller;

import com.hotel.booking.model.dto.booking.BookingDto;
import com.hotel.booking.model.dto.booking.BookingResponseDto;
import com.hotel.booking.service.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("v1/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    private ResponseEntity<List<BookingResponseDto>> getAllBooking(){
        try{
            List<BookingResponseDto> bookings = new ArrayList<>();
            return ResponseEntity.ok(bookings);
        }catch (NoSuchElementException e){
            System.out.println("Error in getAllBooking: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingResponseDto> findBookingById(@PathVariable String bookingId){
        try{
            return new ResponseEntity<>(bookingService.findBookingById(bookingId),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity("The booking " + bookingId + " does't in the daba base.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{bookingId}")
    public ResponseEntity<BookingResponseDto> saveBooking(@RequestBody BookingDto bookingDto){
        return new ResponseEntity<>(bookingService.saveBooking(bookingDto),HttpStatus.CREATED);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<Boolean> updateBooking(@PathVariable String bookingId, @RequestBody BookingDto bookingDto){
        try{
            Boolean isUpdateBooking = bookingService.updateBooking(bookingId, bookingDto);
            if(isUpdateBooking){
                return new ResponseEntity("the booking update is ok.", HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (NoSuchElementException e){
            return new ResponseEntity("The booking " + bookingId + " does't in the data base.",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Boolean> deleteBooking(@PathVariable String bookingId){
        return new ResponseEntity<>(bookingService.deleteBooking(bookingId), HttpStatus.OK);
    }
}
