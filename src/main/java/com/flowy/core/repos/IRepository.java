package com.flowy.core.repos;

import com.mongodb.DBObject;
import org.bson.types.ObjectId;

/**
 * Created by ssinghal
 * Created on 03-Jun-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public interface IRepository {

    public ObjectId saveOrUpdate(DBObject dbObject);
}
