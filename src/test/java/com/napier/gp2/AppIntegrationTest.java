package com.napier.gp2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");

    }


    /**
     * Function to integrated test country reports get and print
     */
    @Test
    void GetCountriesReportTest() {
        // Countries in the world from largest population to smallest

        app.getCountries_World();
        System.out.println("Testing to retrieve the countries in the world from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");


        // Countries in the continent from largest population to smallest
        app.getCountries_Continent();
        System.out.println("Testing to retrieve the countries in the continent from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");


        // Countries in the region from largest population to smallest
        app.getCountries_Region();
        System.out.println("Testing to retrieve the countries in the region from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");


        // Top N populated Country in the World
        app.getTopNPopulatedCountries_World();
        System.out.println("Testing to retrieve Top N populated counties in the world is successfully!!");
        System.out.println("=================================================================================================");


        // Top N populated Country in the continent
        app.getTopNPopulatedCountries_Continent();
        System.out.println("Testing to retrieve Top N populated counties in the continent is successfully!!");
        System.out.println("=================================================================================================");


        // Top N populated Country in the region
        app.getTopNPopulatedCountries_Region();
        System.out.println("Testing to retrieve Top N populated counties in the region is successfully!!");
        System.out.println("=================================================================================================");


    }
    @Test
    void GetCountriesEmpty(){
        ArrayList <Country> countriesworld = app.getCountries_World();
        assertEquals(countriesworld.size()>0,true);
        System.out.println("Testing for countries in world array size not being zero completed");
        System.out.println("=================================================================================================");

        ArrayList <Country> countriescontinent = app.getCountries_Continent();
        assertEquals(countriescontinent.size()>0,true);
        System.out.println("Testing for countries in continent array size not being zero completed");
        System.out.println("=================================================================================================");

        ArrayList <Country> countries_region = app.getCountries_Region();
        assertEquals(countries_region.size()>0,true);
        System.out.println("Testing for countries in region array size not being zero completed");
        System.out.println("=================================================================================================");


    }

    @Test
    void GetCitiesEmpty(){
        ArrayList <City> citiesworld = app.getCities_World();
        assertEquals(citiesworld.size()>0,true);
        System.out.println("Testing for city array size not being zero completed");
        System.out.println("=================================================================================================");
    }

    @Test
    void GetCapitalEmpty(){
        ArrayList <Capital> capworld = app.getCapCities_World();
        assertEquals(capworld.size()>0,true);
        System.out.println("Testing for Capital city array size not being zero completed");
        System.out.println("=================================================================================================");
    }

    @Test
    void GetPopulationEmpty(){
        ArrayList <Population> pop = app.getPopulation_Continent();
        assertEquals(pop.size()>0,true);
        System.out.println("Testing for population array size not being zero completed");
        System.out.println("=================================================================================================");
    }

    @Test
    void GetCityReportTest() {
        // get city data of the world
        app.getCities_World();
        System.out.println("Testing to retrieve the cities in the world from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");

        // get city data of the continent
        app.getCities_Continent();
        System.out.println("Testing to retrieve the cities in the continent from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");

        // get city data of the region
        app.getCities_Region();
        System.out.println("Testing to retrieve the cities in the region from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");

        // get city data of the district
        app.getCities_District();
        System.out.println("Testing to retrieve the cities in the district from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");

        // get city data of the country
        app.getCities_Country();
        System.out.println("Testing to retrieve the cities in the country from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");

        // Extract information of top N populated cities in the world
        app.getTopNPopulatedCity_World();
        System.out.println("Testing to retrieve Top N populated cities in the world is successfully!!");
        System.out.println("=================================================================================================");

        // Extract information of top N populated cities in a continent
        app.getTopNPopulatedCity_Continent();
        System.out.println("Testing to retrieve Top N populated cities in the continent is successfully!!");
        System.out.println("=================================================================================================");

        // Extract information of top N populated cities in a region
        app.getTopNPopulatedCity_Region();
        System.out.println("Testing to retrieve Top N populated cities in the region is successfully!!");
        System.out.println("=================================================================================================");

        // Extract information of top N populated cities in a country
        app.getTopNPopulatedCity_Country();
        System.out.println("Testing to retrieve Top N populated cities in the country is successfully!!");
        System.out.println("=================================================================================================");

        // Extract information of top N populated cities in a district
        app.getTopNPopulatedCity_District();
        System.out.println("Testing to retrieve Top N populated cities in the district is successfully!!");
        System.out.println("=================================================================================================");
    }

    @Test
    void getCapitalReportTest() {
        // get capital city data of the world
        app.getCapCities_World();
        System.out.println("Testing to retrieve the capital cities in the world from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");

        // get capital city data of the continent
        app.getCapCities_Continent();
        System.out.println("Testing to retrieve the capital cities in the world from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");

        // get capital city data of the region
        app.getCapCities_Region();
        System.out.println("Testing to retrieve the capital cities in the world from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");

        // get data of top N populated capital cities in the world
        app.getTopNPopulatedCapCity_World();
        System.out.println("Testing to retrieve Top N populated capital cities in the world is successfully!!");
        System.out.println("=================================================================================================");

        // get data of top N populated capital cities in the continent
        app.getTopNPopulatedCapCity_Continent();
        System.out.println("Testing to retrieve Top N populated capital cities in the continent is successfully!!");
        System.out.println("=================================================================================================");

        // get data of top N populated capital cities in the region
        app.getTopNPopulatedCapCity_Region();
        System.out.println("Testing to retrieve Top N populated capital cities in the region is successfully!!");
        System.out.println("=================================================================================================");
    }

    @Test
    void getPopulationReportTest() {
        // Extract information of number of population of people, people living in cities, and people not living in cities in each continent
        app.getPopulation_Continent();
        System.out.println("Testing to retrieve the number of population of people, people living in cities, and people not living in cities in each continent is successfully!!");
        System.out.println("=================================================================================================");

        // Extract information of number of population of people, people living in cities, and people not living in cities in each region
        app.getPopulation_Region();
        System.out.println("Testing to retrieve the number of population of people, people living in cities, and people not living in cities in each region is successfully!!");
        System.out.println("=================================================================================================");

        // Extract information of number of population of people, people living in cities, and people not living in cities in each country
        app.getPopulation_Country();
        System.out.println("Testing to retrieve the number of population of people, people living in cities, and people not living in cities in each country is successfully!!");
        System.out.println("=================================================================================================");
    }

    @Test
    void getTotalPopulation() {
        // Extract total population in the world

        //expected output of number of people in the world
        String expectedOutput = "There are 6078749450 people in the world.";
        //actual output of  number of people in the world
        String actualOutput = app.getnPrintPopulation_Wrold();
        assertEquals(expectedOutput, actualOutput);
        System.out.println("Testing to retrieve population of the world successful");
        System.out.println("=================================================================================================");
    }
    @Test
    void getTotalPopulationContinent() {
        // Extract total population in the continent
        String continent = "Asia";
        //expected output of number of people in the Asia Continent
        String expectedOutput = "There are 3705025700 people in the 'Asia' continent.";
        //actual output of  number of people in the Asia Continent
        String actualOutput = app.getnPrintPopulation_Continent(continent);
        assertEquals(expectedOutput, actualOutput);
        System.out.println("Testing to retrieve population of " + continent + " continent successful");
        System.out.println("=================================================================================================");
    }

    @Test
    void getTotalPopulationRegion() {
        // Extract total population in the region
        String region = "Caribbean";
        //expected output of number of people in the Caribbean Region
        String expectedOutput = "There are 38140000 people in the 'Caribbean' region.";
        //actual output of  number of people in the Caribbean Region
        String actualOutput = app.getnPrintPopulation_Region(region);
        assertEquals(expectedOutput, actualOutput);

        System.out.println("Testing to retrieve population of " + region + " region successful");
        System.out.println("=================================================================================================");
    }
    @Test
    void getTotalPopulationCountry() {
        // Extract total population in the country
        String country = "Denmark";
        //expected output of number of people in the Denmark Country
        String expectedOutput = "There are 5330000 people in the 'Denmark' country.";
        //actual output of  number of people in the Denmark Country
        String actualOutput = app.getnPrintPopulation_Country(country);
        assertEquals(expectedOutput, actualOutput);
        System.out.println("Testing to retrieve population of " + country + " country successful");
        System.out.println("=================================================================================================");
    }

    @Test
    void getTotalPopulationDistrict() {
        // Extract total population in the district
        String district = "Gujarat";
        //expected output of number of people in the Gujarat District
        String expectedOutput = "There are 8425343 people in the 'Gujarat' district.";
        //actual output of  number of people in the Gujarat District
        String actualOutput = app.getnPrintPopulation_District(district);
        assertEquals(expectedOutput, actualOutput);
        System.out.println("Testing to retrieve population of " + district + " district successful");
        System.out.println("=================================================================================================");
    }

    @Test
    void getTotalPopulationCity(){
        // Extract total population in the city
        String city = "Seoul";
       //expected output of number of people in the Seoul city
        String expectedOutput = "There are 9981619 people in the 'Seoul' city.";
        //actual output of  number of people in the Seoul City
        String actualOutput = app.getnPrintPopulation_City(city);
        assertEquals(expectedOutput, actualOutput);
        System.out.println("Testing to retrieve population of " + city + " city successful");
        System.out.println("=================================================================================================");
    }

    @Test
    void getLangaugePopulation() {
        //get and print population of speakers of langauges in the world with percentage
        System.out.println("Testing to retrieve population of the chinese speaker in the world successful");
        System.out.println("=================================================================================================");

        String expectedName = "Chinese";
        long expectedPopulation = 1_191_843_539L;
        float expectedPercentage = (float) 19.606724;

        ArrayList<Language> langu = app.getpeopleSpeakPopulation();
        String actualName = String.valueOf(langu.get(0).getName());
        long actualPopulation = langu.get(0).getPopulation();
        float actualPercentage = langu.get(0).getPercentage();

        assertEquals(expectedName,actualName);
        assertEquals(expectedPopulation,actualPopulation);
        assertEquals(expectedPercentage,actualPercentage);
    }
}