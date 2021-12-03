package com.lovetocode.springdemo.mvc.dto;

import java.util.List;
import java.util.Map;

public class Student {

    // Map ISO country code to label (could also be done in a properties file)
    public static final Map<String, String> COUNTRY_OPTIONS = Map.of(
            "BR", "Brazil",
            "FR", "France",
            "DE", "Germany",
            "IN", "India",
            "US", "United States of America"
    );

    private String firstName;

    private String lastName;

    private String country;

    private String favoriteProgrammingLanguage;

    private List<String> operatingSystems;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavoriteProgrammingLanguage() {
        return favoriteProgrammingLanguage;
    }

    public void setFavoriteProgrammingLanguage(String favoriteProgrammingLanguage) {
        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
    }

    public List<String> getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(List<String> operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}
