package com.hotel.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@AllArgsConstructor
@Data
public class User {

    private String idUser;
    private String firstName;
    private String lastName;
    private String phoneCel;
    private String idCard;
    private LocalDateTime registrationDate;
    private StatusBooking statusBooking;
}
