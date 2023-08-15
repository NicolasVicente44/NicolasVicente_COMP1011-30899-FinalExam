package com.example.nicolasvicente_comp101130899finalexam;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class PlayerInformationController {

    //scene buildler fxml variables initialization
    @FXML
    private Button allPlayersAndTheirBattingAverageButton;

    @FXML
    private TextArea allPlayersAndTheirBattingAverageTextArea;

    @FXML
    private Button battingAverageBtn;

    @FXML
    private TableColumn<Player, Double> battingAverageColumn;

    @FXML
    private TextArea battingAverageTextArea;

    @FXML
    private TableColumn<Player, String> firstNameColumn;

    @FXML
    private Button highestBattingAverageButton;

    @FXML
    private TextArea highestBattingAverageTextArea;

    @FXML
    private TableColumn<Player, String> lastNameColumn;

    @FXML
    private TableView<Player> listOfPlayersTableView;

    @FXML
    private TableColumn<Player, Integer> playerIdColumn;

    private DatabaseManager databaseManager = new DatabaseManager();


    //load the table view populated with the player on application start
    @FXML
    public void initialize() {
        // Set up the table columns
        playerIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        battingAverageColumn.setCellValueFactory(new PropertyValueFactory<>("battingAverage"));

        // Load player data into the table view
        List<Player> players = databaseManager.getAllPlayers();
        listOfPlayersTableView.getItems().addAll(players);
    }


    //total batting average
    @FXML
    private void onBattingAverageButtonClicked() {
        double averageBattingAverage = databaseManager.calculateAverageBattingAverage();
        battingAverageTextArea.setText("Average Batting Average:\n" + averageBattingAverage);
        System.out.println("Total batting average button clicked");
    }



    //highest player batting average
    @FXML
    private void onHighestBattingAverageButtonClicked() {
        List<Player> players = databaseManager.getAllPlayers();

        double highestAverage = databaseManager.getHighestBattingAverage();

        Player playerWithHighestAverage = null;
        for (Player player : players) {
            if (player.getBattingAverage() == highestAverage) {
                playerWithHighestAverage = player;
                break;
            }
        }

        if (playerWithHighestAverage != null) {
            String playerName = "Player Name:\n " + playerWithHighestAverage.getFirstName() + " " + playerWithHighestAverage.getLastName();
            highestBattingAverageTextArea.setText("Highest Batting Average:\n" + highestAverage + "\n" + playerName);
        } else {
            highestBattingAverageTextArea.setText("No player found with the highest batting average.");
        }

        System.out.println("Highest batting average button clicked");
    }





    // all player names and respective batting averages
    @FXML
    private void onAllPlayersAndTheirBattingAverageButtonClicked() {
        List<Player> players = databaseManager.getAllPlayers();
        List<Double> battingAverages = databaseManager.getAllPlayersBattingAverages();


        StringBuilder sb = new StringBuilder();
        sb.append("All Players and Their Batting Averages\n\n");

        for (int i = 0; i < players.size(); i++) {
            sb.append("Player Name: ").append(players.get(i).getFirstName()).append(" ")
                    .append(players.get(i).getLastName()).append("\n");
            sb.append("Player's Batting Average: ").append(battingAverages.get(i)).append("\n\n");
        }

        allPlayersAndTheirBattingAverageTextArea.setText(sb.toString());
        System.out.println("All players and their batting average button clicked");
    }


    @FXML
    private void onClose() {
        databaseManager.closeConnection();
    }
}
