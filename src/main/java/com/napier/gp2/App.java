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
            ArrayList<Capital> cap_cities = new ArrayList<Capital>();
            while (result.next())
            {
                Capital ca = new Capital();
                ca.setName(result.getString("city.Name"));
                ca.getName();
                ca.setCountry(result.getString("country.Name"));
                ca.getCountry();
                ca.setDistrict(result.getString("city.District"));
                ca.getDistrict();
                ca.setPopulation(result.getInt("city.Population"));
                ca.getPopulation();
                cap_cities.add(ca);
            }
            System.out.println("\nCapital Cities in the world continent sorted by largest to smallest population\n===========================================================================================");
            return cap_cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities in the world database");
            return null;
        }
    }
/** Function to Print Capital City
 * @param cap_cities to print list of capital cities **/
    public void printCapCityReport(ArrayList<Capital> cap_cities) {

        // Print header
        System.out.println(String.format("%-25s %-25s %-25s %-25s", "City Name", "Country Name", "District", "Population"));
        System.out.println("===========================================================================================");

        // Loop over all capital cities in the list
        for (Capital city : cap_cities) {
            String city_string =
                    String.format("%-25s %-25s %-25s %-25s",
                            city.getName(), city.getCountry(), city.getDistrict(), city.getPopulation());
            System.out.println(city_string);
        }
    }


    public static void main(String[] args)
    {

        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // get capital city data of the world
        ArrayList<Capital> cap_cities = a.getCapCities_World();
        // print city data
        a.printCapCityReport(cap_cities);

        // Disconnect from database
        a.disconnect();
    }
}