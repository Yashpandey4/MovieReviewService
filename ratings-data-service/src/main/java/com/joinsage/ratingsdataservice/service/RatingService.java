package com.joinsage.ratingsdataservice.service;

import com.joinsage.ratingsdataservice.entity.MovieRating;
import com.joinsage.ratingsdataservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public List<MovieRating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public List<MovieRating>  getRatingsById(String userID) {
        return ratingRepository.getAllByUserID(userID);
    }

    public ResponseEntity<String> saveRating(MovieRating movieRating) {
        if(movieRating.getMovieName() == null ||
            movieRating.getUserID() == null ||
            movieRating.getRating() < 1 || movieRating.getRating() > 5) {
            return new ResponseEntity("Rating Cannot be added", HttpStatus.BAD_REQUEST);
        }
        ratingRepository.save(movieRating);
        return new ResponseEntity("Rating added successfully", HttpStatus.OK);
    }

}
