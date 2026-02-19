package com.xworkz.flight.service;

import com.xworkz.flight.dao.FlightDAO;
import com.xworkz.flight.dto.FlightDTO;
import com.xworkz.flight.entity.FlightEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightDAO flightDAO;

    @Override
    public boolean saveData(FlightDTO flightDTO) {

        System.out.println("Service === " + flightDTO);

        if (flightDTO.getFlightNumber() != null && flightDTO.getFlightNumber().length() > 2 &&
                flightDTO.getAirline() != null && flightDTO.getAirline().length() > 3 &&
                flightDTO.getDepartureCity() != null && flightDTO.getDepartureCity().length() > 3 &&
                flightDTO.getArrivalCity() != null && flightDTO.getArrivalCity().length() > 3 &&
                flightDTO.getPrice() != null && flightDTO.getPrice() > 0) {

            FlightEntity flightEntity = new FlightEntity();

            flightEntity.setFlightNumber(flightDTO.getFlightNumber());
            flightEntity.setAirline(flightDTO.getAirline());
            flightEntity.setDepartureCity(flightDTO.getDepartureCity());
            flightEntity.setArrivalCity(flightDTO.getArrivalCity());
            flightEntity.setPrice(flightDTO.getPrice());

            flightDAO.save(flightEntity);

            return true;

        } else {
            return false;
        }
    }
}
