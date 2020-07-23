package joinsage.movieinfo.controller;

import joinsage.movieinfo.model.Movie;
import joinsage.movieinfo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/")
    public List<Movie> getAllMovies() {
        return movieService.findAll();
    }

    @GetMapping(value = "/movieId/{movieId}")
    public Movie getMovieByMovieId(@PathVariable("movieId") String movieId){
        return movieService.findByMovieId(movieId);
    }

    @GetMapping(value = "/name/{name}")
    public List<Movie> getMovieByNameStartingWith(@PathVariable("name") String name){
        return movieService.findByNameStartingWith(name);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveOrUpdateMovie(@RequestBody Movie movie){
        movieService.saveOrUpdateMovie(movie);
        return new ResponseEntity("Movie added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{movieId")
    public void deleteMovie(@PathVariable String movieId){
        movieService.deleteMovie(movieId);
    }
}
