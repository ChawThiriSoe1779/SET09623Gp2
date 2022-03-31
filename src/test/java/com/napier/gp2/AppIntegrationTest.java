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
        coun.setCode("VEN");
        assertEquals(coun.getCode(),"VEN");
        coun.setName("Venezuela");
        assertEquals(coun.getName(),"Venezuela");
        coun.setContinent("South America");
        assertEquals(coun.getContinent(),"South America");
        coun.setRegion("South America");
        assertEquals(coun.getRegion(),"South America");
        coun.setPopulation(24170000);
        assertEquals(coun.getPopulation(),24170000);
        coun.setCapital("Caracas");
        assertEquals(coun.getCapital(),"Caracas");

        System.out.println("=================================================================================================");
    }
}