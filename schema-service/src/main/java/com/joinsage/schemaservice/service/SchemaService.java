package com.joinsage.schemaservice.service;

import com.joinsage.schemaservice.repository.SchemaRepository;
import com.joinsage.schemaservice.schema.ChoiceSchema;
import com.joinsage.schemaservice.schema.ComponentSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SchemaService {
    @Autowired
    private SchemaRepository schemaRepository;
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
        return new ResponseEntity("Movie added successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> postRating(Map<String,String> res) {
        List<ComponentSchema> schema = this.getComponentsByForm("rating-upload");
        if(this.validate(schema,res) != null) return this.validate(schema,res);
        return new ResponseEntity("Rating added successfully", HttpStatus.OK);
    }

    private ResponseEntity<String> validate(List<ComponentSchema> schema , Map<String,String> res) {
        for(int i = 0; i < schema.size(); i++) {
            if(schema.get(i).getRequired() == 1 && res.get(schema.get(i).getName()) == null) {
                return new ResponseEntity(schema.get(i).getName() + " is required", HttpStatus.BAD_REQUEST);
            }
            if(res.get(schema.get(i).getName()) == null) continue;

            if("rating".equals(schema.get(i).getContentType())) {
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
}
