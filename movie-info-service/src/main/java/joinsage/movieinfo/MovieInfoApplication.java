package joinsage.movieinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
        "joinsage.movieinfo.controller", "joinsage.movieinfo.service"})
public class MovieInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieInfoApplication.class, args);
    }

}
