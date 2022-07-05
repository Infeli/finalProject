package com.engeto.finalProject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Country implements Comparable<Country>{

    private String shortName;

    @JsonProperty("_comment")
    private String comment;

    @JsonProperty("iso_duplicate")
    private Object isoDuplicate;

    @JsonProperty("country")
    private String countryName;

    @JsonProperty("standard_rate")
    private Integer standardRate; //double

    @JsonProperty("reduced_rate")
    private Object reducedRate;

    @JsonProperty("reduced_rate_alt")
    private Object reducedRateAlt;

    @JsonProperty("super_reduced_rate")
    private Object superReducedRate;

    @JsonProperty("parking_rate")
    private Object parkingRate;


    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Object isIsoDuplicate() {
        return isoDuplicate;
    }

    public void setIsoDuplicate(Object isoDuplicate) {
        this.isoDuplicate = isoDuplicate;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(Integer standardRate) {
        this.standardRate = standardRate;
    }

    public Object getReducedRate() {
        return reducedRate;
    }

    public void setReducedRate(Object reducedRate) {
        this.reducedRate = reducedRate;
    }

    public Object getReducedRateAlt() {
        return reducedRateAlt;
    }

    public void setReducedRateAlt(Object reducedRateAlt) {
        this.reducedRateAlt = reducedRateAlt;
    }

    public Object isSuperReducedRate() {
        return superReducedRate;
    }

    public void setSuperReducedRate(Object superReducedRate) {
        this.superReducedRate = superReducedRate;
    }

    public Object isParkingRate() {
        return parkingRate;
    }

    public void setParkingRate(Object parkingRate) {
        this.parkingRate = parkingRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Double.compare(country.getStandardRate(), getStandardRate()) == 0 && Objects.equals(getShortName(), country.getShortName()) && Objects.equals(getComment(), country.getComment()) && Objects.equals(isoDuplicate, country.isoDuplicate) && Objects.equals(getCountryName(), country.getCountryName()) && Objects.equals(getReducedRate(), country.getReducedRate()) && Objects.equals(getReducedRateAlt(), country.getReducedRateAlt()) && Objects.equals(superReducedRate, country.superReducedRate) && Objects.equals(parkingRate, country.parkingRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShortName(), getComment(), isoDuplicate, getCountryName(), getStandardRate(), getReducedRate(), getReducedRateAlt(), superReducedRate, parkingRate);
    }


    @Override
    public String toString() {
        return "Country: " + countryName + ", rate: " + standardRate + "\n";
    }

    @Override
    public int compareTo(Country country){
        return 0;
    }

}
