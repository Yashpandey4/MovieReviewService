package com.joinsage.ratingsdataservice.controller;


import com.joinsage.ratingsdataservice.dao.MovieRatingDao;
import com.joinsage.ratingsdataservice.entity.MovieRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private MovieRatingDao dao;
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Set<MovieRating>> getAllRatings() {
        return dao.getAllRatings();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Set<MovieRating> getRatingsById(@PathVariable("id") int id){
        return dao.getRatingsById(id);
    }
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertUser(@RequestBody MovieRating movieRating) {
        dao.insertUser(movieRating);
    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertRatingByUser(@PathVariable("id") int id ,@RequestBody MovieRating movieRating) {
        dao.insertRating(id, movieRating);
    }
}
