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
     * Function to integrated test for Countries in the world from the largest population to smallest
     */
    @Test
    void testCountries_World() {

        String expectedCode = "CHN";
        String expectedName = "China";
        String expectedContinent = "Asia";
        String expectedRegion = "Eastern Asia";
        int expectedPopulation = 1_277_558_000;
        String expectedCapital = "Peking";

        ArrayList<Country> countries = app.getCountries_World();
        String actualCode = countries.get(0).getCode();
        String actualName = countries.get(0).getName();
        String actualContinent = countries.get(0).getContinent();
        String actualRegion = countries.get(0).getRegion();
        int actualPopulation = countries.get(0).getPopulation();
        String actualCapital = countries.get(0).getCapital();


        assertEquals(expectedCode,actualCode);
        assertEquals(expectedName,actualName);
        assertEquals(expectedContinent,actualContinent);
        assertEquals(expectedRegion,actualRegion);
        assertEquals(expectedPopulation,actualPopulation);
        assertEquals(expectedCapital,actualCapital);

        System.out.println("Testing to retrieve the countries in the world from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * Function to integrated test for Countries in the continent from the largest population to smallest
     */
    @Test
    void testCountries_Continent() {

        String expectedCode = "ZAF";
        String expectedName = "South Africa";
        String expectedContinent = "Africa";
        String expectedRegion = "Southern Africa";
        int expectedPopulation = 40_377_000;
        String expectedCapital = "Pretoria";

        ArrayList<Country> countries = app.getCountries_Continent();

        assertEquals(expectedCode,countries.get(4).getCode());
        assertEquals(expectedName,countries.get(4).getName());
        assertEquals(expectedContinent,countries.get(4).getContinent());
        assertEquals(expectedRegion,countries.get(4).getRegion());
        assertEquals(expectedPopulation,countries.get(4).getPopulation());
        assertEquals(expectedCapital,countries.get(4).getCapital());

        System.out.println("Testing to retrieve the countries in the continent from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * Function to integrated test for Countries in the region from the largest population to smallest
     */
    @Test
    void testCountries_Region() {

        String expectedCode = "CUB";
        String expectedName = "Cuba";
        String expectedContinent = "North America";
        String expectedRegion = "Caribbean";
        int expectedPopulation = 11_201_000;
        String expectedCapital = "La Habana";

        ArrayList<Country> countries = app.getCountries_Region();

        assertEquals(expectedCode,countries.get(0).getCode());
        assertEquals(expectedName,countries.get(0).getName());
        assertEquals(expectedContinent,countries.get(0).getContinent());
        assertEquals(expectedRegion,countries.get(0).getRegion());
        assertEquals(expectedPopulation,countries.get(0).getPopulation());
        assertEquals(expectedCapital,countries.get(0).getCapital());

        System.out.println("Testing to retrieve the countries in the region from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * Function to integrated test for Top N populated Country in the World
     */
    @Test
    void testTopNCountries_World() {

        String expectedCode = "USA";
        String expectedName = "United States";
        String expectedContinent = "North America";
        String expectedRegion = "North America";
        int expectedPopulation = 278_357_000;
        String expectedCapital = "Washington";

        ArrayList<Country> countries = app.getTopNPopulatedCountries_World();

        assertEquals(expectedCode,countries.get(2).getCode());
        assertEquals(expectedName,countries.get(2).getName());
        assertEquals(expectedContinent,countries.get(2).getContinent());
        assertEquals(expectedRegion,countries.get(2).getRegion());
        assertEquals(expectedPopulation,countries.get(2).getPopulation());
        assertEquals(expectedCapital,countries.get(2).getCapital());

        System.out.println("Testing to retrieve Top N populated counties in the world is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * Function to integrated test for Top N populated Country in the Continent
     */
    @Test
    void testTopNCountries_Continent() {

        String expectedCode = "MEX";
        String expectedName = "Mexico";
        String expectedContinent = "North America";
        String expectedRegion = "Central America";
        int expectedPopulation = 98_881_000;
        String expectedCapital = "Ciudad de México";

        ArrayList<Country> countries = app.getTopNPopulatedCountries_Continent();

        assertEquals(expectedCode,countries.get(1).getCode());
        assertEquals(expectedName,countries.get(1).getName());
        assertEquals(expectedContinent,countries.get(1).getContinent());
        assertEquals(expectedRegion,countries.get(1).getRegion());
        assertEquals(expectedPopulation,countries.get(1).getPopulation());
        assertEquals(expectedCapital,countries.get(1).getCapital());

        System.out.println("Testing to retrieve Top N populated counties in the continent is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * Function to integrated test for Top N populated Country in the Region
     */
    @Test
    void testTopNCountries_Region() {

        String expectedCode = "IDN";
        String expecteName = "Indonesia";
        String expectedContinent = "Asia";
        String expectedRegion = "Southeast Asia";
        int expectedPopulation = 212_107_000;
        String expectedCapital = "Jakarta";

        ArrayList<Country> countries = app.getTopNPopulatedCountries_Region();

        assertEquals(expectedCode,countries.get(0).getCode());
        assertEquals(expecteName,countries.get(0).getName());
        assertEquals(expectedContinent,countries.get(0).getContinent());
        assertEquals(expectedRegion,countries.get(0).getRegion());
        assertEquals(expectedPopulation,countries.get(0).getPopulation());
        assertEquals(expectedCapital,countries.get(0).getCapital());

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

    /**
     * Function to integrated test for Cities in the world from the largest population to smallest
     */
    @Test
    void testCities_World() {

        String expectedName = "Seoul";
        String expectedCountry = "South Korea";
        String expectedDistrict = "Seoul";
        int expectedPopulation = 9_981_619;

        ArrayList<City> cities = app.getCities_World();

        assertEquals(expectedName,cities.get(1).getName());
        assertEquals(expectedCountry,cities.get(1).getCountry());
        assertEquals(expectedDistrict,cities.get(1).getDistrict());
        assertEquals(expectedPopulation,cities.get(1).getPopulation());

        System.out.println("Testing to retrieve the cities in the world from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * Function to integrated test for Cities in the continent from the largest population to smallest
     */
    @Test
    void testCities_Continent() {

        String expectedName = "Mumbai (Bombay)";
        String expectedCountry = "India";
        String expectedDistrict = "Maharashtra";
        int expectedPopulation = 10_500_000;

        ArrayList<City> cities = app.getCities_Continent();

        assertEquals(expectedName,cities.get(0).getName());
        assertEquals(expectedCountry,cities.get(0).getCountry());
        assertEquals(expectedDistrict,cities.get(0).getDistrict());
        assertEquals(expectedPopulation,cities.get(0).getPopulation());

        System.out.println("Testing to retrieve the cities in the continent from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * Function to integrated test for Cities in the region from the largest population to smallest
     */
    @Test
    void testCities_Region() {

        String expectedName = "Apia";
        String expectedCountry = "Samoa";
        String expectedDistrict = "Upolu";
        int expectedPopulation = 35_900;

        ArrayList<City> cities = app.getCities_Region();

        assertEquals(expectedName,cities.get(0).getName());
        assertEquals(expectedCountry,cities.get(0).getCountry());
        assertEquals(expectedDistrict,cities.get(0).getDistrict());
        assertEquals(expectedPopulation,cities.get(0).getPopulation());

        System.out.println("Testing to retrieve the cities in the region from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * Function to integrated test for Cities in the district from the largest population to smallest
     */
    @Test
    void testCities_District() {

        String expectedName = "Ahmedabad";
        String expectedCountry = "India";
        String expectedDistrict = "Gujarat";
        int expectedPopulation = 2_876_710;

        ArrayList<City> cities = app.getCities_District();

        assertEquals(expectedName,cities.get(0).getName());
        assertEquals(expectedCountry,cities.get(0).getCountry());
        assertEquals(expectedDistrict,cities.get(0).getDistrict());
        assertEquals(expectedPopulation,cities.get(0).getPopulation());

        System.out.println("Testing to retrieve the cities in the district from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * Function to integrated test for Cities in the country from the largest population to smallest
     */
    @Test
    void testCities_Country() {

        String expectedName = "Shanghai";
        String expectedCountry = "China";
        String expectedDistrict = "Shanghai";
        int expectedPopulation = 9_696_300;

        ArrayList<City> cities = app.getCities_Country();

        assertEquals(expectedName,cities.get(0).getName());
        assertEquals(expectedCountry,cities.get(0).getCountry());
        assertEquals(expectedDistrict,cities.get(0).getDistrict());
        assertEquals(expectedPopulation,cities.get(0).getPopulation());

        System.out.println("Testing to retrieve the cities in the country from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * Function to integrated test for Top N populated Cities in the world
     */
    @Test
    void testTopNCities_World() {

        String expectedName = "Mumbai (Bombay)";
        String expectedCountry = "India";
        String expectedDistrict = "Maharashtra";
        int expectedPopulation = 10_500_000;

        ArrayList<City> cities = app.getTopNPopulatedCity_World();

        assertEquals(expectedName,cities.get(0).getName());
        assertEquals(expectedCountry,cities.get(0).getCountry());
        assertEquals(expectedDistrict,cities.get(0).getDistrict());
        assertEquals(expectedPopulation,cities.get(0).getPopulation());

        System.out.println("Testing to retrieve Top N populated cities in the world is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * Function to integrated test for Top N populated Cities in the Continent
     */
    @Test
    void testTopNCities_Continent() {

        String expectedName = "Sydney";
        String expectedCountry = "Australia";
        String expectedDistrict = "New South Wales";
        int expectedPopulation = 3_276_207;

        ArrayList<City> cities = app.getTopNPopulatedCity_Continent();

        assertEquals(expectedName,cities.get(0).getName());
        assertEquals(expectedCountry,cities.get(0).getCountry());
        assertEquals(expectedDistrict,cities.get(0).getDistrict());
        assertEquals(expectedPopulation,cities.get(0).getPopulation());

        System.out.println("Testing to retrieve Top N populated cities in the continent is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * Function to integrated test for Top N populated Cities in the region
     */
    @Test
    void testTopNCities_Region() {

        String expectedName = "Jakarta";
        String expectedCountry = "Indonesia";
        String expectedDistrict = "Jakarta Raya";
        int expectedPopulation = 9_604_900;

        ArrayList<City> cities = app.getTopNPopulatedCity_Region();

        assertEquals(expectedName,cities.get(0).getName());
        assertEquals(expectedCountry,cities.get(0).getCountry());
        assertEquals(expectedDistrict,cities.get(0).getDistrict());
        assertEquals(expectedPopulation,cities.get(0).getPopulation());

        System.out.println("Testing to retrieve Top N populated cities in the region is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * Function to integrated test for Top N populated Cities in the country
     */
    @Test
    void testTopNCities_Country() {

        String expectedName = "København";
        String expectedCountry = "Denmark";
        String expectedDistrict = "København";
        int expectedPopulation = 495_699;

        ArrayList<City> cities = app.getTopNPopulatedCity_Country();

        assertEquals(expectedName,cities.get(0).getName());
        assertEquals(expectedCountry,cities.get(0).getCountry());
        assertEquals(expectedDistrict,cities.get(0).getDistrict());
        assertEquals(expectedPopulation,cities.get(0).getPopulation());

        System.out.println("Testing to retrieve Top N populated cities in the country is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * Function to integrated test for Top N populated Cities in the district
     */
    @Test
    void testTopNCities_District() {

        String expectedName = "Mumbai (Bombay)";
        String expectedCountry = "India";
        String expectedDistrict = "Maharashtra";
        int expectedPopulation = 10_500_000;

        ArrayList<City> cities = app.getTopNPopulatedCity_District();

        assertEquals(expectedName,cities.get(0).getName());
        assertEquals(expectedCountry,cities.get(0).getCountry());
        assertEquals(expectedDistrict,cities.get(0).getDistrict());
        assertEquals(expectedPopulation,cities.get(0).getPopulation());

        System.out.println("Testing to retrieve Top N populated cities in the district is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * Function to integrated test for Capital Cities in the world from the largest population to smallest
     */
    @Test
    void testSizeOfCapCities_World() {

        ArrayList<Capital> cap_cities = app.getCapCities_World();
        assertEquals(213, cap_cities.size());

        System.out.println("Testing to retrieve the capital cities in the world from largest population to smallest is successfully!!");
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
    void testLanguagePopulation() {
        //get and print population of speakers of languages in the world with percentage

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

        System.out.println("Testing to retrieve population of certain language speakers in the world successful");
        System.out.println("=================================================================================================");
    }
}