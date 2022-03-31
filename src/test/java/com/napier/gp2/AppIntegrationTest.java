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

    @Test
    void GetCountriesReportTest()
    {

        Country coun = new Country();

        ArrayList<Country> expected = new ArrayList<Country>();

        coun.setCode("CHN");

        coun.setName("China");
        String code = coun.getCode();
        coun.setContinent("Asia");
        coun.setRegion("Eastern Asia");
        coun.setPopulation(1277558000);
        coun.setCapital("Peking");
        expected.add(coun);
        ArrayList<Country> result = app.getCountries_World();

        assertEquals(code, result.get(0).getCode());

        System.out.println("=================================================================================================");
    }
}