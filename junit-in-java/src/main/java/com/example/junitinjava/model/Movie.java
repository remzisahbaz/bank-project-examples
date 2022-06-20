package com.example.junitinjava.model;

import lombok.Data;

import java.util.Date;
import java.util.Objects;


public class Movie {

    private String title;
    private Date releaseDate;
    @SuppressWarnings("unused")
    private String duration;

    public Movie(String title, Date releaseDate, String duration) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) && Objects.equals(releaseDate, movie.releaseDate) && Objects.equals(duration, movie.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseDate, duration);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration='" + duration + '\'' +
                '}';
    }
}
