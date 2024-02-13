package com.hotel.booking.repository.booking;

import com.hotel.booking.model.Booking;

import java.util.List;

public interface BookingRepository {
    List<Booking> getAllBookings();
    Booking findBookingById(String idBooking);
    Booking saveBooking(Booking booking);
    Boolean updateBooking(String id, Booking booking);
    Boolean deleteBooking(String id);
}
