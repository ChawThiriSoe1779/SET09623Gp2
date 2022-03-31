package com.napier.gp2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void printCountriesReportTest()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country coun = new Country();
        coun.setCode("VEN");
        coun.setName("Venezuela");
        coun.setContinent("South America");
        coun.setRegion("South America");
        coun.setPopulation(24170000);
        coun.setCapital("Caracas");
        countries.add(coun);
        app.printCountriesReport(countries);
    }

    @Test
    void printCityReportTest()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City actiy = new City();
        actiy.setName("Kabul");
        actiy.setCountry("Afghanistan");
        actiy.setDistrict("Kabol");
        actiy.setPopulation(1780000);
        cities.add(actiy);
        app.printCityReport(cities);
    }

    @Test
    void printCapCityReportTest()
    {
        ArrayList<Capital> cap_cities = new ArrayList<Capital>();
        Capital ca = new Capital();
        ca.setName("Caracas");
        ca.setCountry("Venezuela");
        ca.setDistrict("Distrito Federal");
        ca.setPopulation(1975294);
        cap_cities.add(ca);
        app.printCapCityReport(cap_cities);
    }

    @Test
    void printPopulationReportTest()
    {
        ArrayList<Population> populations = new ArrayList<Population>();
        Population pop = new Population();
        pop.setName("Vietnam");
        pop.setTotal_population(79832000);
        pop.setCity_population(9364813);
        pop.setNon_city_population(70467187);
        populations.add(pop);
        app.printPopulationReport(populations);
    }

}