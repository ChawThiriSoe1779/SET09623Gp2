package com.napier.gp2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        // Countries in the world from largest population to smallest
        System.out.println("Testing to retrieve the countries in the world from largest population to smallest~~");
        app.getCountries_World();
        System.out.println("Successfully retrieved the countries in the world from largest population to smallest ");
        System.out.println("=================================================================================================");


        // Countries in the continent from largest population to smallest
        System.out.println("Testing to retrieve the countries in the continent from largest population to smallest~~");
        app.getCountries_Continent();
        System.out.println("Successfully retrieved the countries in the continent from largest population to smallest ");
        System.out.println("=================================================================================================");


        // Countries in the region from largest population to smallest
        System.out.println("Testing to retrieve the countries in the region from largest population to smallest~~");
        app.getCountries_Region();
        System.out.println("Successfully retrieved the countries in the region from largest population to smallest ");
        System.out.println("=================================================================================================");


        // Top N populated Country in the World
        System.out.println("Testing to retrieve Top N populated countries in the world~~");
        app.getTopNPopulatedCountries_World();
        System.out.println("Successfully retrieved Top N populated counties in the world ");
        System.out.println("=================================================================================================");


        // Top N populated Country in the continent
        System.out.println("Testing to retrieve Top N populated countries in the continent~~");
        app.getTopNPopulatedCountries_Continent();
        System.out.println("Successfully retrieved Top N populated counties in the continent ");
        System.out.println("=================================================================================================");


        // Top N populated Country in the region
        System.out.println("Testing to retrieve Top N populated countries in the region~~");
        app.getTopNPopulatedCountries_Region();
        System.out.println("Successfully retrieved Top N populated counties in the region ");
        System.out.println("=================================================================================================");


    }

    @Test
    void GetCityReportTest()
    {
        // get city data of the world
        System.out.println("Testing to retrieve the cities in the world from largest population to smallest~~");
        app.getCities_World();
        System.out.println("Successfully retrieved the cities in the world from largest population to smallest ");
        System.out.println("=================================================================================================");


        // get city data of the continent
        System.out.println("Testing to retrieve the cities in the continent from largest population to smallest~~");
        app.getCities_Continent();
        System.out.println("Successfully retrieved the cities in the continent from largest population to smallest ");
        System.out.println("=================================================================================================");


        // get city data of the region
        System.out.println("Testing to retrieve the cities in the region from largest population to smallest~~");
        app.getCities_Region();
        System.out.println("Successfully retrieved the cities in the region from largest population to smallest ");
        System.out.println("=================================================================================================");

        // get city data of the district
        System.out.println("Testing to retrieve the cities in the district from largest population to smallest~~");
        app.getCities_District();
        System.out.println("Successfully retrieved the cities in the district from largest population to smallest ");
        System.out.println("=================================================================================================");

        // get city data of the country
        System.out.println("Testing to retrieve the cities in the country from largest population to smallest~~");
        app.getCities_Country();
        System.out.println("Successfully retrieved the cities in the country from largest population to smallest ");
        System.out.println("=================================================================================================");

        // Extract information of top N populated cities in the world
        System.out.println("Testing to retrieve Top N populated cities in the world~~");
        app.getTopNPopulatedCity_World();
        System.out.println("Successfully retrieved Top N populated cities in the world ");
        System.out.println("=================================================================================================");

        // Extract information of top N populated cities in a continent
        System.out.println("Testing to retrieve Top N populated cities in the continent~~");
        app.getTopNPopulatedCity_Continent();
        System.out.println("Successfully retrieved Top N populated cities in the continent ");
        System.out.println("=================================================================================================");

        // Extract information of top N populated cities in a region
        System.out.println("Testing to retrieve Top N populated cities in the region~~");
        app.getTopNPopulatedCity_Region();
        System.out.println("Successfully retrieved Top N populated cities in the region ");
        System.out.println("=================================================================================================");

        // Extract information of top N populated cities in a country
        System.out.println("Testing to retrieve Top N populated cities in the country~~");
        app.getTopNPopulatedCity_Country();
        System.out.println("Successfully retrieved Top N populated cities in the country ");
        System.out.println("=================================================================================================");

        // Extract information of top N populated cities in a district
        System.out.println("Testing to retrieve Top N populated cities in the district~~");
        app.getTopNPopulatedCity_District();
        System.out.println("Successfully retrieved Top N populated cities in the district ");
        System.out.println("=================================================================================================");
    }

    @Test
    void getCapitalReportTest()
    {
        // get capital city data of the world
        System.out.println("Testing to retrieve the capital cities in the world from largest population to smallest~~");
        app.getCapCities_World();
        System.out.println("Successfully retrieved the capital cities in the world from largest population to smallest ");
        System.out.println("=================================================================================================");

        // get capital city data of the continent
        System.out.println("Testing to retrieve the capital cities in the world from largest population to smallest~~");
        app.getCapCities_Continent();
        System.out.println("Successfully retrieved the capital cities in the world from largest population to smallest ");
        System.out.println("=================================================================================================");

        // get capital city data of the region
        System.out.println("Testing to retrieve the capital cities in the world from largest population to smallest~~");
        app.getCapCities_Region();
        System.out.println("Successfully retrieved the capital cities in the world from largest population to smallest ");
        System.out.println("=================================================================================================");

        // get data of top N populated capital cities in the world
        System.out.println("Testing to retrieve Top N populated capital cities in the world~~");
        app.getTopNPopulatedCapCity_World();
        System.out.println("Successfully retrieved Top N populated capital cities in the world ");
        System.out.println("=================================================================================================");

        // get data of top N populated capital cities in the continent
        System.out.println("Testing to retrieve Top N populated capital cities in the continent~~");
        app.getTopNPopulatedCapCity_Continent();
        System.out.println("Successfully retrieved Top N populated capital cities in the continent ");
        System.out.println("=================================================================================================");

        // get data of top N populated capital cities in the region
        System.out.println("Testing to retrieve Top N populated capital cities in the region~~");
        app.getTopNPopulatedCapCity_Region();
        System.out.println("Successfully retrieved Top N populated capital cities in the region ");
        System.out.println("=================================================================================================");
    }

    @Test
    void getPopulationReportTest()
    {
        // Extract information of number of population of people, people living in cities, and people not living in cities in each continent
        System.out.println("Testing to retrieve the number of population of people, people living in cities, and people not living in cities in each continent~~");
        app.getPopulation_Continent();
        System.out.println("Successfully retrieved the number of population of people, people living in cities, and people not living in cities in each continent ");
        System.out.println("=================================================================================================");

        // Extract information of number of population of people, people living in cities, and people not living in cities in each region
        System.out.println("Testing to retrieve the number of population of people, people living in cities, and people not living in cities in each region~~");
        app.getPopulation_Region();
        System.out.println("Successfully retrieved the number of population of people, people living in cities, and people not living in cities in each region ");
        System.out.println("=================================================================================================");

        // Extract information of number of population of people, people living in cities, and people not living in cities in each country
        System.out.println("Testing to retrieve the number of population of people, people living in cities, and people not living in cities in each country~~");
        app.getPopulation_Country();
        System.out.println("Successfully retrieved the number of population of people, people living in cities, and people not living in cities in each country ");
        System.out.println("=================================================================================================");
    }

}