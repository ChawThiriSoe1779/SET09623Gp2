package com.napier.gp2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location, int delay)
    {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

        }

        catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to world database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database

                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "group2");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     Function to access all the Countries in the world sorted by largest to smallest population
     @return A list of Countries in the world sorted by largest to smallest population
     **/
    public ArrayList<Country> getCountries_World()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name FROM country INNER JOIN city on country.capital = city.ID ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.setCode(rset.getString("country.Code"));
                coun.setName(rset.getString("country.Name"));
                coun.setContinent(rset.getString("country.Continent"));
                coun.setRegion(rset.getString("country.Region"));
                coun.setPopulation(rset.getInt("country.Population"));
                coun.setCapital(rset.getString("city.Name"));
                countries.add(coun);
            }
            System.out.println("\nCountries in the world sorted by largest to smallest population\n===========================================================================================");
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            return null;
        }
    }

    /**
     Function to access all the Countries in the continent sorted by largest to smallest population
     @return A list of Countries in the continent sorted by largest to smallest population
     @var continent a string variable for selecting a continent for display Countries
     **/
    public ArrayList<Country> getCountries_Continent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String continent = "'Africa'";
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name FROM country INNER JOIN city on country.capital = city.ID WHERE country.Continent="+ continent +" ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.setCode(rset.getString("country.Code"));
                coun.setName(rset.getString("country.Name"));
                coun.setContinent(rset.getString("country.Continent"));
                coun.setRegion(rset.getString("country.Region"));
                coun.setPopulation(rset.getInt("country.Population"));
                coun.setCapital(rset.getString("city.Name"));
                countries.add(coun);
            }
            System.out.println("\nCountries in the Continent sorted by largest to smallest population\n===========================================================================================");
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            return null;
        }
    }

    /**
     Function to access all the Countries in the region sorted by largest to smallest population
     @return A list of Countries in the region sorted by largest to smallest population
     @var region a string variable for selecting a region to display Countries
     **/
    public ArrayList<Country> getCountries_Region()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String region = "'Caribbean'";
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name FROM country INNER JOIN city on country.capital = city.ID WHERE country.Region="+ region +" ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.setCode(rset.getString("country.Code"));
                coun.setName(rset.getString("country.Name"));
                coun.setContinent(rset.getString("country.Continent"));
                coun.setRegion(rset.getString("country.Region"));
                coun.setPopulation(rset.getInt("country.Population"));
                coun.setCapital(rset.getString("city.Name"));
                countries.add(coun);
            }
            System.out.println("\nCountries in the Region sorted by largest to smallest population\n===========================================================================================");
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            return null;
        }
    }


    /***
     Get a list of top N populated Countries in the world.
     @return A list of top N populated Countries
     @var limitno an integer for "N" in a list of top N populated Countries in the world
     */
    public ArrayList<Country> getTopNPopulatedCountries_World()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            int limitno = 20;       // for N in a list of Top "N" populated country in the world
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name FROM country INNER JOIN city on country.capital = city.ID ORDER BY country.Population DESC LIMIT "+ limitno;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.setCode(rset.getString("country.Code"));
                coun.setName(rset.getString("country.Name"));
                coun.setContinent(rset.getString("country.Continent"));
                coun.setRegion(rset.getString("country.Region"));
                coun.setPopulation(rset.getInt("country.Population"));
                coun.setCapital(rset.getString("city.Name"));
                countries.add(coun);
            }
            System.out.println("\nList of Top " + limitno + " Populated Country in the World\n===========================================================================================");
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            return null;
        }
    }

    /**
     Get a list of top N populated Countries in the continent.
     @return A list of top N populated Countries
     @var limitno an integer for N in a list of top "N" populated Countries in the continent
     @var continent an string for continent in a list of top N populated Countries in the "continent"
     */
    public ArrayList<Country> getTopNPopulatedCountries_Continent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            int limitno = 20;       // for N in a list of Top "N" populated country in the world
            String continent = "'North America'";
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name FROM country INNER JOIN city on country.capital = city.ID WHERE country.Continent="+ continent + " ORDER BY country.Population DESC LIMIT "+limitno;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.setCode(rset.getString("country.Code"));
                coun.setName(rset.getString("country.Name"));
                coun.setContinent(rset.getString("country.Continent"));
                coun.setRegion(rset.getString("country.Region"));
                coun.setPopulation(rset.getInt("country.Population"));
                coun.setCapital(rset.getString("city.Name"));
                countries.add(coun);
            }
            System.out.println("\nList of Top " + limitno + " Populated Country in the "+ continent+" Continent\n===========================================================================================");
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            return null;
        }
    }

    /**
     Get a list of top N populated Countries in the region.
     @return A list of top N populated Countries
     @var limitno an integer for N in a list of top "N" populated Countries in the region
     @var region an string for continent in a list of top N populated Countries in the "region"
     */
    public ArrayList<Country> getTopNPopulatedCountries_Region()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            int limitno = 20;       // for N in a list of Top "N" populated country in the world
            String region = "'Southeast Asia'";
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name FROM country INNER JOIN city on country.capital = city.ID WHERE country.Region="+ region + " ORDER BY country.Population DESC LIMIT "+limitno;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.setCode(rset.getString("country.Code"));
                coun.setName(rset.getString("country.Name"));
                coun.setContinent(rset.getString("country.Continent"));
                coun.setRegion(rset.getString("country.Region"));
                coun.setPopulation(rset.getInt("country.Population"));
                coun.setCapital(rset.getString("city.Name"));
                countries.add(coun);
            }
            System.out.println("\nList of Top " + limitno + " Populated Country in the "+ region+" Region\n===========================================================================================");
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            return null;
        }
    }




    /**
     Function to access all the cities in the world sorted by largest to smallest population
     @return A list of cities in the world sorted by largest to smallest population
     **/
    public ArrayList<City>getCities_World()
    {
        try
        {
            // Create an SQL statement
            Statement sql = con.createStatement();

            // Create string for SQL statement
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on city.CountryCode=country.Code ORDER BY city.Population DESC;";

            // Execute SQL statement
            ResultSet result = sql.executeQuery(getCityReports);

            // Extract city data
            ArrayList<City> cities = new ArrayList<>();
            while (result.next())
            {
                City actiy = new City();
                actiy.setName(result.getString("city.Name"));
                actiy.setCountry(result.getString("country.Name"));
                actiy.setDistrict(result.getString("city.District"));
                actiy.setPopulation(result.getInt("city.Population"));
                cities.add(actiy);
            }
            System.out.println("\nCities in the world sorted by largest to smallest population\n===========================================================================================");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Cities in the world database");
            return null;
        }
    }

    /**
     Function to access all the cities in the continent sorted by largest to smallest population
     @return A list of cities in the continent sorted by largest to smallest population
     @var continent a string variable for selecting a continent for display cities
     **/
    public ArrayList<City>getCities_Continent()
    {
        try
        {
            // Create an SQL statement
            Statement sql = con.createStatement();

            // Create string for SQL statement
            String continent = "'Asia'";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on city.CountryCode=country.Code WHERE country.Continent="+ continent  +" ORDER BY city.Population DESC;";

            // Execute SQL statement
            ResultSet result = sql.executeQuery(getCityReports);

            // Extract city data
            ArrayList<City> cities = new ArrayList<>();
            while (result.next())
            {
                City actiy = new City();
                actiy.setName(result.getString("city.Name"));
                actiy.setCountry(result.getString("country.Name"));
                actiy.setDistrict(result.getString("city.District"));
                actiy.setPopulation(result.getInt("city.Population"));
                cities.add(actiy);
            }
            System.out.println("\nCities in the "+continent+" continent sorted by largest to smallest population\n===========================================================================================");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Cities in the world database");
            return null;
        }
    }

    /**
     Function to access all the cities in the region sorted by largest to smallest population
     @return A list of cities in the region sorted by largest to smallest population
     @var region a string variable for selecting a region to display cities
     **/

    public ArrayList<City>getCities_Region()
    {
        try
        {
            // Create an SQL statement
            Statement sql = con.createStatement();

            // Create string for SQL statement
            String region = "'Polynesia'";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on city.CountryCode=country.Code WHERE country.Region="+region+" ORDER BY city.Population DESC;";

            // Execute SQL statement
            ResultSet result = sql.executeQuery(getCityReports);

            // Extract city data
            ArrayList<City> cities = new ArrayList<>();
            while (result.next())
            {
                City actiy = new City();
                actiy.setName(result.getString("city.Name"));
                actiy.setCountry(result.getString("country.Name"));
                actiy.setDistrict(result.getString("city.District"));
                actiy.setPopulation(result.getInt("city.Population"));
                cities.add(actiy);
            }
            System.out.println("\nCities in the "+region+" region sorted by largest to smallest population\n===========================================================================================");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Cities in the world database");
            return null;
        }
    }

    /**
     Function to access all the cities in the district sorted by largest to smallest population
     @return A list of cities in the district sorted by largest to smallest population
     @var district a string variable for selecting district to display cities
     **/
    public ArrayList<City>getCities_District()
    {
        try
        {
            // Create an SQL statement
            Statement sql = con.createStatement();

            // Create string for SQL statement
            String district = "'Gujarat'";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on city.CountryCode=country.Code WHERE city.District="+district+" ORDER BY city.Population DESC;";

            // Execute SQL statement
            ResultSet result = sql.executeQuery(getCityReports);

            // Extract city data
            ArrayList<City> cities = new ArrayList<>();
            while (result.next())
            {
                City actiy = new City();
                actiy.setName(result.getString("city.Name"));
                actiy.setCountry(result.getString("country.Name"));
                actiy.setDistrict(result.getString("city.District"));
                actiy.setPopulation(result.getInt("city.Population"));
                cities.add(actiy);
            }
            System.out.println("\nCities in the "+district+" district sorted by largest to smallest population\n===========================================================================================");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Cities in the world database");
            return null;
        }
    }

    /**
     Function to access all the cities in the country sorted by largest to smallest population.
    @return A list of cities in the country sorted by largest to smallest population
    @var country a string variable for selecting a country to display cities
     **/

    public ArrayList<City>getCities_Country()
    {
        try
        {
            // Create an SQL statement
            Statement sql = con.createStatement();

            // Create string for SQL statement
            String country = "'China'";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on city.CountryCode=country.Code WHERE country.name="+country+" ORDER BY city.Population DESC;";

            // Execute SQL statement
            ResultSet result = sql.executeQuery(getCityReports);

            // Extract city data
            ArrayList<City> cities = new ArrayList<>();
            while (result.next())
            {
                City actiy = new City();
                actiy.setName(result.getString("city.Name"));
                actiy.setCountry(result.getString("country.Name"));
                actiy.setDistrict(result.getString("city.District"));
                actiy.setPopulation(result.getInt("city.Population"));
                cities.add(actiy);
            }
            System.out.println("\nCities in the "+country+" country sorted by largest to smallest population\n===========================================================================================");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Cities in the world database");
            return null;
        }
    }

    /***
    Get a list of top N populated cities in the world.
    @return A list of top N populated cities
    @var limitno an integer for "N" in a list of top N populated cities in the world
     */
    public ArrayList<City> getTopNPopulatedCity_World()
    {
        try
        {
            Statement stmt = con.createStatement();  // Create an SQL statement
            // Create string for SQL statement
            int limitno = 30;       // for N in a list of Top "N" populated cities in the world
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city INNER JOIN country on city.CountryCode=country.Code "
                            + "ORDER BY Population DESC LIMIT " + limitno;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (result.next())
            {
                City actiy = new City();
                actiy.setName(result.getString("city.Name"));
                actiy.setCountry(result.getString("country.Name"));
                actiy.setDistrict(result.getString("city.District"));
                actiy.setPopulation(result.getInt("city.Population"));
                cities.add(actiy);
            }
            System.out.println("\nList of Top " + limitno + " Populated City in the World\n===========================================================================================");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated cities in the world!!");
            return null;
        }
    }

    /**
    Get a list of top N populated cities in the continent.
    @return A list of top N populated cities
    @var limitno an integer for N in a list of top "N" populated cities in the continent
    @var continent an string for continent in a list of top N populated cities in the "continent"
     */
    public ArrayList<City> getTopNPopulatedCity_Continent()
    {
        try
        {
            Statement stmt = con.createStatement();  // Create an SQL statement
            // Create string for SQL statement
            int limitno = 20;       // for N in a list of Top "N" populated cities in the continent
            String continent = "Oceania";        // for continent in a list of Top N populated cities in the "continent"
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city INNER JOIN country on city.CountryCode=country.Code "
                            + "WHERE country.Continent='" + continent
                            + "' ORDER BY Population DESC LIMIT " + limitno;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (result.next())
            {
                City actiy = new City();
                actiy.setName(result.getString("city.Name"));
                actiy.setCountry(result.getString("country.Name"));
                actiy.setDistrict(result.getString("city.District"));
                actiy.setPopulation(result.getInt("city.Population"));
                cities.add(actiy);
            }
            System.out.println("\nList of Top " + limitno + " Populated City in '" + continent +"' Continent\n===========================================================================================");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated cities in a continent!!");
            return null;
        }
    }

    /**
    Get a list of top N populated cities in the region.
    @return A list of top N populated cities
    @var limitno an integer for N in a list of top "N" populated cities in the region
    @var region an string for continent in a list of top N populated cities in the "region"
     */
    public ArrayList<City> getTopNPopulatedCity_Region()
    {
        try
        {
            Statement stmt = con.createStatement();  // Create an SQL statement
            // Create string for SQL statement
            int limitno = 13;       // for N in a list of Top "N" populated cities in the region
            String region= "Southeast Asia";        // for region in a list of Top N populated cities in the "region"
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city INNER JOIN country on city.CountryCode=country.Code "
                            + "WHERE country.Region='" + region
                            + "' ORDER BY Population DESC LIMIT " + limitno;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (result.next())
            {
                City actiy = new City();
                actiy.setName(result.getString("city.Name"));
                actiy.setCountry(result.getString("country.Name"));
                actiy.setDistrict(result.getString("city.District"));
                actiy.setPopulation(result.getInt("city.Population"));

                cities.add(actiy);
            }
            System.out.println("\nList of Top " + limitno + " Populated City in '" + region +"' Region\n===========================================================================================");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated cities in a region!!");
            return null;
        }
    }

    /**
    Get a list of top N populated cities in the country.
    @return A list of top N populated cities
    @var limitno an integer for N in a list of top "N" populated cities in the country
    @var country an string for continent in a list of top N populated cities in the "country"
     */
    public ArrayList<City> getTopNPopulatedCity_Country()
    {
        try
        {
            Statement stmt = con.createStatement();  // Create an SQL statement
            // Create string for SQL statement
            int limitno = 6;       // for N in a list of Top "N" populated cities in the region
            String country= "Denmark";        // for country in a list of Top N populated cities in the "country"
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city INNER JOIN country on city.CountryCode=country.Code "
                            + "WHERE country.Name='" + country
                            + "' ORDER BY Population DESC LIMIT " + limitno;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (result.next())
            {
                City actiy = new City();
                actiy.setName(result.getString("city.Name"));
                actiy.setCountry(result.getString("country.Name"));
                actiy.setDistrict(result.getString("city.District"));
                actiy.setPopulation(result.getInt("city.Population"));
                cities.add(actiy);
            }
            System.out.println("\nList of Top " + limitno + " Populated City in '" + country +"' Country\n===========================================================================================");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated cities in a country!!");
            return null;
        }
    }

    /**
    Get a list of top N populated cities in the district.
    @return A list of top N populated cities
    @var limitno an integer for N in a list of top "N" populated cities in the district
    @var district an string for continent in a list of top N populated cities in the "district"
     */
    public ArrayList<City> getTopNPopulatedCity_District()
    {
        try
        {
            Statement stmt = con.createStatement();  // Create an SQL statement
            // Create string for SQL statement
            int limitno = 10;       // for N in a list of Top "N" populated cities in the district
            String district = "Maharashtra";        // for district in a list of Top N populated cities in the "district"
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city INNER JOIN country on city.CountryCode=country.Code "
                            + "WHERE city.District='" + district
                            + "' ORDER BY Population DESC LIMIT " + limitno;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (result.next())
            {
                City actiy = new City();
                actiy.setName(result.getString("city.Name"));
                actiy.setCountry(result.getString("country.Name"));
                actiy.setDistrict(result.getString("city.District"));
                actiy.setPopulation(result.getInt("city.Population"));
                cities.add(actiy);
            }
            System.out.println("\nList of Top " + limitno + " Populated City in '" + district +"' District\n===========================================================================================");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated cities in a district!!");
            return null;
        }
    }

    /**
     Function to access all the capital cities in the world sorted by largest to smallest population.
     @return A list of capital cities in the world sorted by largest to smallest population
     **/

    public ArrayList<Capital>getCapCities_World()
    {
        try
        {
            // Create an SQL statement
            Statement sql = con.createStatement();

            // Create string for SQL statement

            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on country.capital = city.ID ORDER BY Population DESC;";

            // Execute SQL statement
            ResultSet result = sql.executeQuery(getCityReports);

            // Extract city data
            ArrayList<Capital> cap_cities = new ArrayList<>();
            while (result.next())
            {
                Capital ca = new Capital();
                ca.setName(result.getString("city.Name"));
                ca.setCountry(result.getString("country.Name"));
                ca.setDistrict(result.getString("city.District"));
                ca.setPopulation(result.getInt("city.Population"));
                cap_cities.add(ca);
            }
            System.out.println("\nCapital Cities in the world sorted by largest to smallest population\n===========================================================================================");
            return cap_cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities in the world database");
            return null;
        }
    }

    /**
     Function to access all the capital cities in the continent sorted by largest to smallest population.
     @return A list of capital cities in the continent sorted by largest to smallest population
     @var continent a string variable for selecting a continent to display cities
     **/

    public ArrayList<Capital>getCapCities_Continent()
    {
        try
        {
            // Create an SQL statement
            Statement sql = con.createStatement();

            // Create string for SQL statement
            String continent = "'Oceania'";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on country.capital = city.ID WHERE country.Continent=" + continent +" ORDER BY Population DESC;";

            // Execute SQL statement
            ResultSet result = sql.executeQuery(getCityReports);

            // Extract city data
            ArrayList<Capital> cap_cities = new ArrayList<>();
            while (result.next())
            {
                Capital ca = new Capital();
                ca.setName(result.getString("city.Name"));
                ca.setCountry(result.getString("country.Name"));
                ca.setDistrict(result.getString("city.District"));
                ca.setPopulation(result.getInt("city.Population"));
                cap_cities.add(ca);
            }
            System.out.println("\nCapital Cities in the "+continent+" continent sorted by largest to smallest population\n===========================================================================================");
            return cap_cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities in the world database");
            return null;
        }
    }

    /**
     Function to access all the capital cities in the region sorted by largest to smallest population.
     @return A list of capital cities in the region sorted by largest to smallest population
     @var region a string variable for selecting a continent to display cities
     **/

    public ArrayList<Capital>getCapCities_Region()
    {
        try
        {
            // Create an SQL statement
            Statement sql = con.createStatement();

            // Create string for SQL statement
            String region = "'Caribbean'";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on country.capital = city.ID WHERE country.Region="+region+" ORDER BY Population DESC; ";

            // Execute SQL statement
            ResultSet result = sql.executeQuery(getCityReports);

            // Extract city data
            ArrayList<Capital> cap_cities = new ArrayList<>();
            while (result.next())
            {
                Capital ca = new Capital();
                ca.setName(result.getString("city.Name"));
                ca.setCountry(result.getString("country.Name"));
                ca.setDistrict(result.getString("city.District"));
                ca.setPopulation(result.getInt("city.Population"));
                cap_cities.add(ca);
            }
            System.out.println("\nCapital Cities in the "+region+" region sorted by largest to smallest population\n===========================================================================================");
            return cap_cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities in the world database");
            return null;
        }
    }




    /***
     Get a list of top N populated capital cities in the world.
     @return A list of top N populated capital cities
     @var limitno an integer for "N" in a list of top N populated capital cities in the world
     */
    public ArrayList<Capital> getTopNPopulatedCapCity_World()
    {
        try
        {
            Statement stmt = con.createStatement();  // Create an SQL statement
            // Create string for SQL statement
            int limitno = 30;       // for N in a list of Top "N" populated cities in the world
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on country.capital = city.ID ORDER BY Population DESC LIMIT " + limitno;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
            // Extract city data
            ArrayList<Capital> cap_cities = new ArrayList<>();
            while (result.next())
            {
                Capital ca = new Capital();
                ca.setName(result.getString("city.Name"));
                ca.setCountry(result.getString("country.Name"));
                ca.setDistrict(result.getString("city.District"));
                ca.setPopulation(result.getInt("city.Population"));
                cap_cities.add(ca);
            }
            System.out.println("\nList of Top " + limitno + " Populated Capital City in the World\n===========================================================================================");
            return cap_cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated capital cities in the world!!");
            return null;
        }
    }

    /***
     Get a list of top N populated capital cities in the continent
     @return A list of top N populated capital cities
     @var limitno an integer for "N" in a list of top N populated capital cities in the continent
     @var continent a string variable for selecting continent to display capital cities
     */
    public ArrayList<Capital> getTopNPopulatedCapCity_Continent()
    {
        try
        {
            Statement stmt = con.createStatement();  // Create an SQL statement
            // Create string for SQL statement
            int limitno = 20;       // for N in a list of Top "N" populated cities in the world
            String continent ="'Oceania'";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on country.capital = city.ID WHERE country.Continent="+continent+" ORDER BY Population DESC LIMIT " + limitno;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
            // Extract city data
            ArrayList<Capital> cap_cities = new ArrayList<>();
            while (result.next())
            {
                Capital ca = new Capital();
                ca.setName(result.getString("city.Name"));
                ca.setCountry(result.getString("country.Name"));
                ca.setDistrict(result.getString("city.District"));
                ca.setPopulation(result.getInt("city.Population"));
                cap_cities.add(ca);
            }
            System.out.println("\nList of Top " + limitno + " Populated Capital City in the "+continent+" continent" +"\n===========================================================================================");
            return cap_cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated capital cities in the continent ");
            return null;
        }
    }

    /***
     Get a list of top N populated capital cities in the region
     @return A list of top N populated capital cities
     @var limitno an integer for "N" in a list of top N populated capital cities in the region
     @var region a string variable for selecting continent to display capital cities
     */
    public ArrayList<Capital> getTopNPopulatedCapCity_Region()
    {
        try {
            Statement stmt = con.createStatement();  // Create an SQL statement
            // Create string for SQL statement
            int limitno = 20;       // for N in a list of Top "N" populated cities in the world
            String region = "'Caribbean'";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on country.capital = city.ID WHERE country.Region=" + region + " ORDER BY Population DESC LIMIT " + limitno;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
            // Extract city data
            ArrayList<Capital> cap_cities = new ArrayList<>();
            while (result.next()) {
                Capital ca = new Capital();
                ca.setName(result.getString("city.Name"));
                ca.setCountry(result.getString("country.Name"));
                ca.setDistrict(result.getString("city.District"));
                ca.setPopulation(result.getInt("city.Population"));
                cap_cities.add(ca);
            }
            System.out.println("\nList of Top " + limitno + " Populated Capital City in the " + region + " region" + "\n===========================================================================================");
            return cap_cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated capital cities in the region ");
            return null;
        }
    }

    /***
     Get number of population of people, people living in cities, and people not living in cities in each continent
     @return A list of population of people, people living in cities, and people not living in cities in each continent
     */
    public ArrayList<Population> getPopulation_Continent()
    {
        try
        {
            Statement stmt_1 = con.createStatement();  // Create a first SQL statement
            // Create string for the first SQL statement
            String getPopulationReports_Country = "SELECT Continent, SUM(Population) FROM country "
                    + "GROUP BY Continent HAVING SUM(Population)>0 ORDER BY Continent DESC;";
            // Execute the first SQL statement
            ResultSet result_1 = stmt_1.executeQuery(getPopulationReports_Country);

            Statement stmt_2 = con.createStatement();  // Create a second SQL statement
            // Create string for the second SQL statement
            String getPopulationReports_City = "SELECT country.Continent, SUM(city.Population) FROM city "
                    + "INNER JOIN country ON city.CountryCode=country.Code "
                    + "GROUP BY country.Continent ORDER BY country.Continent DESC;";
            // Execute the second SQL statement
            ResultSet result_2 = stmt_2.executeQuery(getPopulationReports_City);

            // Extract total population information
            ArrayList<Population> populations = new ArrayList<>();
            while (result_1.next() & result_2.next())
            {
                Population pop = new Population();

                pop.setName(result_1.getString("Continent"));
                pop.setTotal_population(result_1.getLong("SUM(Population)"));

                long cityPop = result_2.getLong("SUM(city.Population)");
                Float cityPopPct = (float) ((cityPop * 100.00) / pop.getTotal_population());
                pop.setCity_population(cityPop + "(" + String.format("%.2f%%", cityPopPct) + ")");

                long nonCityPop = pop.getTotal_population() - cityPop;
                Float nonCityPopPct = (float) ((nonCityPop * 100.00) / pop.getTotal_population());
                pop.setNon_city_population(nonCityPop + "(" + String.format("%.2f%%", nonCityPopPct) + ")");

                populations.add(pop);
            }
            System.out.println("\nList of population of people, people living in cities, and people not living in cities in each continent\n=================================================================================================");
            return populations;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of the population of people, people living in cities, and people not living in cities in each continent.!!");
            return null;
        }
    }

    /***
     Get number of population of people, people living in cities, and people not living in cities in each region
     @return A list of population of people, people living in cities, and people not living in cities in each region
     */
    public ArrayList<Population> getPopulation_Region()
    {
        try
        {
            Statement stmt_1 = con.createStatement();  // Create a first SQL statement
            // Create string for the first SQL statement
            String getPopulationReports_Country = "SELECT Region, SUM(Population) FROM country "
                    + "GROUP BY Region HAVING SUM(Population)>0 ORDER BY Region DESC;";
            // Execute the first SQL statement
            ResultSet result_1 = stmt_1.executeQuery(getPopulationReports_Country);

            Statement stmt_2 = con.createStatement();  // Create a second SQL statement
            // Create string for the second SQL statement
            String getPopulationReports_City = "SELECT country.Region, SUM(city.Population) FROM city "
                    + "INNER JOIN country ON city.CountryCode=country.Code "
                    + "GROUP BY country.Region ORDER BY country.Region DESC;";
            // Execute the second SQL statement
            ResultSet result_2 = stmt_2.executeQuery(getPopulationReports_City);

            // Extract total population information
            ArrayList<Population> populations = new ArrayList<>();
            while (result_1.next() & result_2.next())
            {
                Population pop = new Population();

                pop.setName(result_1.getString("Region"));
                pop.setTotal_population(result_1.getLong("SUM(Population)"));

                long cityPop = result_2.getLong("SUM(city.Population)");
                Float cityPopPct = (float) ((cityPop * 100.00) / pop.getTotal_population());
                pop.setCity_population(cityPop + "(" + String.format("%.2f%%", cityPopPct) + ")");

                long nonCityPop = pop.getTotal_population() - cityPop;
                Float nonCityPopPct = (float) ((nonCityPop * 100.00) / pop.getTotal_population());
                pop.setNon_city_population(nonCityPop + "(" + String.format("%.2f%%", nonCityPopPct) + ")");

                populations.add(pop);
            }
            System.out.println("\nList of population of people, people living in cities, and people not living in cities in each region\n=================================================================================================");
            return populations;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of the population of people, people living in cities, and people not living in cities in each region.!!");
            return null;
        }
    }

    /***
     Get number of population of people, people living in cities, and people not living in cities in each country
     @return A list of population of people, people living in cities, and people not living in cities in each country
     */
    public ArrayList<Population> getPopulation_Country()
    {
        try
        {
            Statement stmt_1 = con.createStatement();  // Create a first SQL statement
            // Create string for the first SQL statement
            String getPopulationReports_Country = "SELECT Name, Population FROM country "
                    + "HAVING Population>0 ORDER BY Name ASC;";
            // Execute the first SQL statement
            ResultSet result_1 = stmt_1.executeQuery(getPopulationReports_Country);

            Statement stmt_2 = con.createStatement();  // Create a second SQL statement
            // Create string for the second SQL statement
            String getPopulationReports_City = "SELECT country.Name, SUM(city.Population) FROM city "
                    + "INNER JOIN country ON city.CountryCode=country.Code "
                    + "GROUP BY country.Name ORDER BY country.Name ASC;";
            // Execute the second SQL statement
            ResultSet result_2 = stmt_2.executeQuery(getPopulationReports_City);

            // Extract total population information
            ArrayList<Population> populations = new ArrayList<>();
            while (result_1.next() & result_2.next())
            {
                Population pop = new Population();

                pop.setName(result_1.getString("Name"));
                pop.setTotal_population(result_1.getLong("Population"));

                long cityPop = result_2.getLong("SUM(city.Population)");
                Float cityPopPct = (float) ((cityPop * 100.00) / pop.getTotal_population());
                pop.setCity_population(cityPop + "(" + String.format("%.2f%%", cityPopPct) + ")");

                long nonCityPop = pop.getTotal_population() - cityPop;
                Float nonCityPopPct = (float) ((nonCityPop * 100.00) / pop.getTotal_population());
                pop.setNon_city_population(nonCityPop + "(" + String.format("%.2f%%", nonCityPopPct) + ")");

                populations.add(pop);
            }
            System.out.println("\nList of population of people, people living in cities, and people not living in cities in each country\n=================================================================================================");
            return populations;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of the population of people, people living in cities, and people not living in cities in each country.!!");
            return null;
        }
    }

    /**
     * Prints a list of Countries.
     * @param countries The list of Countries to print.
     */

    public void printCountriesReport(ArrayList<Country> countries)
    {
        // Check Countries is not null
        if (countries == null)
        {
            System.out.println("No Countries");
            return;
        }
        // Print header
        System.out.printf("%-5s %-15s %-20s %-20s %-20s %-20s%n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        System.out.println("===========================================================================================");

        // Check Country is not empty
        if (countries.isEmpty() == false)
        {
            // Loop over all countries in the list
            for (Country coun : countries)
            {
                // Check Country contain null
                if (coun == null)
                    continue;
                String emp_string =
                        String.format("%-5s %-15s %-20s %-20s %-20s %-20s",
                                coun.getCode(), coun.getName(), coun.getContinent(), coun.getRegion(), coun.getPopulation(), coun.getCapital());
                System.out.println(emp_string);
            }
        }
        else
        {
            String emp_string = String.format("Country Report List is empty");
            System.out.println(emp_string);
        }
    }

    /**
     * Prints a list of cities.
     * @param cities The list of cities to print.
     */

    public void printCityReport(ArrayList<City> cities)
    {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-25s %-25s %-25s %-25s%n", "City Name", "Country Name", "District", "Population");
        System.out.println("===========================================================================================");

        // Check City is not empty
        if (cities.isEmpty() == false)
        {
            // Loop over all cities in the list
            for (City city : cities) {
                // Check City contain null
                if (city == null)
                    continue;
                String city_string =
                        String.format("%-25s %-25s %-25s %-25s",
                                city.getName(), city.getCountry(), city.getDistrict(), city.getPopulation());
                System.out.println(city_string);
            }
        }
        else
        {
            String city_string = String.format("City Report List is empty");
            System.out.println(city_string);
        }
    }

    /** Function to Print Capital City
     * @param cap_cities to print list of capital cities **/
    public void printCapCityReport(ArrayList<Capital> cap_cities)
    {
        // Check capital cities is not null
        if (cap_cities == null)
        {
            System.out.println("No capital cities");
            return;
        }
        // Print header
        System.out.printf("%-25s %-25s %-25s %-25s%n", "City Name", "Country Name", "District", "Population");
        System.out.println("===========================================================================================");

        // Check Capital City is not empty
        if (cap_cities.isEmpty() == false)
        {
            // Loop over all capital cities in the list
            for (Capital city : cap_cities) {
                // Check Capital City contain null
                if (city == null)
                    continue;
                String city_string =
                        String.format("%-25s %-25s %-25s %-25s",
                                city.getName(), city.getCountry(), city.getDistrict(), city.getPopulation());
                System.out.println(city_string);
            }
        }
        else
        {
            String city_string = String.format("Capital City Report List is empty");
            System.out.println(city_string);
        }
    }

    /** Function to Print populations
     * @param populations to print list of populations **/
    public void printPopulationReport(ArrayList<Population> populations)
    {
        // Check populations is not null
        if (populations == null)
        {
            System.out.println("No populations");
            return;
        }

        // Print header
        System.out.printf("%-25s %-25s %-25s %-25s%n", "Place", "Total Population", "City Population", "Non-City Population");
        System.out.println("=================================================================================================");

        // Check populations is not empty
        if (populations.isEmpty() == false)
        {
            // Loop over all cities in the list
            for (Population population : populations) {
                // Check population contain null
                if (population == null)
                    continue;
                String population_string =
                        String.format("%-25s %-25s %-25s %-25s",
                                population.getName(), population.getTotal_population(), population.getCity_population(), population.getNon_city_population());

                System.out.println(population_string);
            }
        }
        else
        {
            String population_string = String.format("Population Report List is empty");
            System.out.println(population_string);
        }
    }

    /***
     Get the population of the world and print it
     */
    public String getnPrintPopulation_Wrold()
    {
        String popu = "";
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) FROM country;";
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(strSelect);
            // Extract population
            Population pop = new Population();
            while (result.next())
            {
                pop.setTotal_population(result.getLong("SUM(Population)"));
            }

            System.out.println("There are " + pop.getTotal_population() + " people in the world.");
            popu = String.format("There are " + pop.getTotal_population() + " people in the world.");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population data");
        }
        return popu;
    }

    /***
     Get the population of the continent and print it
     */
    public String getnPrintPopulation_Continent(String continent)
    {
        String popu = "";
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) FROM country WHERE Continent='"+continent+"'";
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(strSelect);
            // Extract population
            Population pop = new Population();
            while (result.next())
            {
                pop.setTotal_population(result.getLong("SUM(Population)"));
            }

            System.out.println("There are " + pop.getTotal_population() + " people in the '" + continent + "' continent.");
            popu = String.format("There are " + pop.getTotal_population() + " people in the '" + continent + "' continent.");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population data");
        }
        return popu;
    }

    /***
     Get the population of the region and print it
     */
    public String getnPrintPopulation_Region(String region) {
        String popu = "";
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) FROM country WHERE Region='" + region + "'";
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(strSelect);
            // Extract population
            Population pop = new Population();
            while (result.next()) {
                pop.setTotal_population(result.getLong("SUM(Population)"));
            }

            System.out.println("There are " + pop.getTotal_population() + " people in the '" + region + "' region.");
            popu = String.format("There are " + pop.getTotal_population() + " people in the '" + region + "' region.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population data");
        }
        return popu;
    }

    /***
     Get the population of the country and print it
     */
    public String getnPrintPopulation_Country(String country)
    {
        String popu = "";
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) FROM country WHERE Name='"+country+"'";
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(strSelect);
            // Extract population
            Population pop = new Population();
            while (result.next())
            {
                pop.setTotal_population(result.getLong("SUM(Population)"));
            }

            System.out.println("There are " + pop.getTotal_population() + " people in the '" + country + "' country.");
            popu = String.format("There are " + pop.getTotal_population() + " people in the '" + country + "' country.");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population data");
        }
        return popu;
    }

    /***
     Get the population of the district and print it
     */
    public String getnPrintPopulation_District(String district)
    {
        String popu = "";
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) FROM city WHERE District='"+district+"'";
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(strSelect);
            // Extract population
            Population pop = new Population();
            while (result.next())
            {
                pop.setTotal_population(result.getLong("SUM(Population)"));
            }

            System.out.println("There are " + pop.getTotal_population() + " people in the '" + district + "' district.");
            popu = String.format("There are " + pop.getTotal_population() + " people in the '" + district + "' district.");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population data");
        }
        return popu;
    }

    /***
     Get the population of the city and print it
     */
    public String getnPrintPopulation_City(String city)
    {
        String popu = "";
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT Population FROM city WHERE Name='"+city+"'";

            // Execute SQL statement
            ResultSet result = stmt.executeQuery(strSelect);
            // Extract population
            Population pop = new Population();
            while (result.next())
            {
                pop.setTotal_population(result.getLong("Population"));
            }

            System.out.println("There are " + pop.getTotal_population() + " people in the '" + city + "' city.");
            popu = String.format("There are " + pop.getTotal_population() + " people in the '" + city + "' city.");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population data");
        }
        return popu;
    }

    /**
     * Get and print how much people in the world speak chinese with percentage*/
    public String peopleSpeakChinese(){
        String lang = "";
        try
        {
            Statement stmt_1 = con.createStatement();  // Create a first SQL statement
            // Create string for the first SQL statement
            String getPeopleSpeakChinese = "select Sum((country.Population)*((countrylanguage.percentage)/100)) from country INNER JOIN countrylanguage on countrylanguage.CountryCode = country.Code WHERE countrylanguage.Language='Chinese';";
            // Execute the first SQL statement
            ResultSet result_1 = stmt_1.executeQuery(getPeopleSpeakChinese);

            Statement stmt_2 = con.createStatement();  // Create a second SQL statement
            // Create string for the second SQL statement
            String getWorldPopulation = "select Sum(Population) from country;";
            // Execute the second SQL statement
            ResultSet result_2 = stmt_2.executeQuery(getWorldPopulation);

            long chinese = 0;
            float population = 0;
            float percent = 0;

            while (result_1.next() & result_2.next()) {
                // Calculate percentage of people who speak chinese in the world
                chinese = result_1.getLong("Sum((country.Population)*((countrylanguage.percentage)/100))");
                population = result_2.getLong("Sum(Population)");
                percent = ((float)chinese / population) * (float)(100.00);
            }

            System.out.println("\nNumber of people who speak Chinese in the world: "+chinese+" \nwhich is "+String.format("%.2f%%", percent) +" of the world population");
            System.out.println("=================================================================================================\n");
            lang = String.format("Number of people who speak Chinese in the world: "+chinese+" \nwhich is "+String.format("%.2f%%", percent) +" of the world population");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population of chinese speakers");
        }
        return lang;
    }

    /**
     * Get and print how much people in the world speak english with percentage*/
    public String peopleSpeakEnglish(){
        String lang = "";
        try
        {
            Statement stmt_1 = con.createStatement();  // Create a first SQL statement
            // Create string for the first SQL statement
            String getPeopleSpeakEnglish = "select Sum((country.Population)*((countrylanguage.percentage)/100)) from country INNER JOIN countrylanguage on countrylanguage.CountryCode = country.Code WHERE countrylanguage.Language='English';";
            // Execute the first SQL statement
            ResultSet result_1 = stmt_1.executeQuery(getPeopleSpeakEnglish);

            Statement stmt_2 = con.createStatement();  // Create a second SQL statement
            // Create string for the second SQL statement
            String getWorldPopulation = "select Sum(Population) from country;";
            // Execute the second SQL statement
            ResultSet result_2 = stmt_2.executeQuery(getWorldPopulation);

            long english = 0;
            float population = 0;
            float percent = 0;

            while (result_1.next() & result_2.next()) {
                // Calculate percentage of people who speak chinese in the world
                english = result_1.getLong("Sum((country.Population)*((countrylanguage.percentage)/100))");
                population = result_2.getLong("Sum(Population)");
                percent = ((float)english / population) * (float)(100.00);
            }

            System.out.println("\nNumber of people who speak English in the world: "+english+" \nwhich is "+String.format("%.2f%%", percent) +" of the world population");
            System.out.println("=================================================================================================\n");
            lang = String.format("Number of people who speak English in the world: "+english+" \nwhich is "+String.format("%.2f%%", percent) +" of the world population");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population of English speakers");
        }
        return lang;
    }

    /**
     * Get and print how much people in the world speak hindi with percentage*/
    public String peopleSpeakHindi(){
        String lang = "";
        try
        {
            Statement stmt_1 = con.createStatement();  // Create a first SQL statement
            // Create string for the first SQL statement
            String getPeopleSpeakHindi = "select Sum((country.Population)*((countrylanguage.percentage)/100)) from country INNER JOIN countrylanguage on countrylanguage.CountryCode = country.Code WHERE countrylanguage.Language='Hindi';";
            // Execute the first SQL statement
            ResultSet result_1 = stmt_1.executeQuery(getPeopleSpeakHindi);

            Statement stmt_2 = con.createStatement();  // Create a second SQL statement
            // Create string for the second SQL statement
            String getWorldPopulation = "select Sum(Population) from country;";
            // Execute the second SQL statement
            ResultSet result_2 = stmt_2.executeQuery(getWorldPopulation);

            long hindi = 0;
            float population = 0;
            float percent = 0;

            while (result_1.next() & result_2.next()) {
                // Calculate percentage of people who speak chinese in the world
                hindi = result_1.getLong("Sum((country.Population)*((countrylanguage.percentage)/100))");
                population = result_2.getLong("Sum(Population)");
                percent = ((float)hindi / population) * (float)(100.00);
            }

            System.out.println("\nNumber of people who speak Hindi in the world: "+hindi+" \nwhich is "+String.format("%.2f%%", percent) +" of the world population");
            System.out.println("=================================================================================================\n");
            lang = String.format("Number of people who speak Hindi in the world: "+hindi+" \nwhich is "+String.format("%.2f%%", percent) +" of the world population");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population of Hindi speakers");
        }
        return lang;
    }

    /**
     * Get and print how much people in the world speak spanish with percentage*/
    public String peopleSpeakSpanish(){
        String lang = "";
        try
        {
            Statement stmt_1 = con.createStatement();  // Create a first SQL statement
            // Create string for the first SQL statement
            String getPeopleSpeakSpanish = "select Sum((country.Population)*((countrylanguage.percentage)/100)) from country INNER JOIN countrylanguage on countrylanguage.CountryCode = country.Code WHERE countrylanguage.Language='Spanish';";
            // Execute the first SQL statement
            ResultSet result_1 = stmt_1.executeQuery(getPeopleSpeakSpanish);

            Statement stmt_2 = con.createStatement();  // Create a second SQL statement
            // Create string for the second SQL statement
            String getWorldPopulation = "select Sum(Population) from country;";
            // Execute the second SQL statement
            ResultSet result_2 = stmt_2.executeQuery(getWorldPopulation);

            long spanish = 0;
            float population = 0;
            float percent = 0;

            while (result_1.next() & result_2.next()) {
                // Calculate percentage of people who speak chinese in the world
                spanish = result_1.getLong("Sum((country.Population)*((countrylanguage.percentage)/100))");
                population = result_2.getLong("Sum(Population)");
                percent = ((float)spanish / population) * (float)(100.00);
            }

            System.out.println("\nNumber of people who speak Hindi in the world: "+spanish+" \nwhich is "+String.format("%.2f%%", percent) +" of the world population");
            System.out.println("=================================================================================================\n");
            lang = String.format("Number of people who speak Hindi in the world: "+spanish+" \nwhich is "+String.format("%.2f%%", percent) +" of the world population");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population of spanish speakers");
        }
        return lang;
    }

    /**
     * Get and print how much people in the world speak Arabic with percentage*/
    public String peopleSpeakArabic(){
        String lang = "";
        try
        {
            Statement stmt_1 = con.createStatement();  // Create a first SQL statement
            // Create string for the first SQL statement
            String getPeopleSpeakArabic = "select Sum((country.Population)*((countrylanguage.percentage)/100)) from country INNER JOIN countrylanguage on countrylanguage.CountryCode = country.Code WHERE countrylanguage.Language='Arabic';";
            // Execute the first SQL statement
            ResultSet result_1 = stmt_1.executeQuery(getPeopleSpeakArabic);

            Statement stmt_2 = con.createStatement();  // Create a second SQL statement
            // Create string for the second SQL statement
            String getWorldPopulation = "select Sum(Population) from country;";
            // Execute the second SQL statement
            ResultSet result_2 = stmt_2.executeQuery(getWorldPopulation);

            long arabic = 0;
            float population = 0;
            float percent = 0;

            while (result_1.next() & result_2.next()) {
                // Calculate percentage of people who speak chinese in the world
                arabic = result_1.getLong("Sum((country.Population)*((countrylanguage.percentage)/100))");
                population = result_2.getLong("Sum(Population)");
                percent = ((float)arabic / population) * (float)(100.00);
            }

            System.out.println("\nNumber of people who speak Arabic in the world: "+arabic+" \nwhich is "+String.format("%.2f%%", percent) +" of the world population");
            System.out.println("=================================================================================================\n");
            lang = String.format("Number of people who speak Arabic in the world: "+arabic+" \nwhich is "+String.format("%.2f%%", percent) +" of the world population");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population of arabic speakers");
        }
        return lang;
    }

    /**
     * Prints a list of Countries into markdown file.
     * @param countries The list of Countries to print into markdown file.
     */
    public void outputCountriesReport(ArrayList<Country> countries, String filename) {
        // Check Countries is not null
        if (countries == null) {
            System.out.println("countries");
            return;
        }

        StringBuilder sb = new StringBuilder();
        // Print header
        sb.append("| Code | Name | Continent | Region | Population | Capital |\r\n");
        sb.append("| --- | --- | --- | --- | --- | --- |\r\n");

        // Check Country is not empty
        if (countries.isEmpty() == false)
        {
            // Loop over countries in the list
            for (Country coun : countries) {
                // Check Country contain null
                if (coun == null) continue;
                sb.append("| " + coun.getCode() + " | " +
                        coun.getName() + " | " + coun.getContinent() + " | " +
                        coun.getRegion() + " | " + coun.getPopulation() + " | "
                        + coun.getCapital() + " |\r\n");
            }
            try {
                new File("./reports/").mkdir();
                BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename)));
                writer.write(sb.toString());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            String emp_string = String.format("Country Report List is empty");
            System.out.println(emp_string);
        }

    }

    /**
     * Prints a list of cities into markdown file.
     * @param cities The list of cities to print into markdown file.
     */
    public void outputCityReport(ArrayList<City> cities, String filename) {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }

        StringBuilder sb = new StringBuilder();
        // Print header
        sb.append("| City Name | Country Name | District | Population |\r\n");
        sb.append("| --- | --- | --- | --- |\r\n");

        // Check City is not empty
        if (cities.isEmpty() == false)
        {
            // Loop over cities in the list
            for (City city : cities) {
                // Check Country contain null
                if (city == null) continue;
                sb.append("| " + city.getName() + " | " +
                        city.getCountry() + " | " + city.getDistrict() + " | " +
                        city.getPopulation() +" |\r\n");
            }
            try {
                new File("./reports/").mkdir();
                BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename)));
                writer.write(sb.toString());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            String city_string = String.format("City Report List is empty");
            System.out.println(city_string);
        }

    }

    /**
     * Prints a list of Capital City into markdown file.
     * @param cap_cities to print list of capital cities into markdown file.
     */
    public void outputCapCityReport(ArrayList<Capital> cap_cities, String filename) {
        // Check capital cities is not null
        if (cap_cities == null)
        {
            System.out.println("No capital cities");
            return;
        }

        StringBuilder sb = new StringBuilder();
        // Print header
        sb.append("| City Name | Country Name | District | Population |\r\n");
        sb.append("| --- | --- | --- | --- |\r\n");

        // Check Capital City is not empty
        if (cap_cities.isEmpty() == false)
        {
            // Loop over all capital cities in the list
            for (Capital city : cap_cities) {
                // Check Capital City contain null
                if (city == null)
                    continue;
                sb.append("| " + city.getName() + " | " +
                        city.getCountry() + " | " + city.getDistrict() + " | " +
                        city.getPopulation() +" |\r\n");
            }
            try {
                new File("./reports/").mkdir();
                BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename)));
                writer.write(sb.toString());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            String city_string = String.format("Capital City Report List is empty");
            System.out.println(city_string);
        }

    }

    /**
     * Prints a list of populations into markdown file.
     * @param populations to print list of populations into markdown file.
     */
    public void outputPopulationReport(ArrayList<Population> populations, String filename) {
        // Check populations is not null
        if (populations == null)
        {
            System.out.println("No populations");
            return;
        }

        StringBuilder sb = new StringBuilder();
        // Print header
        sb.append("| Place | Total Population | City Population | Non-City Population |\r\n");
        sb.append("| --- | --- | --- | --- |\r\n");

        // Check populations is not empty
        if (populations.isEmpty() == false)
        {
            // Loop over all cities in the list
            for (Population population : populations) {
                // Check population contain null
                if (population == null)
                    continue;
                sb.append("| " + population.getName() + " | " +
                        population.getTotal_population() + " | " + population.getCity_population() + " | " +
                        population.getNon_city_population() +" |\r\n");
            }
            try {
                new File("./reports/").mkdir();
                BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename)));
                writer.write(sb.toString());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            String population_string = String.format("Population Report List is empty");
            System.out.println(population_string);
        }

    }

    /**
     * Prints a totalpopulation into markdown file.
     */
    public void outputtotalpopulationReport(String world, String continent, String region, String country, String district, String city, String filename) {

        StringBuilder sb = new StringBuilder();
        // Print header
        sb.append("| Total Population Report |\r\n");
        sb.append("| --- |\r\n");
        sb.append("| " + world + " |\r\n");
        sb.append("| " + continent + " |\r\n");
        sb.append("| " + region + " |\r\n");
        sb.append("| " + country + " |\r\n");
        sb.append("| " + district + " |\r\n");
        sb.append("| " + city + " |\r\n");

        try
        {
            new File("./reports/").mkdir();
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename)));
            writer.write(sb.toString());
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Prints a totalpopulation into markdown file.
     */
    public void outputlanguagespeakerReport(String lang_chinese, String lang_english, String lang_hindi, String lang_spanish, String lang_arabic, String filename) {

        StringBuilder sb = new StringBuilder();
        // Print header
        sb.append("| Languages Speaker Report |\r\n");
        sb.append("| --- |\r\n");
        sb.append("| " + lang_chinese + " |\r\n");
        sb.append("| " + lang_english + " |\r\n");
        sb.append("| " + lang_hindi + " |\r\n");
        sb.append("| " + lang_spanish + " |\r\n");
        sb.append("| " + lang_arabic + " |\r\n");

        try
        {
            new File("./reports/").mkdir();
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename)));
            writer.write(sb.toString());
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    // main
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();
        // Connect to database

        if(args.length < 1){
            a.connect("localhost:33060", 30000);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        // Get Countries in the world from largest population to smallest
        ArrayList<Country> countries = a.getCountries_World();
        // Print Countries in the world from largest population to smallest
        a.printCountriesReport(countries);
        // Print Countries in the world from largest population to smallest into markdown file
        a.outputCountriesReport(countries, "Countries_data_of_the_world.md");

        // Get Countries in the continent from largest population to smallest
        countries = a.getCountries_Continent();
        // Print Countries in the continent from largest population to smallest
        a.printCountriesReport(countries);
        // Print Countries in the continent from largest population to smallest into markdown file
        a.outputCountriesReport(countries, "Countries_data_of_the_continent.md");

        // Get Countries in the region from largest population to smallest
        countries = a.getCountries_Region();
        // Print Countries in the region from largest population to smallest
        a.printCountriesReport(countries);
        // Print Countries in the region from largest population to smallest into markdown file
        a.outputCountriesReport(countries, "Countries_data_of_the_region.md");

        // Get Top populated Country in the World
        countries = a.getTopNPopulatedCountries_World();
        // Print Top populated Country in the World
        a.printCountriesReport(countries);
        // Print Top populated Country in the World into markdown file
        a.outputCountriesReport(countries, "Top_Countries_data_of_the_world.md");

        // Get Top populated Country in the continent
        countries = a.getTopNPopulatedCountries_Continent();
        // Print Top populated Country in the continent
        a.printCountriesReport(countries);
        // Print Top populated Country in the continent into markdown file
        a.outputCountriesReport(countries, "Top_Countries_data_of_the_continent.md");

        // Get Top populated Country in the region
        countries = a.getTopNPopulatedCountries_Region();
        // Print Top populated Country in the region
        a.printCountriesReport(countries);
        // Print Top populated Country in the region into markdown file
        a.outputCountriesReport(countries, "Top_Countries_data_of_the_region.md");

        // get city data of the world
        ArrayList<City> cities = a.getCities_World();
        // print city data
        a.printCityReport(cities);
        // print city data into markdown file
        a.outputCityReport(cities, "Cities_data_of_the_world.md");

        // get city data of the continent
        cities = a.getCities_Continent();
        // print city data
        a.printCityReport(cities);
        // print city data into markdown file
        a.outputCityReport(cities, "Cities_data_of_the_continent.md");

        // get city data of the region
        cities = a.getCities_Region();
        // print city data
        a.printCityReport(cities);
        // print city data into markdown file
        a.outputCityReport(cities, "Cities_data_of_the_region.md");

        // get city data of the district
        cities = a.getCities_District();
        // print city data
        a.printCityReport(cities);
        // print city data into markdown file
        a.outputCityReport(cities, "Cities_data_of_the_district.md");

        // get city data of the country
        cities = a.getCities_Country();
        // print city data
        a.printCityReport(cities);
        // print city data into markdown file
        a.outputCityReport(cities, "Cities_data_of_the_country.md");

        // Extract information of top N populated cities in the world
        cities = a.getTopNPopulatedCity_World();
        // print city data
        a.printCityReport(cities);
        // print city data into markdown file
        a.outputCityReport(cities, "Top_Cities_data_of_the_world.md");

        // Extract information of top N populated cities in a continent
        cities = a.getTopNPopulatedCity_Continent();
        // print city data
        a.printCityReport(cities);
        // print city data into markdown file
        a.outputCityReport(cities, "Top_Cities_data_of_the_continent.md");

        // Extract information of top N populated cities in a region
        cities = a.getTopNPopulatedCity_Region();
        // print city data
        a.printCityReport(cities);
        // print city data into markdown file
        a.outputCityReport(cities, "Top_Cities_data_of_the_region.md");

        // Extract information of top N populated cities in a country
        cities = a.getTopNPopulatedCity_Country();
        // print city data
        a.printCityReport(cities);
        // print city data into markdown file
        a.outputCityReport(cities, "Top_Cities_data_of_the_country.md");

        // Extract information of top N populated cities in a district
        cities = a.getTopNPopulatedCity_District();
        // print city data
        a.printCityReport(cities);
        // print city data into markdown file
        a.outputCityReport(cities, "Top_Cities_data_of_the_district.md");

        // get capital city data of the world
        ArrayList<Capital> cap_cities = a.getCapCities_World();
        // print city data
        a.printCapCityReport(cap_cities);
        // print city data into markdown file
        a.outputCapCityReport(cap_cities, "CapCities_data_of_the_world.md");

        // get capital city data of the continent
        cap_cities = a.getCapCities_Continent();
        // print city data
        a.printCapCityReport(cap_cities);
        // print city data into markdown file
        a.outputCapCityReport(cap_cities, "CapCities_data_of_the_continent.md");

        // get capital city data of the region
        cap_cities = a.getCapCities_Region();
        // print city data
        a.printCapCityReport(cap_cities);
        // print city data into markdown file
        a.outputCapCityReport(cap_cities, "CapCities_data_of_the_region.md");

        // get data of top N populated capital cities in the world
        cap_cities = a.getTopNPopulatedCapCity_World();
        // print city data
        a.printCapCityReport(cap_cities);
        // print city data into markdown file
        a.outputCapCityReport(cap_cities, "Top_CapCities_data_of_the_world.md");

        // get data of top N populated capital cities in the continent
        cap_cities = a.getTopNPopulatedCapCity_Continent();
        // print city data
        a.printCapCityReport(cap_cities);
        // print city data into markdown file
        a.outputCapCityReport(cap_cities, "Top_CapCities_data_of_the_continent.md");

        // get data of top N populated capital cities in the continent
        cap_cities = a.getTopNPopulatedCapCity_Region();
        // print city data
        a.printCapCityReport(cap_cities);
        // print city data into markdown file
        a.outputCapCityReport(cap_cities, "Top_CapCities_data_of_the_Region.md");

        // Extract information of number of population of people, people living in cities, and people not living in cities in each continent
        ArrayList<Population> populations = a.getPopulation_Continent();
        // print population data
        a.printPopulationReport(populations);
        // print population data into markdown file
        a.outputPopulationReport(populations, "Population_data_of_the_continent.md");

        // Extract information of number of population of people, people living in cities, and people not living in cities in each region
        populations = a.getPopulation_Region();
        // print population data
        a.printPopulationReport(populations);
        // print population data into markdown file
        a.outputPopulationReport(populations, "Population_data_of_the_region.md");

        // Extract information of number of population of people, people living in cities, and people not living in cities in each country
        populations = a.getPopulation_Country();
        // print population data
        a.printPopulationReport(populations);
        // print population data into markdown file
        a.outputPopulationReport(populations, "Population_data_of_the_country.md");

        // Extract total population in the world
        a.getnPrintPopulation_Wrold();
        // get output from extracting total population in the world to put into markdown file
        String world =  a.getnPrintPopulation_Wrold();

        // Extract total population in the continent
        a.getnPrintPopulation_Continent("Asia");
        // get output from extracting total population in the continent to put into markdown file
        String continent =  a.getnPrintPopulation_Continent("Asia");

        // Extract total population in the region
        a.getnPrintPopulation_Region("Caribbean");
        // get output from extracting total population in the region to put into markdown file
        String region =  a.getnPrintPopulation_Region("Caribbean");

        // Extract total population in the country
        a.getnPrintPopulation_Country("Denmark");
        // get output from extracting total population in the country to put into markdown file
        String country =  a.getnPrintPopulation_Country("Denmark");

        // Extract total population in the district
        a.getnPrintPopulation_District("Gujarat");
        // get output from extracting total population in the district to put into markdown file
        String district =  a.getnPrintPopulation_District("Gujarat");

        // Extract total population in the city
        a.getnPrintPopulation_City("Seoul");
        // get output from extracting total population in the city to put into markdown file
        String city =  a.getnPrintPopulation_City("Seoul");

        // print total population data into markdown file
        a.outputtotalpopulationReport(world,continent,region,country,district,city, "total_population.md");

        //get and print population of chinese speakers in the world with percentage
        a.peopleSpeakChinese();
        // get and print population of chinese speakers in the world with percentage into markdown file
        String lang_chinese = a.peopleSpeakChinese();

        //get and print population of english speakers in the world with percentage
        a.peopleSpeakEnglish();
        // get and print population of english speakers in the world with percentage into markdown file
        String lang_english = a.peopleSpeakEnglish();

        //get and print population of Hindi speakers in the world with percentage
        a.peopleSpeakHindi();
        // get and print population of hindi speakers in the world with percentage into markdown file
        String lang_hindi = a.peopleSpeakHindi();

        //get and print population of spanish speakers in the world with percentage
        a.peopleSpeakSpanish();
        // get and print population of spanish speakers in the world with percentage into markdown file
        String lang_spanish = a.peopleSpeakSpanish();

        //get and print population of arabic speakers in the world with percentage
        a.peopleSpeakArabic();
        // get and print population of arabic speakers in the world with percentage into markdown file
        String lang_arabic = a.peopleSpeakArabic();

        // print language speaker data into markdown file
        a.outputlanguagespeakerReport(lang_chinese,lang_english,lang_hindi,lang_spanish,lang_arabic, "language_speaker.md");

        // Disconnect from database
        a.disconnect();
    }
}