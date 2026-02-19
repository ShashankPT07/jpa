package com.xworkz.flight.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {
    private String flightNumber;
    private String airline;
    private String departureCity;
    private String arrivalCity;
    private Long price;
}
