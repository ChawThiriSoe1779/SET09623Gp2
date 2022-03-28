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

    public void setName(String cname){
        name =  cname;
    }

    public String getName(){
        return name;
    }

    public void setCountry(String ccountry){
        country = ccountry;
    }

    public String getCountry(){
        return country;
    }

    public void setDistrict(String cdistrict){
        district = cdistrict;
    }

    public String getDistrict(){
        return district;
    }

    public void setPopulation(int cpopulation){
        population = cpopulation;
    }

    public int getPopulation(){
        return population;
    }
}
