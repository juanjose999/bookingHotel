package com.hotel.booking.model.dto.hotel;

import com.hotel.booking.model.Hotel;

public class HotelMapper {

    public static HotelResponseDto hotel_To_HotelResponseDto(Hotel hotel){
        return new HotelResponseDto(
                hotel.getNameHotel()
        );
    }

    public static Hotel hotelDto_To_Hotel (HotelDto hotelDto){
        return new Hotel(
                hotelDto.getNameHotel()
        );
    }
}
