package com.hotel.booking.model.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotel.booking.model.hotel.Hotel;
import com.hotel.booking.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

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
    public void setUser(User user) {
        this.user = user;
        if (!user.getBookingsList().contains(this)) {
            user.getBookingsList().add(this);
        }
    }
    @DBRef
    @JsonIgnore
    private User user;

    @DBRef
    private Hotel hotel;
}
