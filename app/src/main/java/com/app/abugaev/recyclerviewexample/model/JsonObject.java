package com.app.abugaev.recyclerviewexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonObject {

    @SerializedName("field")
    @Expose
    private String field;

    @SerializedName("description")
    @Expose
    private String description;

    public JsonObject() {
    }

    public JsonObject(String field, String description) {
        this.field = field;
        this.description = description;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
