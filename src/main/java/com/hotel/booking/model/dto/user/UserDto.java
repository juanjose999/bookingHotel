package com.hotel.booking.model.dto.user;

import com.hotel.booking.model.StatusBooking;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@AllArgsConstructor
@Data
public class UserDto {
    private String idUser;
    private String firstName;
    private String lastName;
    private String phoneCel;
    private String idCard;
    private LocalDate registrationDate;
    private StatusBooking statusBooking;
}
