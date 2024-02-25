package com.hotel.booking.service.booking;

import com.hotel.booking.dto.booking.BookingDto;
import com.hotel.booking.dto.booking.BookingResponseDto;

import java.util.List;

public interface BookingService {
    List<BookingResponseDto> getAllBookings();
    BookingResponseDto findBookingById(String idBooking);
    BookingResponseDto saveBooking(BookingDto bookingDto);
    Boolean updateBooking(String idBooking, BookingDto bookingDto);
    Boolean deleteBooking(String id);
}
