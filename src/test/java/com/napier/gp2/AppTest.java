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

    /**
     * Prints a normal list of Countries.
     */
    @Test
    void printCountriesReportTest()
    {
        System.out.println("Normal Countries Report List Testing~~");
        ArrayList<Country> countries = new ArrayList<>();
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

    /**
     * Prints when country report is null.
     */
    @Test
    void printCountriesReportTestNull()
    {
        System.out.println("Countries Report Null Testing~~");
        app.printCountriesReport(null);
        System.out.println("=================================================================================================");
    }

    /**
     * Prints when country report is empty.
     */
    @Test
    void printCountriesReportTestEmpty()
    {
        System.out.println("Countries Report Empty Testing~~");
        ArrayList<Country> countries = new ArrayList<>();
        app.printCountriesReport(countries);
        System.out.println("=================================================================================================");

    }

    /**
     * Prints when country report contain null.
     */
    @Test
    void printCountriesReportTestContainNull()
    {
        System.out.println("Countries Report Contain Null Testing~~");
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printCountriesReport(countries);
        System.out.println("=================================================================================================");

    }

    /**
     * Prints a normal list of Cities.
     */
    @Test
    void printCityReportTest()
    {
        System.out.println("Normal City Report List Testing~~");
        ArrayList<City> cities = new ArrayList<>();
        City actiy = new City();
        actiy.setName("Kabul");
        actiy.setCountry("Afghanistan");
        actiy.setDistrict("Kabol");
        actiy.setPopulation(1780000);
        cities.add(actiy);
        app.printCityReport(cities);
        System.out.println("=================================================================================================");
    }

    /**
     * Prints when City report is null.
     */
    @Test
    void printCityReportTestNull()
    {
        System.out.println("City Report Null Testing~~");
        app.printCityReport(null);
        System.out.println("=================================================================================================");
    }

    /**
     * Prints when City report is empty.
     */
    @Test
    void printCityReportTestEmpty()
    {
        System.out.println("City Report Empty Testing~~");
        ArrayList<City> cities = new ArrayList<>();
        app.printCityReport(cities);
        System.out.println("=================================================================================================");

    }

    /**
     * Prints when City report contain null.
     */
    @Test
    void printCityReportTestContainNull()
    {
        System.out.println("City Report Contain Null Testing~~");
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printCityReport(cities);
        System.out.println("=================================================================================================");

    }

    /**
     * Prints a normal list of Capital Cities.
     */
    @Test
    void printCapCityReportTest()
    {
        System.out.println("Normal Capital City Report List Testing~~");
        ArrayList<Capital> cap_cities = new ArrayList<>();
        Capital ca = new Capital();
        ca.setName("Caracas");
        ca.setCountry("Venezuela");
        ca.setDistrict("Distrito Federal");
        ca.setPopulation(1975294);
        cap_cities.add(ca);
        app.printCapCityReport(cap_cities);
        System.out.println("=================================================================================================");
    }

    /**
     * Prints when Capital City report is null.
     */
    @Test
    void printCapCityReportTestNull()
    {
        System.out.println("Capital City Report Null Testing~~");
        app.printCapCityReport(null);
        System.out.println("=================================================================================================");
    }

    /**
     * Prints when Capital City report is empty.
     */
    @Test
    void printCapCityReportTestEmpty()
    {
        System.out.println("Capital City Report Empty Testing~~");
        ArrayList<Capital> cap_cities = new ArrayList<>();
        app.printCapCityReport(cap_cities);
        System.out.println("=================================================================================================");

    }

    /**
     * Prints when Capital City report contain null.
     */
    @Test
    void printCapCityReportTestContainNull()
    {
        System.out.println("Capital City Report Contain Null Testing~~");
        ArrayList<Capital> cap_cities = new ArrayList<>();
        cap_cities.add(null);
        app.printCapCityReport(cap_cities);
        System.out.println("=================================================================================================");

    }

    /**
     * Prints a normal list of Population.
     */
    @Test
    void printPopulationReportTest()
    {
        System.out.println("Normal Population Report List Testing~~");
        ArrayList<Population> populations = new ArrayList<>();
        Population pop = new Population();
        pop.setName("Vietnam");
        pop.setTotal_population(79832000);
        pop.setCity_population(9364813+"("+11.73+"%)");
        pop.setNon_city_population(70467187+"("+88.27+"%)");
        populations.add(pop);
        app.printPopulationReport(populations);
        System.out.println("=================================================================================================");
    }

    /**
     * Prints when Population report is null.
     */
    @Test
    void printPopulationReportTestNull()
    {
        System.out.println("Population Report Null Testing~~");
        app.printPopulationReport(null);
        System.out.println("=================================================================================================");
    }

    /**
     * Prints when Population report is empty.
     */
    @Test
    void printPopulationReportTestEmpty()
    {
        System.out.println("Population Report Empty Testing~~");
        ArrayList<Population> populations = new ArrayList<>();
        app.printPopulationReport(populations);
        System.out.println("=================================================================================================");

    }

    /**
     * Prints when Population report contain null.
     */
    @Test
    void printPopulationReportTestContainNull()
    {
        System.out.println("Population Report Contain Null Testing~~");
        ArrayList<Population> populations = new ArrayList<>();
        populations.add(null);
        app.printPopulationReport(populations);
        System.out.println("=================================================================================================");

    }

}