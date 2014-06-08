package com.flowy.core.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssinghal
 * Created on 29-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */

@Document(collection = "workflow")
public class Workflow {

    @Id
    private String id;

    private String name;
    private String description;
    private List<State> states = new ArrayList<State>();

    public Workflow(String name) {
        this.name = name;
    }

    public Workflow(String name, String description) {
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

    public void addState(State state) {
        states.add(state);
    }

    public List<State> getStates() {
        return states;
    }
}
