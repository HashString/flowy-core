package com.flowy.core.models;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Action implements IMongoDBObject {

    private Long id;
    private String name;
    private String description;

    public Action(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public DBObject getDBObject() {
        return new BasicDBObject()
                .append("id", getId())
                .append("name", getName())
                .append("description", getDescription());
    }
}
