package com.joinsage.schemaservice.controller;

import com.joinsage.schemaservice.schema.ComponentSchema;
import com.joinsage.schemaservice.service.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schema")
public class SchemaController {
    @Autowired
    private SchemaService schemaService;

    @RequestMapping(value = "/movie-upload", method = RequestMethod.GET)
    public List<ComponentSchema> movieUploadSchema() {
        return schemaService.getComponentsByForm("movie-upload");
    }

    @RequestMapping(value = "/rating-upload", method = RequestMethod.GET)
    public List<ComponentSchema> ratingUploadSchema() {
        return schemaService.getComponentsByForm("rating-upload");
    }

    @RequestMapping(value="/movie-upload" ,method = RequestMethod.POST )
    public ResponseEntity<String> postMovie(@RequestBody Map<String,String> res) {
        return schemaService.postMovie(res);
    }

    @RequestMapping(value="/rating-upload" ,method = RequestMethod.POST )
    public ResponseEntity<String>  postRating(@RequestBody Map<String,String> res) {
        return schemaService.postRating(res);
    }
}
