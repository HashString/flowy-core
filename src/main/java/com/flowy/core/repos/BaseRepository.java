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
    //TODO [SHANTANU] find a better way of checking for write success
    public ObjectId saveOrUpdate(DBObject dBObject) {
        return collection.save(dBObject).getError() == null ? (ObjectId) dBObject.get("_id") : null;
    }
}
