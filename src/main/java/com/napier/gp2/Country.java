package com.napier.gp2;

//Country class with parameters

public class Country {
//  Country code of the country
    private String Code;

//    Name of the country
    private String Name;

//    Continent of the country
    private String Continent;

//    Region of the country
    private String Region;

//    Population of the country
    private int Population;

//    Capital city of the country
    private String Capital;

    //      set country code
    public void setCode(String coucode){
        Code =  coucode;
    }

    //get code of country to be able to access by another class
    public String getCode(){
        return Code;
    }

    //      set country name
    public void setName(String couname){
        Name =  couname;
    }

    //get name of country to be able to access by another class
    public String getName(){
        return Name;
    }

    //      set country continent
    public void setContinent(String coucontinent){
        Continent =  coucontinent;
    }

    //get Continent of country to be able to access by another class
    public String getContinent(){
        return Continent;
    }

    //      set country Region
    public void setRegion(String couregion){
        Region =  couregion;
    }

    //get Continent of country to be able to access by another class
    public String getRegion(){
        return Region;
    }

    //      set country Population
    public void setPopulation(int coupopulation){
        Population =  coupopulation;
    }

    //get Continent of country to be able to access by another class
    public int getPopulation(){
        return Population;
    }

    //      set country Capital
    public void setCapital(String coucapital){
        Capital =  coucapital;
    }

    //get Capital of country to be able to access by another class
    public String getCapital(){
        return Capital;
    }

}
