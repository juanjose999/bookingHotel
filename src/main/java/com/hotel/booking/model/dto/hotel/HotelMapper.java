package com.hotel.booking.model.dto.hotel;

import com.hotel.booking.model.Hotel;

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
