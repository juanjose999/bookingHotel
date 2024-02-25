package com.hotel.booking.controller;

import com.hotel.booking.controller.bookings.BookingsController;
import com.hotel.booking.dto.booking.BookingDto;
import com.hotel.booking.dto.booking.BookingResponseDto;
import com.hotel.booking.service.booking.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookingsControllerTest {

    @Mock
    private BookingService bookingService;

    @InjectMocks
    private BookingsController bookingsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBookings() {

        List<BookingResponseDto> mockBookings = Arrays.asList(new BookingResponseDto(), new BookingResponseDto());
        when(bookingService.getAllBookings()).thenReturn(mockBookings);


        ResponseEntity<List<BookingResponseDto>> response = bookingsController.getAllBookings();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockBookings, response.getBody());
        verify(bookingService, times(1)).getAllBookings();
    }

    @Test
    void testFindBookingById() {
        String idBooking = "123";
        BookingResponseDto mockBooking = new BookingResponseDto();
        when(bookingService.findBookingById(idBooking)).thenReturn(mockBooking);

        ResponseEntity<BookingResponseDto> response = bookingsController.findBookingById(idBooking);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockBooking, response.getBody());
        verify(bookingService, times(1)).findBookingById(idBooking);
    }

    @Test
    void testSaveBooking() {

        BookingDto bookingDto = new BookingDto();
        BookingResponseDto mockBookingResponse = new BookingResponseDto();
        when(bookingService.saveBooking(bookingDto)).thenReturn(mockBookingResponse);


        ResponseEntity<BookingResponseDto> response = bookingsController.saveBooking(bookingDto);


        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockBookingResponse, response.getBody());
        verify(bookingService, times(1)).saveBooking(bookingDto);
    }
}