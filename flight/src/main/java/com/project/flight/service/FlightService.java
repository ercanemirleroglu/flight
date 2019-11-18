package com.project.flight.service;

import com.project.flight.model.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> getAllFlightList();
    List<Flight> getFlightListByKeyWords(String feature, String typedText);
}
