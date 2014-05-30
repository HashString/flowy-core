package com.flowy.core.repos;

import com.flowy.core.util.ConnectionFactory;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import java.net.UnknownHostException;

public class MongoActionRepository implements IActionRepository {

    private final DBCollection actionsCollection;

    public MongoActionRepository(ConnectionFactory connectionFactory) throws UnknownHostException {
        actionsCollection = connectionFactory.getCollection(DB_NAME, COLLECTION_NAME);
    }

    @Override
    public Long save(DBObject action) throws UnknownHostException {
        return actionsCollection.save(action).getN() > 0 ? (Long) action.get("id") : null;
    }
}
