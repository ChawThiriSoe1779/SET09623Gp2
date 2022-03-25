package com.napier.gp2;

import java.sql.*;

public class App
{
    public static void main(String[] args)
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

        // Connection to the database
        Connection con = null;
        int retries = 100;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                // Wait a bit
                Thread.sleep(10000);
                // Exit for loop
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

    // Funtion to get countries in the Continent from largest population to smallest report data
    public ArrayList<Country> getCountries_Continent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String continent = "'Africa'";
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Continent="+ continent +" ORDER BY Population DESC";
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

    // Funtion to get countries in the region from largest population to smallest report data
    public ArrayList<Country> getCountries_Region()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String region = "'Caribbean'";
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Region="+ region +" ORDER BY Population DESC";
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


    // Funtion to get top 'n' populated countries in the world where n is provided by the user
    public ArrayList<Country> getTopNPopulatedCountries_World()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            int limitno = 20;       // for N in a list of Top "N" populated country in the world
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population DESC LIMIT "+ limitno;
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

    // Funtion to get top 'n' populated countries in the Continent where n is provided by the user
    public ArrayList<Country> getTopNPopulatedCountries_Continent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            int limitno = 20;       // for N in a list of Top "N" populated country in the world
            String continent = "Oceania";
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country  WHERE Continent="+ continent + " ORDER BY Population DESC LIMIT "+limitno;
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

    // Funtion to get top 'n' populated countries in the Region where n is provided by the user
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
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Region="+ region + " ORDER BY Population DESC LIMIT "+limitno;
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

// Funtion to print countries report sorted by largest population to smallest
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
        // Countries in the continent from largest population to smallest
        countries = a.getCountries_Continent();
        a.printCountriesReport(countries);
        // Countries in the region from largest population to smallest
        countries = a.getCountries_Region();
        a.printCountriesReport(countries);
        // Top populated Country in the World
        countries = a.getTopNPopulatedCountries_World();
        a.printCountriesReport(countries);
        // Top populated Country in the continent
        countries = a.getTopNPopulatedCountries_Continent();
        a.printCountriesReport(countries);
        // Top populated Country in the region
        countries = a.getTopNPopulatedCountries_Region();
        a.printCountriesReport(countries);
        // Disconnect from database
        a.disconnect();
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

    /*
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
            ArrayList<City> cities = new ArrayList<City>();
            while (result.next())
            {
                City actiy = new City();
                actiy.name = result.getString("city.Name");
                actiy.country = result.getString("country.Name");
                actiy.district = result.getString("city.District");
                actiy.population = result.getInt("city.Population");
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

    /*
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
            ArrayList<City> cities = new ArrayList<City>();
            while (result.next())
            {
                City actiy = new City();
                actiy.name = result.getString("city.Name");
                actiy.country = result.getString("country.Name");
                actiy.district = result.getString("city.District");
                actiy.population = result.getInt("city.Population");
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

    /*
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
            ArrayList<City> cities = new ArrayList<City>();
            while (result.next())
            {
                City actiy = new City();
                actiy.name = result.getString("city.Name");
                actiy.country = result.getString("country.Name");
                actiy.district = result.getString("city.District");
                actiy.population = result.getInt("city.Population");
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

    /*
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
            ArrayList<City> cities = new ArrayList<City>();
            while (result.next())
            {
                City actiy = new City();
                actiy.name = result.getString("city.Name");
                actiy.country = result.getString("country.Name");
                actiy.district = result.getString("city.District");
                actiy.population = result.getInt("city.Population");
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

    /*
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
            ArrayList<City> cities = new ArrayList<City>();
            while (result.next())
            {
                City actiy = new City();
                actiy.name = result.getString("city.Name");
                actiy.country = result.getString("country.Name");
                actiy.district = result.getString("city.District");
                actiy.population = result.getInt("city.Population");
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
//        ArrayList<City> cities = a.getCities_Country();

        // Extract information of top N populated cities in the world
//        ArrayList<City> cities = a.getTopNPopulatedCity_World();

        // Extract information of top N populated cities in a continent
//        ArrayList<City> cities = a.getTopNPopulatedCity_Continent();

        // Extract information of top N populated cities in a region
//        ArrayList<City> cities = a.getTopNPopulatedCity_Region();

        // Extract information of top N populated cities in a country
//        ArrayList<City> cities = a.getTopNPopulatedCity_Country();

        // Extract information of top N populated cities in a district
        ArrayList<City> cities = a.getTopNPopulatedCity_District();

        // print city data
        a.printCityReport(cities);

        // Disconnect from database
        a.disconnect();
    }
}