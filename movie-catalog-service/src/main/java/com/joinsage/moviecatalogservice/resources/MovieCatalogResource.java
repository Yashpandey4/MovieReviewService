package com.joinsage.moviecatalogservice.resources;

import com.joinsage.moviecatalogservice.models.CatalogItem;
import com.joinsage.moviecatalogservice.models.Movie;
import com.joinsage.moviecatalogservice.models.Rating;
import com.joinsage.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        // get rated movie ID - for each ID, call info service and get details. Finally put them all together.

        UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratings/users/" + userId, UserRating.class);
//        http://apigateway/ratings-data/ratings/user

        return ratings.getUserRating().stream().map(rating -> {
            // RestTemplate based Implementation: Call Movie-Info service running on port 8081
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieID(), Movie.class);

            /*
            // WebClient based implementation: Reactive Web Way (Call Movie-Info service running on port 8081)
            Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8081/movies/" + rating.getMovieID())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
             */
            // Put them all together
            return new CatalogItem(movie.getName(), "Desc", rating.getRating());
        })
                .collect(Collectors.toList());

    }
}
