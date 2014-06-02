package com.flowy.core.repos;

import com.flowy.core.util.ConnectionFactory;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import java.net.UnknownHostException;

public class MongoStateRepository implements IStateRepository{

    private DBCollection stateCollection;

    public MongoStateRepository(ConnectionFactory connectionFactory) throws UnknownHostException {
        stateCollection = connectionFactory.getCollection(DB_NAME, COLLECTION_NAME);
    }

    @Override
    public Long save(DBObject stateDBObject) throws UnknownHostException {
        return stateCollection.save(stateDBObject).getN() > 0 ? (Long) stateDBObject.get("id") : null;
    }
}
