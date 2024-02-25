package com.hotel.booking.dto.user;

import com.hotel.booking.model.booking.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Booking> bookingsList;
}
