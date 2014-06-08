package com.flowy.core.repos;

import com.flowy.core.util.ConnectionFactory;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;

/**
 * Created by ssinghal
 * Created on 03-Jun-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class BaseRepository implements IRepository {

    private DBCollection collection;

    public BaseRepository(ConnectionFactory connectionFactory, String collectionName) throws UnknownHostException {
        collection = connectionFactory.getCollection(collectionName);
    }

    @Override
    public ObjectId saveOrUpdate(DBObject dbObject) {
        return collection.save(dbObject).getError() == null ? (ObjectId) dbObject.get("_id") : null;
    }
}
