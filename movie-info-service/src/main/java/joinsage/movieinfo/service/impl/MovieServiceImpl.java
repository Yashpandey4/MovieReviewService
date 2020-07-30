package joinsage.movieinfo.service.impl;

import joinsage.movieinfo.model.Movie;
import joinsage.movieinfo.repository.MovieRepository;
import joinsage.movieinfo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findByMovieId(String movieId) {
        return movieRepository.findByMovieId(movieId);
    }

    @Override
    public List<Movie> findByNameStartingWith(String name) {
        return movieRepository.findByMovieNameStartingWith(name);
    }

    @Override
    public void saveOrUpdateMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(String movieId) {
        movieRepository.deleteById(movieId);
    }
}
