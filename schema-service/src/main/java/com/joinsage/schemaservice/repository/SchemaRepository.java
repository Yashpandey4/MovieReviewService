package com.joinsage.schemaservice.repository;

import com.joinsage.schemaservice.schema.ComponentSchema;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SchemaRepository extends MongoRepository<ComponentSchema, String> {
    List<ComponentSchema> getComponentSchemaByBelongsTo(String form);
}
