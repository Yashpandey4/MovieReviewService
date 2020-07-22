package com.joinsage.moviecatalogservice.models;

import java.util.List;

public class UserRating {

    private List<Rating> userRating;

    // For java to unmartial a non object to object, provide it with an empty constructor.
    public UserRating() {

    }

    public List<Rating> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }
}
