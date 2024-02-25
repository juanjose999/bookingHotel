package com.hotel.booking.dto.booking;

import com.hotel.booking.model.booking.Booking;

public class BookingMapper {

    public static BookingResponseDto bookingToBookingResponseDto(Booking booking){
        return new BookingResponseDto(
                booking.getNameHotel(),
                booking.getIdBooking(),
                booking.getRegistrationStartDate(),
                booking.getRegistrationEndDate(),
                booking.getIdUser()
        );
    }

    public static Booking bookingDtoToBooking(BookingDto bookingDto){
        return new Booking(
                bookingDto.getNameHotel(),
                bookingDto.getRegistrationStartDate(),
                bookingDto.getRegistrationEndDate(),
                bookingDto.getIdUser()
        );
    }

}
