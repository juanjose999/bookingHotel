package com.hotel.booking.service;

import com.hotel.booking.model.Booking;
import com.hotel.booking.model.dto.booking.BookingDto;
import com.hotel.booking.model.dto.booking.BookingResponseDto;
import com.hotel.booking.repository.booking.BookingRepository;
import com.hotel.booking.service.booking.BookingService;
import com.hotel.booking.service.booking.BookingServiceImpl; // Import the concrete implementation
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookingServiceTets {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    public BookingServiceTets() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveBooking() {
        LocalDate fechaResgitro = LocalDate.now();
        LocalDate fechaSalida = LocalDate.now().plusDays(2);


        BookingDto bookingDto = new BookingDto("Hotel ABC", "20174192", fechaResgitro, fechaSalida, "user123");


        when(bookingRepository.saveBooking(any())).thenReturn(new Booking(
                "Hotel ABC",
                LocalDate.now(),
                LocalDate.now().plusDays(5),
                "user123"
        ));


        BookingResponseDto result = bookingService.saveBooking(bookingDto);


        assertEquals("Hotel ABC", result.getNameHotel());

        verify(bookingRepository, times(1)).saveBooking(any());
    }

    @Test
    public void testFindBookingById() {
        // Given
        String bookingId = "123";
        when(bookingRepository.findBookingById(bookingId)).thenReturn(new Booking(
                "Hotel XYZ",
                LocalDate.now(),
                LocalDate.now().plusDays(3),
                "user456"
        ));

        // When
        BookingResponseDto result = bookingService.findBookingById(bookingId);


        assertEquals("Hotel XYZ", result.getNameHotel());
        verify(bookingRepository, times(1)).findBookingById(bookingId);
    }

    @Test
    public void testDeleteBooking() {
        // Given
        String bookingId = "456";
        when(bookingRepository.deleteBooking(bookingId)).thenReturn(true);


        Boolean result = bookingService.deleteBooking(bookingId);


        assertTrue(result);

        verify(bookingRepository, times(1)).deleteBooking(bookingId);
    }
}
