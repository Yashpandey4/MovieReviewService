package com.joinsage.ratingsdataservice.entity;

public class MovieRating {
    private int userID;
    private int movieID;
    private int rating;

    public MovieRating(int userID, int movieID, int rating) {
        this.userID = userID;
        this.movieID = movieID;
        this.rating = rating;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
