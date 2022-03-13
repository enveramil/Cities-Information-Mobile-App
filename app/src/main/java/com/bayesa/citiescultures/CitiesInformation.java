package com.bayesa.citiescultures;

import java.io.Serializable;

public class CitiesInformation implements Serializable {
    int picture;
    String cities_name;
    String cities_description;

    //constructor
    public CitiesInformation(int picture, String cities_name, String cities_description) {
        this.picture = picture;
        this.cities_name = cities_name;
        this.cities_description = cities_description;
    }
}
