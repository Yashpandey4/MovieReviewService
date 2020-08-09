package com.joinsage.moviecatalogservice.models;


public class Rating {
    private String userID;
    private String movieID;
    private int rating;

    // For java to unmartial a non object to object, provide it with an empty constructor.
    public Rating() {

    }

    public Rating(String userID, String movieID, int rating) {
        this.userID = userID;
        this.movieID = movieID;
        this.rating = rating;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
