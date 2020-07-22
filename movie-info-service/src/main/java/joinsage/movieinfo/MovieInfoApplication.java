package joinsage.movieinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieInfoApplication implements CommandLineRunner {

    @Autowired
    private MovieRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MovieInfoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Movie("1", "Pulp Fiction", "Royale with Cheese"));
        repository.save(new Movie("2", "Ford vs Ferrari", "7000 RPM!"));

        System.out.println("Movies found with findAll():");
        System.out.println("-------------------------------");
        for (Movie movie : repository.findAll()) {
            System.out.println(movie);
        }
        System.out.println();
    }
}
