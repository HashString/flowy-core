package com.flowy.core.models;

import com.mongodb.DBObject;

public class State implements IMongoDBObject{

    private String name;
    private Integer position;
    private String description;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
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

    public State(String name, Integer position, String description) {
        this.name = name;
        this.position = position;
        this.description = description;
    }

    @Override
    public DBObject getDBObject() {
        return null;
    }
}
