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
                    + "GROUP BY Continent HAVING SUM(Population)>0 ORDER BY Continent Desc;";
            // Execute the first SQL statement
            ResultSet result_1 = stmt_1.executeQuery(getPopulationReports_Country);

            Statement stmt_2 = con.createStatement();  // Create a second SQL statement
            // Create string for the second SQL statement
            String getPopulationReports_City = "SELECT country.Continent, SUM(city.Population) FROM city "
                    + "INNER JOIN country ON city.CountryCode=country.Code "
                    + "GROUP BY country.Continent ORDER BY country.Continent Desc;";
            // Execute the second SQL statement
            ResultSet result_2 = stmt_2.executeQuery(getPopulationReports_City);

            // Extract total population information
            ArrayList<Population> populations = new ArrayList<Population>();
            while (result_1.next() & result_2.next())
            {
                Population pop = new Population();
                pop.setName(result_1.getString("Continent"));
                pop.getName();
                pop.setTotal_population(result_1.getLong("SUM(Population)"));
                pop.getTotal_population();

                if (pop.getTotal_population()>0) {
                    pop.setCity_population(result_2.getLong("SUM(city.Population)"));
                    pop.getCity_population();
                    pop.setNon_city_population(pop.getTotal_population() - pop.getCity_population());
                    pop.getNon_city_population();
                }
                else {
                    pop.setCity_population(0);
                    pop.getCity_population();
                    pop.setNon_city_population(0);
                    pop.getNon_city_population();
                }
                populations.add(pop);
            }
            System.out.println("\nList of population of people, people living in cities, and people not living in cities in each continent\n===========================================================================================");
            return populations;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of the population of people, people living in cities, and people not living in cities in each continent.!!");
            return null;
        }
    }


    public void printPopulationReport(ArrayList<Population> populations) {
        // Print header
        System.out.println(String.format("%-25s %-25s %-25s %-25s", "Place", "Total Population", "City Population", "Non-City Population"));
        System.out.println("===========================================================================================");
        // Loop over all cities in the list
        for (Population population : populations) {
            String population_string =
                    String.format("%-25s %-25s %-25s %-25s",
                            population.getName(), population.getTotal_population(), population.getCity_population(), population.getNon_city_population());
            System.out.println(population_string);
        }
    }


    public static void main(String[] args)
    {

        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Extract information of number of population of people, people living in cities, and people not living in cities in each continent
        ArrayList<Population> populations = a.getPopulation_Continent();
        // print population data
        a.printPopulationReport(populations);

        // Disconnect from database
        a.disconnect();
    }
}