package com.bayesa.citiescultures;

public class Singleton {
    // 1. Create private instance
    private CitiesInformation citiesInformation;
    private static Singleton singleton;

    // 2. Create private constructor
    private Singleton(){

    }

    public CitiesInformation getCitiesInformation(){
        return citiesInformation;
    }
    public void setCitiesInformation(CitiesInformation citiesInformation){
        this.citiesInformation = citiesInformation;
    }

    // 3. use getInstance() of Singleton class
    public static Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

}
