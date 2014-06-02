package com.flowy.core.models;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class State implements IMongoDBObject{

    private Long id;
    private String name;
    private Integer position;
    private String description;

    public State(String name, Integer position, String description) {
        this.name = name;
        this.position = position;
        this.description = description;
    }

    public Integer getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    @Override
    public DBObject getDBObject() {
        BasicDBObject basicDBObject = new BasicDBObject()
                .append("name", this.getName())
                .append("position", this.getPosition())
                .append("description", this.getDescription());
        return basicDBObject;
    }
}
