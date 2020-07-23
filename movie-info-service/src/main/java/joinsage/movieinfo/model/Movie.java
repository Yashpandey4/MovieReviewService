package joinsage.movieinfo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
public class Movie {

    @Id
    private String movieId;

    private String name;
    private String description;

    public Movie() {
    }

    public Movie(String moveiId, String name, String description) {
        this.movieId = moveiId;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "moveiId='" + movieId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

