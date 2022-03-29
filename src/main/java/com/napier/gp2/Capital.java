package com.napier.gp2;

public class Capital {
//    name of capital city
    private String name;

//    country of capital city
    private String country;

//    district of capital city
    private String district;

//    population of capital city
    private int population;

    //set name of capital
    public void setName(String cname){
        name = cname;
    }

    //get capital name
    public String getName(){
        return name;
    }

    //set country of capital
    public void setCountry(String ccountry){
        country = ccountry;
    }

    //get country of capital
    public String getCountry(){
        return country;
    }

    //set district of capital
    public void setDistrict(String cdistrict){
        district = cdistrict;
    }

    //get district of capital
    public String getDistrict(){
        return district;
    }

    //set population of capital
    public void setPopulation(int cpopulation){
        population = cpopulation;
    }

    //get capital name
    public int getPopulation(){
        return population;
    }
}
