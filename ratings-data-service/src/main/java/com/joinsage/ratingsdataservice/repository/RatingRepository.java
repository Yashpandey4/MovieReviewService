package com.joinsage.ratingsdataservice.repository;

import com.joinsage.ratingsdataservice.entity.MovieRating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<MovieRating, String> {
    List<MovieRating> getAllByUserID(String userID);
}
