package com.example.moviebuddy;

import java.io.Serializable;

public class Movie implements Serializable {
    // Declare private member variables
    private int id;
    private String title;
    private String directors;
    private String casts;
    private String releaseDate;

    // Default constructor
    public Movie() {}

    // Parameterized constructor
    public Movie(int id, String title, String directors, String casts, String releaseDate) {
        this.id = id;
        this.title = title;
        this.directors = directors;
        this.casts = casts;
        this.releaseDate = releaseDate;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for directors
    public String getDirectors() {
        return directors;
    }

    // Setter for directors
    public void setDirectors(String directors) {
        this.directors = directors;
    }

    // Getter for casts
    public String getCasts() {
        return casts;
    }

    // Setter for casts
    public void setCasts(String casts) {
        this.casts = casts;
    }

    // Getter for release date
    public String getReleaseDate() {
        return releaseDate;
    }

    // Setter for release date
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    // Override the toString method to provide a custom string representation of the Movie object
    @Override
    public String toString() {
        return "Title: " + title + ", Directors: " + directors + ", Casts: " + casts + ", Release Date: " + releaseDate;
    }
}
