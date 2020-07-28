package com.joinsage.schemaservice.response;

public class RatingUploadResponse {
    private String movieName;
    private int rating;
    private String ageGroup;

    public RatingUploadResponse(String movieName, int rating, String ageGroup) {
        this.movieName = movieName;
        this.rating = rating;
        this.ageGroup = ageGroup;
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

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
}
