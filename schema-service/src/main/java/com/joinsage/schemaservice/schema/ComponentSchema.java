package com.joinsage.schemaservice.schema;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Schema")
public class ComponentSchema {
    @Id
    private String componentId;
    private String belongsTo;
    private String name;
    private String contentType;
    private String placeholder;
    private List<ChoiceSchema> choices;
    private int required;
    private int componentPriority;


    public String getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(String belongsTo) {
        this.belongsTo = belongsTo;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public List<ChoiceSchema> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoiceSchema> choices) {
        this.choices = choices;
    }

    public int getRequired() {
        return required;
    }

    public void setRequired(int required) {
        this.required = required;
    }

    public int getComponentPriority() {
        return componentPriority;
    }

    public void setComponentPriority(int componentPriority) {
        this.componentPriority = componentPriority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComponentSchema(String name, String belongsTo, String contentType, String placeholder, List<ChoiceSchema> choices, int required, int componentPriority) {
        this.componentId = belongsTo +'-'+ componentPriority;
        this.belongsTo = belongsTo;
        this.contentType = contentType;
        this.placeholder = placeholder;
        this.choices = choices;
        this.required = required;
        this.componentPriority = componentPriority;
        this.name = name;
    }
}