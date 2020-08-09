package com.joinsage.schemaservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joinsage.schemaservice.repository.SchemaRepository;
import com.joinsage.schemaservice.schema.ChoiceSchema;
import com.joinsage.schemaservice.schema.ComponentSchema;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class SchemaService {
    @Autowired
    private SchemaRepository schemaRepository;

    private static RestTemplate restTemplate = new RestTemplate();;
    private static HttpHeaders headers;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static JSONObject resJsonObject;

    public List<ComponentSchema> getComponentsByForm(String form) {
        return schemaRepository.getComponentSchemaByBelongsTo(form);
    }

    public void save(ComponentSchema componentSchema) {
        schemaRepository.save(componentSchema);
    }

    public List<ComponentSchema> getAll() {
        return schemaRepository.findAll();
    }

    public ResponseEntity<String> postMovie(Map<String,String> res) {
        List<ComponentSchema> schema = this.getComponentsByForm("movie-upload");
        if(this.validate(schema,res) != null) return this.validate(schema,res);
        String movieUrl = "http://localhost:8081/movies/";
        return this.processRequest(res , movieUrl);
    }

    public ResponseEntity<String> postRating(Map<String,String> res) {
        List<ComponentSchema> schema = this.getComponentsByForm("rating-upload");
        if(this.validate(schema,res) != null) return this.validate(schema,res);
        String ratingUrl = "http://localhost:8082/ratings/";
        return this.processRequest(res , ratingUrl);
    }

    private ResponseEntity<String> processRequest(Map<String,String> res, String url) {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        resJsonObject = new JSONObject(res);
        HttpEntity<String> request = new HttpEntity<String>(resJsonObject.toString(), headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return response;
    }

    private ResponseEntity<String> validate(List<ComponentSchema> schema , Map<String,String> res) {
        for(int i = 0; i < schema.size(); i++) {
            if(schema.get(i).getRequired() == 1 && res.get(schema.get(i).getName()) == null) {
                return new ResponseEntity(schema.get(i).getName() + " is required", HttpStatus.BAD_REQUEST);
            }
            if(res.get(schema.get(i).getName()) == null) continue;

            if("rating".equals(schema.get(i).getContentType())) {
                if(!isNumeric(res.get(schema.get(i).getName()))) {
                    return new ResponseEntity("rating should be a number", HttpStatus.UNPROCESSABLE_ENTITY);
                }
                int rating = Integer.parseInt(res.get(schema.get(i).getName()));
                if(rating < 1 || rating > 5) {
                    return new ResponseEntity("rating should be between 1 and 5", HttpStatus.UNPROCESSABLE_ENTITY);
                }
            }
            else if("select".equals(schema.get(i).getContentType())) {
                List<ChoiceSchema> choices= schema.get(i).getChoices();
                int find = 0;
                for(int j = 0; j < choices.size(); j++) {
                    if(choices.get(j).getPlaceholder().equals(res.get(schema.get(i).getName()))) {
                        find = 1;
                    }
                }
                if(find == 0) {
                    return new ResponseEntity("Select proper Choice for " + schema.get(i).getName() , HttpStatus.BAD_REQUEST);
                }
            }
        }
        return null;
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
