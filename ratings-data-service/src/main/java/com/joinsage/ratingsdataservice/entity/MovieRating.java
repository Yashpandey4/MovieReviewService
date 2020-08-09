package com.joinsage.ratingsdataservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movieRatings")
public class MovieRating {
    @Id
    private String ratingID;
    private String userID;
    private String movieName;
    private int rating;

    public MovieRating(String userID, String movieName, int rating) {
        this.userID = userID;
        this.movieName = movieName;
        this.rating = rating;
        this.ratingID = userID + "." + movieName;
    }

    public String getRatingID() {
        return ratingID;
    }

    public void setRatingID(String ratingID) {
        this.ratingID = ratingID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
