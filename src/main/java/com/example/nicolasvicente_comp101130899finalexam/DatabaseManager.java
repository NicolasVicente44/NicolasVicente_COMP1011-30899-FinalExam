package com.example.nicolasvicente_comp101130899finalexam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private Connection connection;


    //connects to database
    public DatabaseManager() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/final_exam", "root", "Nico4444");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //lists all players
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM players");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                double battingAverage = resultSet.getDouble("batting_average");

                Player player = new Player(id, firstName, lastName, battingAverage);
                players.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return players;
    }



    //batting average method
    public double calculateAverageBattingAverage() {
        double totalBattingAverage = 0;
        int playerCount = 0;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT batting_average FROM players");

            while (resultSet.next()) {
                totalBattingAverage += resultSet.getDouble("batting_average");
                playerCount++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (playerCount > 0) {
            return totalBattingAverage / playerCount;
        } else {
            return 0;
        }
    }


    //highest batting score method

    public double getHighestBattingAverage() {
        double highestAverage = 0.0;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(batting_average) AS highest_average FROM players");

            if (resultSet.next()) {
                highestAverage = resultSet.getDouble("highest_average");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return highestAverage;
    }



    //all players list batting average

    public List<Double> getAllPlayersBattingAverages() {
        List<Double> battingAverages = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT batting_average FROM players");

            while (resultSet.next()) {
                double battingAverage = resultSet.getDouble("batting_average");
                battingAverages.add(battingAverage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return battingAverages;
    }




    //closes db connection
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
