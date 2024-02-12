package com.hotel.booking.model.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class BookingResponseDto {
    private String nameHotel;
    private String idBooking;
    private LocalDate registrationStartDate;
    private LocalDate registrationEndDate;
    private String idUser;

}
