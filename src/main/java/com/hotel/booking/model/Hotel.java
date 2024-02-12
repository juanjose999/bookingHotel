package com.hotel.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Document(collection = "hotel")
public class Hotel {
    private String nameHotel;
}
