package com.hotel.booking.dto.hotel;

import com.hotel.booking.model.hotel.Hotel;

public class HotelMapper {

    public static HotelResponseDto hotelToHotelResponseDto(Hotel hotel){
        return new HotelResponseDto(
                hotel.getNameHotel()
        );
    }

    public static Hotel hotelDtoToHotel (HotelDto hotelDto){
        return new Hotel(
                hotelDto.getNameHotel()
        );
    }
}
