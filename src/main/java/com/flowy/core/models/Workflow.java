package com.flowy.core.models;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * Created by ssinghal
 * Created on 29-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class Workflow implements IMongoDBObject{

    private String id;
    private String name;
    private String description;

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

    @Override
    public DBObject getDBObject() {
        BasicDBObject basicDBObject = new BasicDBObject()
                .append("name", this.getName())
                .append("description", this.getDescription());
        return basicDBObject;
    }
}
