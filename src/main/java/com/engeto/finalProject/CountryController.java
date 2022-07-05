package com.engeto.finalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/min")
    public List<Country> getMinRate(){
        return countryService.getMinRate();
    }

    @GetMapping("/max")
    public List<Country> getMaxRate(){
        return countryService.getMaxRate();
    }

    // shortName zkratku potřeba napsat velkými písmeny!
    @GetMapping("/country/{shortName}")
    public Country getCountryByShortCut(@PathVariable String shortName){
        return countryService.getCountryByShortCut(shortName);
    }




}
