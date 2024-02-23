package com.hotel.booking;

import com.hotel.booking.model.StatusBooking;
import com.hotel.booking.model.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testCreateUser(){
        String firstName = "Juan Jose";
        String lastName = "Sierra";
        String phoneCel = "3227038846";
        String idCc = "109274694";
        LocalDate fechaRegistro = LocalDate.now();
        StatusBooking statusBooking = StatusBooking.INACTIVE;

        User user = new User(firstName,lastName,phoneCel, idCc, fechaRegistro, statusBooking);

        assertEquals("Juan Jose", user.getFirstName());
        assertEquals("Sierra", user.getLastName());
        assertEquals("3227038846", user.getPhoneCel());
        assertEquals(fechaRegistro, user.getRegistrationDate());

    }
}
