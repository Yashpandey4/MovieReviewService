package com.joinsage.schemaservice;

import com.joinsage.schemaservice.repository.SchemaRepository;
import com.joinsage.schemaservice.schema.ChoiceSchema;
import com.joinsage.schemaservice.schema.ComponentSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SchemaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchemaServiceApplication.class, args);
	}

	@Autowired
	SchemaRepository schemaRepository;
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			//Movie-upload
			List<ChoiceSchema> movie1List= new ArrayList<>();
			ComponentSchema movie1 = new ComponentSchema("movieName",
					"movie-upload","text" ,
					"Enter Movie",movie1List,1,
					1);
			schemaRepository.save(movie1);
			List<ChoiceSchema> movie2List= new ArrayList<>();
			ComponentSchema movie2 = new ComponentSchema("movieDescription",
					"movie-upload","text" ,
					"Enter Description",movie2List,1,
					2);
			schemaRepository.save(movie2);

			//Rating-upload
			List<ChoiceSchema> rating1List= new ArrayList<>();
			ComponentSchema rating1 = new ComponentSchema("movieName",
					"rating-upload","text" ,
					"Enter Movie",rating1List,1,
					1);
			schemaRepository.save(rating1);
			List<ChoiceSchema> rating2List= new ArrayList<>();
			ComponentSchema rating2 = new ComponentSchema("rating",
					"rating-upload","rating" ,
					"Enter Movie",rating2List,1,
					2);
			schemaRepository.save(rating2);
			List<ChoiceSchema> rating3List= new ArrayList<>();
			rating3List.add(new ChoiceSchema("0-18",1));
			rating3List.add(new ChoiceSchema("19-30",2));
			rating3List.add(new ChoiceSchema("30+",3));
			ComponentSchema rating3 = new ComponentSchema("ageGroup",
					"rating-upload","select" ,
					"Select Age Group",rating3List,0,
					3);
			schemaRepository.save(rating3);

		};
	}

}
