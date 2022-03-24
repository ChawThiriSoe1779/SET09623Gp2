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
            System.out.println("\nCitites in the world sorted by largest to smallest population\n===========================================================================================");
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
     * Prints a list of employees.
     * @param cities The list of employees to print.
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

        ArrayList<City> cities = a.getCities_World();
        a.printCityReport(cities);

        // Disconnect from database
        a.disconnect();
    }

}