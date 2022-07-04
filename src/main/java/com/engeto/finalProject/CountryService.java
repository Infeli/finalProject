package com.engeto.finalProject;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class CountryService {

    Map<String, Country> map;
    CountryResponse countryResponse;

    public String getResponseTest() {
        return "ahoj";
    }

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
        //countryResponse.rates.values();

    }








}
