package com.hotel.booking.model.dto.booking;

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

    public BookingDto(String nameHotel, String idBooking, int startDay, int startMonth, int startYear,
                      int endDay, int endMonth, int endYear, String idUser) {
        this.nameHotel = nameHotel;
        this.idBooking = idBooking;
        this.registrationStartDate = LocalDate.of(startYear, startMonth, startDay);
        this.registrationEndDate = LocalDate.of(endYear, endMonth, endDay);
        this.idUser = idUser;
    }

}
