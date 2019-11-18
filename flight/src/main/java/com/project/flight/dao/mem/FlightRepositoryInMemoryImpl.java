package com.project.flight.dao.mem;

import com.project.flight.dao.FlightRepository;
import com.project.flight.model.Flight;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class FlightRepositoryInMemoryImpl implements FlightRepository {

    private Map<Integer, Flight> flightsMap = new HashMap<>();

    public FlightRepositoryInMemoryImpl() {
        Flight flight1 = new Flight();
        flight1.setId(1);
        flight1.setFlt_no("61072");
        flight1.setDepartuer_date("6/24/2019 12:55");
        flight1.setDep_port("POZ");
        flight1.setArr_port("AYT");
        flight1.setStatus("RZ");

        Flight flight2 = new Flight();
        flight2.setId(2);
        flight2.setFlt_no("20152");
        flight2.setDepartuer_date("6/24/2019 12:30");
        flight2.setDep_port("SAW");
        flight2.setArr_port("AYT");
        flight2.setStatus("RZ");

        flightsMap.put(flight1.getId(), flight1);
        flightsMap.put(flight2.getId(), flight2);
    }

    @Override
    public List<Flight> getAllList() {
        return new ArrayList<>(flightsMap.values());
    }

    @Override
    public List<Flight> getListByKeyWords(String feature, String typedText) {
        if(!typedText.isEmpty()){
            if (!feature.equalsIgnoreCase("Choose One")){
                switch (feature){
                    case "flt_no" : return flightsMap.values().stream().filter(f->f.getFlt_no().equals(typedText)).collect(Collectors.toList());
                }
            }else{
                return flightsMap.values().stream()
                        .filter(f->f.getFlt_no().equals(typedText)
                                || f.getArr_port().equals(typedText)
                                || f.getDep_port().equals(typedText)
                                || f.getStatus().equals(typedText))
                        .collect(Collectors.toList());
            }
        }else{
            return getAllList();
        }
        return null;
    }
}
