package com.project.flight.dao;

import com.project.flight.model.Flight;

import java.util.List;

public interface FlightRepository {
    List<Flight> getAllList();
    List<Flight> getListByKeyWords(String feature, String typedText);
}
