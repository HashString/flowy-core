package com.flowy.core.models;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * Created by ssinghal
 * Created on 29-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class Workflow implements IMongoDBObject{

    private Long id;
    private String name;
    private Item manages;
    private String description;

    public Workflow(String name, Item manages, String description) {
        this.name = name;
        this.manages = manages;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Item getManages() {
        return manages;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public DBObject getDBObject() {
        BasicDBObject basicDBObject = new BasicDBObject()
                .append("name", this.getName())
                .append("description", this.getDescription())
                .append("manages", this.getManages().getDBObject());
        return basicDBObject;
    }
}
