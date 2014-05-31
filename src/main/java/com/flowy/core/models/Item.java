package com.flowy.core.models;

import com.mongodb.DBObject;

/**
 * Created by ssinghal
 * Created on 31-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public interface Item extends IMongoDBObject {

    @Override
    public DBObject getDBObject();
}
