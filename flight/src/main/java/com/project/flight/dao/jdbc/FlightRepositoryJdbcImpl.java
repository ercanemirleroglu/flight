package com.project.flight.dao.jdbc;

import com.project.flight.dao.FlightRepository;
import com.project.flight.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository("flightRepository")
public class FlightRepositoryJdbcImpl implements FlightRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Map<Integer, Flight> flightsMap = new HashMap<>();

    private RowMapper<Flight> rowMapper = new RowMapper<Flight>() {
        @Override
        public Flight mapRow(ResultSet rs, int rowNum) throws SQLException{
            Flight flight = new Flight();
            flight.setId(rs.getInt("id"));
            flight.setFlt_no(rs.getString("flt_no"));
            flight.setDepartuer_date(rs.getString("departuer_date"));
            flight.setDep_port(rs.getString("dep_port"));
            flight.setArr_port(rs.getString("arr_port"));
            flight.setStatus(rs.getString("status"));
            return flight;
        }
    };

    @Override
    public List<Flight> getAllList() {
        String sql ="select * from flight";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<Flight> getListByKeyWords(String feature, String typedText) {
        String sql ="select * from flight";
        List<Flight> flightList = jdbcTemplate.query(sql, rowMapper);
        if(!typedText.isEmpty()){
            if (!feature.equalsIgnoreCase("CHOOSE ONE")){
                switch (feature){
                    case "flt_no" : return flightList.stream().filter(f->f.getFlt_no().contains(typedText.toUpperCase())).collect(Collectors.toList());
                    case "departuer_date" : return flightList.stream().filter(f->f.getDepartuer_date().contains(typedText)).collect(Collectors.toList());
                    case "dep_port" : return flightList.stream().filter(f->f.getDep_port().contains(typedText.toUpperCase())).collect(Collectors.toList());
                    case "arr_port" : return flightList.stream().filter(f->f.getArr_port().contains(typedText.toUpperCase())).collect(Collectors.toList());
                    case "status" : return flightList.stream().filter(f->f.getStatus().contains(typedText.toUpperCase())).collect(Collectors.toList());
                }
            }else{
                return flightList.stream()
                        .filter(f->f.getFlt_no().contains(typedText.toUpperCase())
                                || f.getDepartuer_date().contains(typedText)
                                || f.getArr_port().contains(typedText.toUpperCase())
                                || f.getDep_port().contains(typedText.toUpperCase())
                                || f.getStatus().contains(typedText.toUpperCase()))
                        .collect(Collectors.toList());
            }
        }else{
            return getAllList();
        }
        return null;
    }
}
