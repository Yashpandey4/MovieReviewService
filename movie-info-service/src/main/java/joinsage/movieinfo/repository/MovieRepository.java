package joinsage.movieinfo.repository;

import java.util.List;

import joinsage.movieinfo.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {

    Movie findByMovieId(String movieId);
    List<Movie> findByNameStartingWith(String name);

}
