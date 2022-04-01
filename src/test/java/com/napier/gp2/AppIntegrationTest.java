package com.napier.gp2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    /**
     * Function to integrated test country reports get and print */
    @Test
    void GetCountriesReportTest()
    {

        Country coun = new Country();

        // Countries in the world from largest population to smallest
        ArrayList<Country> countries = app.getCountries_World();
        app.printCountriesReport(countries);

        // Countries in the continent from largest population to smallest
        countries = app.getCountries_Continent();
        app.printCountriesReport(countries);

        // Countries in the region from largest population to smallest
        countries = app.getCountries_Region();
        app.printCountriesReport(countries);

        // Top populated Country in the World
        countries = app.getTopNPopulatedCountries_World();
        app.printCountriesReport(countries);

        // Top populated Country in the continent
        countries = app.getTopNPopulatedCountries_Continent();
        app.printCountriesReport(countries);

        // Top populated Country in the region
        countries = app.getTopNPopulatedCountries_Region();
        app.printCountriesReport(countries);

    }

    @Test
    void GetCityReportTest(){
        City city = new City();

        // get city data of the world
        ArrayList<City> cities = app.getCities_World();
        // print city data
        app.printCityReport(cities);

        // get city data of the continent
        cities = app.getCities_Continent();
        // print city data
        app.printCityReport(cities);

        // get city data of the region
        cities = app.getCities_Region();
        // print city data
        app.printCityReport(cities);

        // get city data of the district
        cities = app.getCities_District();
        // print city data
        app.printCityReport(cities);

        // get city data of the country
        cities = app.getCities_Country();
        // print city data
        app.printCityReport(cities);

        // Extract information of top N populated cities in the world
        cities = app.getTopNPopulatedCity_World();
        // print city data
        app.printCityReport(cities);

        // Extract information of top N populated cities in a continent
        cities = app.getTopNPopulatedCity_Continent();
        // print city data
        app.printCityReport(cities);

        // Extract information of top N populated cities in a region
        cities = app.getTopNPopulatedCity_Region();
        // print city data
        app.printCityReport(cities);

        // Extract information of top N populated cities in a country
        cities = app.getTopNPopulatedCity_Country();
        // print city data
        app.printCityReport(cities);

        // Extract information of top N populated cities in a district
        cities = app.getTopNPopulatedCity_District();
        // print city data
        app.printCityReport(cities);
    }

    @Test
    void getCapitalReportTest(){
        Capital cap = new Capital();

        // get capital city data of the world
        ArrayList<Capital> cap_cities = app.getCapCities_World();
        // print city data
        app.printCapCityReport(cap_cities);

        // get capital city data of the continent
        cap_cities = app.getCapCities_Continent();
        // print city data
        app.printCapCityReport(cap_cities);

        // get capital city data of the region
        cap_cities = app.getCapCities_Region();
        // print city data
        app.printCapCityReport(cap_cities);

        // get data of top N populated capital cities in the world
        cap_cities = app.getTopNPopulatedCapCity_World();
        // print city data
        app.printCapCityReport(cap_cities);

        // get data of top N populated capital cities in the continent
        cap_cities = app.getTopNPopulatedCapCity_Continent();
        // print city data
        app.printCapCityReport(cap_cities);

        // get data of top N populated capital cities in the continent
        cap_cities = app.getTopNPopulatedCapCity_Region();
        // print city data
        app.printCapCityReport(cap_cities);
    }

    @Test
    void getPopulationReportTest(){
        Population pop = new Population();

        // Extract information of number of population of people, people living in cities, and people not living in cities in each continent
        ArrayList<Population> populations = app.getPopulation_Continent();
        // print population data
        app.printPopulationReport(populations);

        // Extract information of number of population of people, people living in cities, and people not living in cities in each region
        populations = app.getPopulation_Region();
        // print population data
        app.printPopulationReport(populations);

        // Extract information of number of population of people, people living in cities, and people not living in cities in each country
        populations = app.getPopulation_Country();
        // print population data
        app.printPopulationReport(populations);
    }


}