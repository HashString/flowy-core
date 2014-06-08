package com.flowy.core.models;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * Created by ssinghal
 * Created on 30-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class Action {

    private String id;
    private String name;
    private String description;

    public Action(String name) {
        this.name = name;
    }

    public Action(String name, String description) {
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
}
