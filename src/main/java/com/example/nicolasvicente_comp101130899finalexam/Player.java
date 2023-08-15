package com.example.nicolasvicente_comp101130899finalexam;


//player class that mirrors the player object in the database
public class Player {
    private int id;
    private String firstName;
    private String lastName;
    private double battingAverage;

    public Player(int id, String firstName, String lastName, double battingAverage) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.battingAverage = battingAverage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public void setBattingAverage(double battingAverage) {
        this.battingAverage = battingAverage;
    }
}
