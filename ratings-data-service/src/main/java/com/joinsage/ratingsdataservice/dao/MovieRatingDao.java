package com.joinsage.ratingsdataservice.dao;

import com.joinsage.ratingsdataservice.entity.MovieRating;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRatingDao {
    private static Map<Integer, Set<MovieRating>> Ratings;
    static {
        Ratings = new HashMap<Integer, Set<MovieRating>>();

        Set<MovieRating> user1 = new HashSet<>();
        user1.add(new MovieRating(1, 1, 5));
        user1.add(new MovieRating(1, 2, 3));

        Set<MovieRating> user2 = new HashSet<>();
        user2.add(new MovieRating(2, 3, 3));
        user2.add(new MovieRating(2, 2, 2));

        Ratings.put(1,user1);
        Ratings.put(2,user2);
    }

    public Collection<Set<MovieRating>> getAllRatings(){
        return this.Ratings.values();
    }

    public Set<MovieRating> getRatingsById(int id){
        return this.Ratings.get(id);
    }

    public void insertUser(MovieRating movieRating) {
        Set<MovieRating> newUser = new HashSet<>();
        newUser.add(movieRating);
        Ratings.put(movieRating.getUserID(), newUser);
    }

    public void insertRating(int id, MovieRating movieRating) {
        Set<MovieRating> existingUser = Ratings.get(id);
        existingUser.add(movieRating);
        Ratings.put(id, existingUser);
    }
}
