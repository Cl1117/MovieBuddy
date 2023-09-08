package com.example.moviebuddy;

import java.io.Serializable;
import java.util.List;

// Class to represent the Cinema
public class Cinema implements Serializable {
    private String id;
    private String name;
    private String location;
    private List<Movie> movieList;

    // Constructor, getters, setters, and other utility methods
    public Cinema() { }

    public Cinema(String id, String name, String location, List<Movie> movieList) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.movieList = movieList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.location;
    }
}
