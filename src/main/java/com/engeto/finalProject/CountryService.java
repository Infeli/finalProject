package com.engeto.finalProject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;


@Service
public class CountryService {

    Map<String, Country> map;
    CountryResponse countryResponse;

    public CountryService() throws IOException, InterruptedException {
        // načtení JSOn dat
        HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://euvatrates.com/rates.json")).GET().build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        String x = "{\"CZ\": {\"country\":\"Czech Republic\"}, \"SK\": {\"country\":\"Slovakia\"}}";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        map =  objectMapper.readValue(x, new TypeReference<Map<String, Country>>(){});
        countryResponse = objectMapper.readValue(response.body(), CountryResponse.class);


    }

//    public String getMax(){
//        StringBuilder output = new StringBuilder();
//        output.append(("------- Highest Rates -------") + System.lineSeparator());
//        countryResponse.rates.forEach((key, countryResponse) -> {
//            if (countryResponse.getStandardRate() >= 25.0) {
//                output.append("Country shortcut: " + key + ", ");
//                output.append("Country name: " + countryResponse.getCountryName() + ", ");
//                output.append("Standard rate: " + countryResponse.getStandardRate() + System.lineSeparator());
//            }
//        });
//        return output.toString();
//    }

//    public String getMin(){
//        StringBuilder output = new StringBuilder();
//        output.append(("------- Lowest Rates -------") + System.lineSeparator());
//        countryResponse.rates.forEach((key, countryResponse) -> {
//            if (countryResponse.getStandardRate() <= 19.0) {
//                output.append("Country shortcut: " + key + ", ");
//                output.append("Country name: " + countryResponse.getCountryName() + ", ");
//                output.append("Standard rate: " + countryResponse.getStandardRate() + System.lineSeparator());
//            }
//        });
//        return output.toString();
//    }


    // případně by mohl být String a být vypsaná forma toString ...
    public List<Country> getMinRate(){

        List<Country> countryList = new ArrayList<Country>(countryResponse.rates.values());

        Collections.sort(countryList, new Comparator<Country>() {
            @Override
            public int compare(Country country1, Country country2) {
                return country1.getStandardRate().compareTo(country2.getStandardRate());
            }
        });

        List<Country> lowRates = new ArrayList<>();

        lowRates.add(countryList.get(0));
        lowRates.add(countryList.get(1));
        lowRates.add(countryList.get(2));

        return lowRates;


    }


    public List<Country> getMaxRate(){
        List<Country> countryList = new ArrayList<Country>(countryResponse.rates.values());

        Collections.sort(countryList, new Comparator<Country>() {
            @Override
            public int compare(Country country1, Country country2) {
                return country1.getStandardRate().compareTo(country2.getStandardRate());
            }
        }.reversed());

        List<Country> lowRates = new ArrayList<>();

        lowRates.add(countryList.get(0));
        lowRates.add(countryList.get(1));
        lowRates.add(countryList.get(2));

        return lowRates;
    }


    public Country getCountryByShortCut(String shortName){
        return countryResponse.getRates().get(shortName);
    }


}
