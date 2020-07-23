package joinsage.movieinfo.service;

import joinsage.movieinfo.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();

    Movie findByMovieId(String movieId);

    List<Movie> findByNameStartingWith(String name);

    void saveOrUpdateMovie(Movie movie);

    void deleteMovie(String movieId);
}
