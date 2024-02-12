package com.hotel.booking.model.dto.user;

import com.hotel.booking.model.StatusBooking;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@AllArgsConstructor
@Data
public class UserResponseDto {
    private String firstName;
    private String lastName;
    private StatusBooking statusBooking;
}
