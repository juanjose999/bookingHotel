package com.hotel.booking.model.user;

import com.hotel.booking.model.booking.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Document(collection = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String idUser;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate registrationDate;
    private String nameHotel;
    private LocalDate registrationStartDate;
    private LocalDate registrationEndDate;

    @DBRef(lazy = false)
    private List<Booking> bookingsList;
    public User(String firstName, String lastName, String email, String password, LocalDate registrationDate, List<Booking> bookingsList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public void addBooking(Booking booking) {
        if (bookingsList == null) {
            bookingsList = new ArrayList<>();
        }
        bookingsList.add(booking);
    }

}
