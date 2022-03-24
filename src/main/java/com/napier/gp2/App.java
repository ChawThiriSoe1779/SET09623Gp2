package com.napier.gp2;

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
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
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
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "group2");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
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
     * Function to access all the cities in the world sorted by largest to smallest population.
     */
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
            ArrayList<City> cities = new ArrayList<City>();
            while (result.next())
            {
                City city = new City();
                city.name = result.getString("city.Name");
                city.country = result.getString("country.Name");
                city.district = result.getString("city.District");
                city.population = result.getInt("city.Population");
                cities.add(city);
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
     * Function to access all the cities in the continent sorted by largest to smallest population.
     */
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
            ArrayList<City> cities = new ArrayList<City>();
            while (result.next())
            {
                City city = new City();
                city.name = result.getString("city.Name");
                city.country = result.getString("country.Name");
                city.district = result.getString("city.District");
                city.population = result.getInt("city.Population");
                cities.add(city);
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
     * Function to access all the cities in the region sorted by largest to smallest population.
     */
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
            ArrayList<City> cities = new ArrayList<City>();
            while (result.next())
            {
                City city = new City();
                city.name = result.getString("city.Name");
                city.country = result.getString("country.Name");
                city.district = result.getString("city.District");
                city.population = result.getInt("city.Population");
                cities.add(city);
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
     * Function to access all the cities in the district sorted by largest to smallest population.
     */
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
            ArrayList<City> cities = new ArrayList<City>();
            while (result.next())
            {
                City city = new City();
                city.name = result.getString("city.Name");
                city.country = result.getString("country.Name");
                city.district = result.getString("city.District");
                city.population = result.getInt("city.Population");
                cities.add(city);
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
     * Function to access all the cities in the country sorted by largest to smallest population.
     */
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
            ArrayList<City> cities = new ArrayList<City>();
            while (result.next())
            {
                City city = new City();
                city.name = result.getString("city.Name");
                city.country = result.getString("country.Name");
                city.district = result.getString("city.District");
                city.population = result.getInt("city.Population");
                cities.add(city);
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

    /**
     * Prints a list of cities.
     * @param cities The list of cities to print.
     */

    public void printCityReport(ArrayList<City> cities) {
        // Print header
        System.out.println(String.format("%-25s %-25s %-25s %-25s", "City Name", "Country Name", "District", "Population"));
        System.out.println("===========================================================================================");
        // Loop over all cities in the list
        for (City city : cities) {
            String city_string =
                    String.format("%-25s %-25s %-25s %-25s",
                            city.name, city.country, city.district, city.population);
            System.out.println(city_string);
        }
    }

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // get city data of the world
//      ArrayList<City> cities = a.getCities_World();

        // get city data of the continent
//      ArrayList<City> cities = a.getCities_Continent();

        // get city data of the region
//      ArrayList<City> cities = a.getCities_Region();

        // get city data of the district
//      ArrayList<City> cities = a.getCities_District();

        // get city data of the country
        ArrayList<City> cities = a.getCities_Country();

        // print city data
        a.printCityReport(cities);

        // Disconnect from database
        a.disconnect();
    }
}