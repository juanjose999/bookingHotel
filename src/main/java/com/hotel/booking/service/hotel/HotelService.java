package com.hotel.booking.service.hotel;

import com.hotel.booking.model.Hotel;
import com.hotel.booking.model.dto.hotel.HotelDto;
import com.hotel.booking.model.dto.hotel.HotelResponseDto;

import java.util.List;

public interface HotelService {
    List<HotelResponseDto> getAllHotels();
    HotelResponseDto findHotelById(String idHotel);
    HotelResponseDto saveHotel(HotelDto hotelDto);
    Boolean updateHotel(String id, HotelDto hotelDto);
    Boolean deleteHotel(String idHotel);
}
