package com.hotel.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "booking")
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String idBooking;
    private String nameHotel;
    private LocalDate registrationStartDate;
    private LocalDate registrationEndDate;
    private String idUser;

    public Booking(String nameHotel,LocalDate registrationStartDate, LocalDate registrationEndDate, String idUser) {
        this.nameHotel = nameHotel;
        this.registrationStartDate = registrationStartDate;
        this.registrationEndDate = registrationEndDate;
        this.idUser = idUser;
    }
    @DBRef
    private User user;

    @DBRef
    private Hotel hotel;
}
