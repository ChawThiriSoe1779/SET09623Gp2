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
            System.out.println("Connecting to database...");
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
    // Funtion to get countries in the world from largest population to smallest report data
    public ArrayList<Country> getCountries_World()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Continent, Region, Population, Capital FROM country ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.Name = rset.getString("Name");
                coun.Continent = rset.getString("Continent");
                coun.Region = rset.getString("Region");
                coun.Population = rset.getInt("Population");
                coun.Capital = rset.getString("Capital");
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
// Funtion to print countries in the world from largest population to smallest report
    public void printCountriesReport(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-20s %-20s %-20s %-20s %-20s", "Name", "Continent", "Region", "Population", "Capital"));
        System.out.println("===========================================================================================");
        // Loop over all countries in the list
        for (Country coun : countries)
        {
            String emp_string =
                    String.format("%-20s %-20s %-20s %-20s %-20s",
                            coun.Name, coun.Continent, coun.Region, coun.Population, coun.Capital);
            System.out.println(emp_string);
        }
    }


    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();
        // Connect to database
        a.connect();
        // Countries in the world from largest population to smallest
        ArrayList<Country> countries = a.getCountries_World();
        a.printCountriesReport(countries);

        // Disconnect from database
        a.disconnect();
    }
}