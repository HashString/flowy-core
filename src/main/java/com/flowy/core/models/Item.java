package com.flowy.core.models;

import com.mongodb.DBObject;

public interface Item extends IMongoDBObject {

    @Override
    public DBObject getDBObject();
}
