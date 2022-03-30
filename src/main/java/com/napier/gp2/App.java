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
                            city.getName(), city.getCountry(), city.getDistrict(), city.getPopulation());
            System.out.println(city_string);
        }
    }

    // main
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // get city data of the world
        ArrayList<City> cities = a.getCities_World();
        // print city data
        a.printCityReport(cities);

        // get city data of the continent
        cities = a.getCities_Continent();
        // print city data
        a.printCityReport(cities);

        // get city data of the region
        cities = a.getCities_Region();
        // print city data
        a.printCityReport(cities);

        // get city data of the district
        cities = a.getCities_District();
        // print city data
        a.printCityReport(cities);

        // get city data of the country
        cities = a.getCities_Country();
        // print city data
        a.printCityReport(cities);

        // Extract information of top N populated cities in the world
        cities = a.getTopNPopulatedCity_World();
        // print city data
        a.printCityReport(cities);

        // Extract information of top N populated cities in a continent
        cities = a.getTopNPopulatedCity_Continent();
        // print city data
        a.printCityReport(cities);

        // Extract information of top N populated cities in a region
        cities = a.getTopNPopulatedCity_Region();
        // print city data
        a.printCityReport(cities);

        // Extract information of top N populated cities in a country
        cities = a.getTopNPopulatedCity_Country();
        // print city data
        a.printCityReport(cities);

        // Extract information of top N populated cities in a district
        cities = a.getTopNPopulatedCity_District();
        // print city data
        a.printCityReport(cities);

        // Disconnect from database
        a.disconnect();
    }
}