package com.joinsage.schemaservice.response;

public class MovieUploadResponse {
    private String movieName;
    private String movieDescription;

    public MovieUploadResponse(String movieName, String movieDescription) {
        this.movieName = movieName;
        this.movieDescription = movieDescription;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }
}
