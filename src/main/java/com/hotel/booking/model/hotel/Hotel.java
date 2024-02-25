package com.hotel.booking.model.hotel;

import com.hotel.booking.model.booking.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
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
