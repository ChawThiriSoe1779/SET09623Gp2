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
}