package com.napier.gp2;
//A parent class of city with attributes

public class City {

//    city name
    private String name;

//    country of city
    private String country;

//    district of city
    private String district;

//    population of city
    private int population;

//      set city name
    public void setName(String cname){
        name =  cname;
    }

    //get name of city to be able to access by another class
    public String getName(){
        return name;
    }

    //set country name
    public void setCountry(String ccountry){
        country = ccountry;
    }

    //get name of city to be able to access by another class
    public String getCountry(){
        return country;
    }

    //set district name
    public void setDistrict(String cdistrict){
        district = cdistrict;
    }

    //get name of city to be able to access by another class
    public String getDistrict(){
        return district;
    }

    //set population of city
    public void setPopulation(int cpopulation){
        population = cpopulation;
    }

    //get population of city to be able to access by another class
    public int getPopulation(){
        return population;
    }
}
