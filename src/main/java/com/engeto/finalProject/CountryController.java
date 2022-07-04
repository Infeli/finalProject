package com.engeto.finalProject;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/test")
    public String getResponseTest() {
        return countryService.getResponseTest();
    }




    // 3 metody zde

    // dej mi nejvyšší, nejnižší a na základě vstupu

}
