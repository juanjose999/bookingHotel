package com.hotel.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
@AllArgsConstructor
@Data
@Document(collection = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String idUser;
    private String firstName;
    private String lastName;
    private String phoneCel;
    private String idCard;
    private LocalDate registrationDate;
    private StatusBooking statusBooking;

    public User(String firstName, String lastName, String phoneCel, String idCard, LocalDate registrationDate, StatusBooking statusBooking) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneCel = phoneCel;
        this.idCard = idCard;
        this.registrationDate = registrationDate;
        this.statusBooking = statusBooking;
    }
}
