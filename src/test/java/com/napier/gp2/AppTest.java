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
        System.out.println("Normal Countries Report List Testing~~");
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
        System.out.println("=================================================================================================");
    }

    @Test
    void printCountriesReportTestNull()
    {
        System.out.println("Countries Report Null Testing~~");
        app.printCountriesReport(null);
        System.out.println("=================================================================================================");
    }

    @Test
    void printCountriesReportTestEmpty()
    {
        System.out.println("Countries Report Empty Testing~~");
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesReport(countries);
        System.out.println("=================================================================================================");

    }

    @Test
    void printCityReportTest()
    {
        System.out.println("Normal City Report List Testing~~");
        ArrayList<City> cities = new ArrayList<City>();
        City actiy = new City();
        actiy.setName("Kabul");
        actiy.setCountry("Afghanistan");
        actiy.setDistrict("Kabol");
        actiy.setPopulation(1780000);
        cities.add(actiy);
        app.printCityReport(cities);
        System.out.println("=================================================================================================");
    }

    @Test
    void printCityReportTestNull()
    {
        System.out.println("City Report Null Testing~~");
        app.printCityReport(null);
        System.out.println("=================================================================================================");
    }

    @Test
    void printCityReportTestEmpty()
    {
        System.out.println("City Report Empty Testing~~");
        ArrayList<City> cities = new ArrayList<City>();
        app.printCityReport(cities);
        System.out.println("=================================================================================================");

    }

    @Test
    void printCapCityReportTest()
    {
        System.out.println("Normal Capital City Report List Testing~~");
        ArrayList<Capital> cap_cities = new ArrayList<Capital>();
        Capital ca = new Capital();
        ca.setName("Caracas");
        ca.setCountry("Venezuela");
        ca.setDistrict("Distrito Federal");
        ca.setPopulation(1975294);
        cap_cities.add(ca);
        app.printCapCityReport(cap_cities);
        System.out.println("=================================================================================================");
    }

    @Test
    void printCapCityReportTestNull()
    {
        System.out.println("Capital City Report Null Testing~~");
        app.printCapCityReport(null);
        System.out.println("=================================================================================================");
    }

    @Test
    void printCapCityReportTestEmpty()
    {
        System.out.println("Capital City Report Empty Testing~~");
        ArrayList<Capital> cap_cities = new ArrayList<Capital>();
        app.printCapCityReport(cap_cities);
        System.out.println("=================================================================================================");

    }

    @Test
    void printPopulationReportTest()
    {
        System.out.println("Normal Population Report List Testing~~");
        ArrayList<Population> populations = new ArrayList<Population>();
        Population pop = new Population();
        pop.setName("Vietnam");
        pop.setTotal_population(79832000);
        pop.setCity_population(9364813);
        pop.setNon_city_population(70467187);
        populations.add(pop);
        app.printPopulationReport(populations);
        System.out.println("=================================================================================================");
    }

    @Test
    void printPopulationReportTestNull()
    {
        System.out.println("Population Report Null Testing~~");
        app.printPopulationReport(null);
        System.out.println("=================================================================================================");
    }

    @Test
    void printPopulationReportTestEmpty()
    {
        System.out.println("Population Report Empty Testing~~");
        ArrayList<Population> populations = new ArrayList<Population>();
        app.printPopulationReport(populations);
        System.out.println("=================================================================================================");

    }

}