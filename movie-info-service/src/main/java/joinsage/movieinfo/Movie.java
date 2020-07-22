package joinsage.movieinfo;

import org.springframework.data.annotation.Id;


public class Movie {

    @Id
    public String moveiId;

    public String name;
    public String description;

    public Movie() {
    }

    public Movie(String moveiId, String name, String description) {
        this.moveiId = moveiId;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "moveiId='" + moveiId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

