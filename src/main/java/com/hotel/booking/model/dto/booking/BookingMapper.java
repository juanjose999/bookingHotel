package com.hotel.booking.model.dto.booking;

import com.hotel.booking.model.Booking;

public class BookingMapper {

    public static BookingResponseDto booking_To_BookingResponseDto(Booking booking){
        return new BookingResponseDto(
                booking.getNameHotel(),
                booking.getIdBooking(),
                booking.getRegistrationStartDate(),
                booking.getRegistrationEndDate(),
                booking.getIdUser()
        );
    }

    public static Booking bookingDto_To_Booking(BookingDto bookingDto){
        return new Booking(
                bookingDto.getNameHotel(),
                bookingDto.getIdBooking(),
                bookingDto.getRegistrationStartDate(),
                bookingDto.getRegistrationEndDate(),
                bookingDto.getIdUser()
        );
    }

}
