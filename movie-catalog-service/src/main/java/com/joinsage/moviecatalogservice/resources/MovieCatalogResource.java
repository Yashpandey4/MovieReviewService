package com.joinsage.moviecatalogservice.resources;

import com.joinsage.moviecatalogservice.models.CatalogItem;
import com.joinsage.moviecatalogservice.models.Movie;
import com.joinsage.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        // get rated movie ID - for each ID, call info service and get details. Finally put them all together.

        List<Rating> ratings = Arrays.asList(
                new Rating(userId, "12", 4),
                new Rating(userId, "11", 5)
        );

        return ratings.stream().map(rating -> {
            // Call Movie-Info service running on port 8081
            Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieID(), Movie.class);
            return new CatalogItem(movie.getName(), "Desc", rating.getRating());
        })
                .collect(Collectors.toList());

    }
}
