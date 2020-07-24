package com.joinsage.ratingsdataservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movieRatings")
public class MovieRating {
    @Id
    private String ratingID;
    private String userID;
    private String movieID;
    private int rating;

    public MovieRating(String userID, String movieID, int rating) {
        this.userID = userID;
        this.movieID = movieID;
        this.rating = rating;
        this.ratingID = userID+'-'+movieID;
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
