package com.flowy.core.models;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class State implements IMongoDBObject{

    private Long id;
    private String name;
    private Integer position;
    private String description;
    private List<Action> actions;

    public State(String name, Integer position, String description) {
        this.name = name;
        this.position = position;
        this.description = description;
        this.actions = new ArrayList<Action>();
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

    public void addAction(Action action) {
        actions.add(action);
    }

    public List<Action> getActions() {
        return Collections.unmodifiableList(actions);
    }
}
