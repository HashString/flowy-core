package com.flowy.core.repos;

import com.flowy.core.util.ConnectionFactory;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import java.net.UnknownHostException;

public class MongoWorkflowRepository implements IWorkflowRepository {

    private final DBCollection workflowCollection;

    public MongoWorkflowRepository(ConnectionFactory connectionFactory) throws UnknownHostException {
        workflowCollection = connectionFactory.getCollection(DB_NAME, COLLECTION_NAME);
    }

    @Override
    public Long save(DBObject workflowDbObject) throws UnknownHostException {
        return workflowCollection.save(workflowDbObject).getN() > 0 ? (Long) workflowDbObject.get("id") : null;
    }
}
