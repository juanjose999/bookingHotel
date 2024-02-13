package com.hotel.booking.controller;

import com.hotel.booking.model.Booking;
import com.hotel.booking.model.dto.booking.BookingDto;
import com.hotel.booking.model.dto.booking.BookingResponseDto;
import com.hotel.booking.service.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/v1/bookings")
public class BookingsController {
    private final BookingService bookingService;
    @Autowired
    public BookingsController(BookingService bookingService){
        this.bookingService=bookingService;
    }

    @GetMapping
    public ResponseEntity<List<BookingResponseDto>> getAllBookings() {
        try {
            return ResponseEntity.ok(bookingService.getAllBookings());
        } catch (Exception e) {
            return new ResponseEntity("Error in getAllBookings: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idBooking}")
    public ResponseEntity<BookingResponseDto> findBookingById(@PathVariable String idBooking){
        try{
            return new ResponseEntity<>(bookingService.findBookingById(idBooking),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("the booking " + idBooking + " does't in the data base.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BookingResponseDto> saveBooking(@RequestBody BookingDto bookingDto){
        return new ResponseEntity<>(bookingService.saveBooking(bookingDto),HttpStatus.CREATED);
    }

    @PutMapping("/{idBooking}")
    public ResponseEntity<Boolean> updateBooking(@PathVariable String idBooking, @RequestBody BookingDto bookingDto){
        try{
            Boolean isUpdateBooking = bookingService.updateBooking(idBooking, bookingDto);
            if(isUpdateBooking){
                return new ResponseEntity("the booking update is ok." , HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (NoSuchElementException e){
            return new ResponseEntity("the booking " + idBooking + " does't in the data base.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idBooking}")
    public ResponseEntity<Boolean> deleteBooking(@PathVariable String idBooking){
        return new ResponseEntity<>(bookingService.deleteBooking(idBooking),HttpStatus.OK);
    }
}
