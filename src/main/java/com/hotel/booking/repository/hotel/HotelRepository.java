package com.hotel.booking.repository.hotel;

import com.hotel.booking.model.Booking;
import com.hotel.booking.model.Hotel;

import java.util.List;

public interface HotelRepository {
    List<Hotel> getAllHotel();
    Hotel findHotelById(String idHotel);
    Hotel saveBooking(Hotel hotel);
    Boolean updateHotel(String id, Hotel hotel);
    Boolean deleteHotel(String id);
}
