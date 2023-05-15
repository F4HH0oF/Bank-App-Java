/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

 class Katalog {
     private String name;
     private int year;
     private int duration;
     private String genre;
     private Double rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Katalog(String name, int year, int duration, String genre, Double rating) {
        this.name = name;
        this.year = year;
        this.duration = duration;
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + ", " + year + ", " + duration + " minutes"+ ", " + genre + ", IMDB rating - " + rating;
    }
     
     
}
