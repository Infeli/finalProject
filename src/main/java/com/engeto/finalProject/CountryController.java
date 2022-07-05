package com.engeto.finalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/min")
    public String getMin(){
        return countryService.getMin();
    }

    @GetMapping("/max")
    public String getMax(){
        return countryService.getMax();
    }

    // shortName zkratku potřeba napsat velkými písmeny!
    @GetMapping("/country/{shortName}")
    public Country getCountryByShortCut(@PathVariable String shortName){
        return countryService.getCountryByShortCut(shortName);
    }



}
