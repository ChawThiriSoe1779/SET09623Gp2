package com.napier.gp2;

//Population class with parameter

public class Population {
//    name of country, continent or region
    private String name;

//    total population of country, continent or region
    private long total_population;

//    total city population of country, continent or region
    private String city_population;

//    total non_city population of country, continent or region
    private String non_city_population;

    //set name of place
    public void setName(String pname){
        name = pname;
    }

    //get name of place
    public String getName(){
        return name;
    }

    // set total population of a place
    public void setTotal_population(long totalpopulation){
        total_population = totalpopulation;
    }

    //get total population of a place
    public long getTotal_population(){
        return total_population;
    }

    // set population of living in city
    public void setCity_population(String cpopulation){
        city_population = cpopulation;
    }

    // get population of living in city
    public String getCity_population(){
        return city_population;
    }

    // set population of not living in city
    public void setNon_city_population(String ncpopulation){
        non_city_population = ncpopulation;
    }

    // get population of not living in city
    public String getNon_city_population(){
        return non_city_population;
    }
}
