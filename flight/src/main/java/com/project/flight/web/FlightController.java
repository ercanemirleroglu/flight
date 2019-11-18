package com.project.flight.web;

import com.project.flight.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FlightController {
    @Autowired
    private FlightService flightService;
    private static final Logger log = LoggerFactory.getLogger(FlightController.class);

    @RequestMapping("/flights")
    public ModelAndView getFlights(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("flights", flightService.getAllFlightList());
        mav.setViewName("flights");
        return mav;
    }

    @PostMapping("/flights")
    public ModelAndView processSearch(@RequestParam String feature, @RequestParam String typedText){
        log.info("redirectredirectredirectredirectredirectredirectredirectredirectredirectredirectredirectredirect");
        ModelAndView mav = new ModelAndView();
        mav.addObject("flights", flightService.getFlightListByKeyWords(feature, typedText));
        mav.setViewName("flights");
        return mav;
    }

}
