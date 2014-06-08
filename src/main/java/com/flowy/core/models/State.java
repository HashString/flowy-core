package com.flowy.core.models;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class State {

    private String id;
    private String name;
    private String description;
    private List<Action> actions = new ArrayList<Action>();

    public State(String name) {
        this.name = name;
    }

    public State(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public List<Action> getActions() {
        return Collections.unmodifiableList(actions);
    }
}
