package com.xworkz.flight.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name="flight_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String flightNumber;
    private String airline;
    private String departureCity;
    private String arrivalCity;
    private Long price;
}
