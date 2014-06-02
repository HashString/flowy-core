package com.flowy.core.repos;

import com.flowy.core.util.ConnectionFactory;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import java.net.UnknownHostException;

/**
 * Created by ssinghal
 * Created on 29-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class MongoWorkflowRepository implements IWorkflowRepository {

    private final DBCollection workflowCollection;

    public MongoWorkflowRepository(ConnectionFactory connectionFactory) throws UnknownHostException {
        workflowCollection = connectionFactory.getCollection(DB_NAME, COLLECTION_NAME);
    }

    @Override
    public Long save(DBObject workflowDBObject) {
        return workflowCollection.save(workflowDBObject).getN() > 0 ? (Long) workflowDBObject.get("id") : null;
    }
}
