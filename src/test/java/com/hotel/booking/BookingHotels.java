package com.hotel.booking;

import com.hotel.booking.model.Booking;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingHotels {

    @Test
    public void testCreateBooking(){
        String nameHotel = "Hotel A";
        LocalDate fechaEntrada = LocalDate.now();
        LocalDate fechaSalida = LocalDate.now().plusDays(2);

        Booking booking = new Booking(nameHotel, fechaEntrada, fechaSalida, "65cb6f6e43963991f78df143");

        assertEquals("Hotel A", booking.getNameHotel());

        assertEquals("65cb6f6e43963991f78df143", booking.getIdUser());

        assertEquals(fechaEntrada, booking.getRegistrationStartDate());
        assertEquals(fechaSalida, booking.getRegistrationEndDate());
    }
}
