package joinsage.movieinfo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {

    public Movie findByMoveiId(String movieId);
    public List<Movie> findByNameStartingWith(String name);

}
