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
    void GetCityReportTest()
    {
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
    void getCapitalReportTest()
    {
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
    void getPopulationReportTest()
    {
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
    void getTotalPopulation(){
        // Extract total population in the world
        app.getnPrintPopulation_Wrold();
        System.out.println("Testing to retrieve population of the world successful");
        System.out.println("=================================================================================================");

        // Extract total population in the continent
        String continent = "Africa";
        app.getnPrintPopulation_Continent(continent);
        System.out.println("Testing to retrieve population of "+continent+" continent successful");
        System.out.println("=================================================================================================");

        // Extract total population in the region
        String region = "Southeast Asia";
        app.getnPrintPopulation_Region(region);
        System.out.println("Testing to retrieve population of "+region+" caribbean region successful");
        System.out.println("=================================================================================================");

        // Extract total population in the country
        String country = "China";
        app.getnPrintPopulation_Country(country);
        System.out.println("Testing to retrieve population of "+country+" successful");
        System.out.println("=================================================================================================");

        // Extract total population in the district
        String district = "Gelderland";
        app.getnPrintPopulation_District(district);
        System.out.println("Testing to retrieve population of "+district+" successful");
        System.out.println("=================================================================================================");

        // Extract total population in the city
        String city = "Campina Grande";
        app.getnPrintPopulation_City(city);
        System.out.println("Testing to retrieve population of "+city+" successful");
        System.out.println("=================================================================================================");

    }

    @Test
    void getLanguagePopulation(){
        //get and print population of chinese speakers in the world with percentage
        app.peopleSpeakChinese();
        System.out.println("Testing to retrieve population of the chinese speaker in the world successful");
        System.out.println("=================================================================================================");

        //get and print population of english speakers in the world with percentage
        app.peopleSpeakEnglish();
        System.out.println("Testing to retrieve population of the english speaker in the world successful");
        System.out.println("=================================================================================================");

        //get and print population of Hindi speakers in the world with percentage
        app.peopleSpeakHindi();
        System.out.println("Testing to retrieve population of the hindi speaker in the world successful");
        System.out.println("=================================================================================================");

        //get and print population of spanish speakers in the world with percentage
        app.peopleSpeakSpanish();
        System.out.println("Testing to retrieve population of the spanish speaker in the world successful");
        System.out.println("=================================================================================================");

        //get and print population of arabic speakers in the world with percentage
        app.peopleSpeakArabic();
        System.out.println("Testing to retrieve population of the arabic speaker in the world successful");
        System.out.println("=================================================================================================");
    }

}