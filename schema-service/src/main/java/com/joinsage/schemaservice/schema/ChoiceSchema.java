package com.joinsage.schemaservice.schema;

public class ChoiceSchema {
    private String placeholder;
    private int choiceNumber;

    public ChoiceSchema(String placeholder, int choiceNumber) {
        this.placeholder = placeholder;
        this.choiceNumber = choiceNumber;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public int getChoiceNumber() {
        return choiceNumber;
    }

    public void setChoiceNumber(int choiceNumber) {
        this.choiceNumber = choiceNumber;
    }
}
