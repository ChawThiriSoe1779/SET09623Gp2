package com.napier.gp2;

//Population class with parameter

public class Population {
//    name of country, continent or region
    private String name;

//    total population of country, continent or region
    private int total_population;

//    total city population of country, continent or region
    private int city_population;

//    total non_city population of country, continent or region
    private int non_city_population;

    //set name of place
    public void setName(String pname){
        name = pname;
    }

    //get name of place
    public String getName(){
        return name;
    }

    // set total population of a place
    public void setTotal_population(int totalpopulation){
        total_population = totalpopulation;
    }

    //get total population of a place
    public int getTotal_population(){
        return total_population;
    }

    // set population of living in city
    public void setCity_population(int cpopulation){
        city_population = cpopulation;
    }

    // get population of living in city
    public int getCity_population(){
        return city_population;
    }

    // set population of not living in city
    public void setNon_city_population(int ncpopulation){
        non_city_population = ncpopulation;
    }

    // get population of not living in city
    public int getNon_city_population(){
        return non_city_population;
    }
}
