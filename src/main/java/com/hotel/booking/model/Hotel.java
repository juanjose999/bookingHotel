package com.hotel.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Document(collection = "hotel")
public class Hotel {
    @Id
    private String nameHotel;
    @DBRef
    private List<Booking> bookings;

    public Hotel(String nameHotel){
        this.nameHotel = nameHotel;
    }

}
