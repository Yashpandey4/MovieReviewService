package com.joinsage.schemaservice.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schema {
    private List<Map> uploadMovie;
    private List<Map> uploadRating;

    public Schema() {
        List <Map> um = new ArrayList<>();
        Map entry1 = new HashMap();
        entry1.put("content-type","text");
        entry1.put("placeholder","Movie Name");
        um.add(entry1);
        Map entry2 = new HashMap();
        entry2.put("content-type","text");
        entry2.put("placeholder","Movie Description");
        um.add(entry2);
        this.uploadMovie = um;

        List <Map> ur = new ArrayList<>();
        Map entry3 = new HashMap();
        entry3.put("content-type","text");
        entry3.put("placeholder","Movie Name");
        ur.add(entry3);
        Map entry4 = new HashMap();
        entry4.put("content-type","number");
        entry4.put("placeholder","Movie Rating");
        ur.add(entry4);
        this.uploadRating = ur;


    }

    public List<Map> getUploadRating() {
        return uploadRating;
    }

    public List<Map> getUploadMovie() {
        return uploadMovie;
    }
}
