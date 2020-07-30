package com.joinsage.ratingsdataservice.controller;


import com.joinsage.ratingsdataservice.entity.MovieRating;
import com.joinsage.ratingsdataservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableZuulProxy
@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @RequestMapping(method = RequestMethod.GET)
    public List<MovieRating> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @RequestMapping(value = "/{userID}", method = RequestMethod.GET)
    public List<MovieRating>  getRatingsById(@PathVariable("userID") String userID){
        return ratingService.getRatingsById(userID);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveRating(@RequestBody MovieRating movieRating) {
        return ratingService.saveRating(movieRating);
    }

}
