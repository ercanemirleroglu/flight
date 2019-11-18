package com.project.flight.service;

import com.project.flight.dao.FlightRepository;
import com.project.flight.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private FlightRepository flightRepository;

    @Autowired
    public void setFlightRepository(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> getAllFlightList() {
        return flightRepository.getAllList();
    }

    @Override
    public List<Flight> getFlightListByKeyWords(String feature, String typedText) {
        return flightRepository.getListByKeyWords(feature, typedText);
    }
}
