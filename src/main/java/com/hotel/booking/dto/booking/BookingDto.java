package com.hotel.booking.dto.booking;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookingDto {

    private String nameHotel;
    private String idBooking;
    private LocalDate registrationStartDate;
    private LocalDate registrationEndDate;
    private String idUser;

    public BookingDto(String nameHotel, String idBooking, LocalDate registrationStartDate, LocalDate registrationEndDate, String idUser) {
        this.nameHotel = nameHotel;
        this.idBooking = idBooking;
        this.registrationStartDate = registrationStartDate;
        this.registrationEndDate = registrationEndDate;
        this.idUser = idUser;
    }

    public BookingDto(){}
}
