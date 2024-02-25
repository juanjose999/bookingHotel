package com.hotel.booking.repository.hotel;

import com.hotel.booking.model.hotel.Hotel;

import java.util.List;

public interface HotelRepository {
    List<Hotel> getAllHotels();
    Hotel findHotelById(String idHotel);
    Hotel saveHotel(Hotel hotel);
    Boolean updateHotel(String id, Hotel hotel);
    Boolean deleteHotel(String id);
}
