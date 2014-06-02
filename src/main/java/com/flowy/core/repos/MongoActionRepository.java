package com.flowy.core.repos;

import com.flowy.core.util.ConnectionFactory;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import java.net.UnknownHostException;

/**
 * Created by ssinghal
 * Created on 30-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class MongoActionRepository implements IActionRepository {

    private final DBCollection actionsCollection;

    public MongoActionRepository(ConnectionFactory connectionFactory) throws UnknownHostException {
        actionsCollection = connectionFactory.getCollection(DB_NAME, COLLECTION_NAME);
    }

    @Override
    public Long save(DBObject actionDBObject) {
        return actionsCollection.save(actionDBObject).getN() > 0 ? (Long) actionDBObject.get("id") : null;
    }
}
