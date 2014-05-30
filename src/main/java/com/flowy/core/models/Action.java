package com.flowy.core.models;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Action implements IMongoDBObject {

    private Long id;
    private String name;
    private String description;
    private State startState;

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

    public String getDescription() {
        return description;
    }

    public State getStartState() {
        return startState;
    }

    @Override
    public DBObject getDBObject() {
        return new BasicDBObject()
                .append("id", getId())
                .append("name", getName())
                .append("startState", getStartState().getDBObject())
                .append("description", getDescription());
    }
}
