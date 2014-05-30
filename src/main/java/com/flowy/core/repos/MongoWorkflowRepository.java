package com.flowy.core.repos;

import com.flowy.core.models.Workflow;
import com.flowy.core.models.dbObjects.WorkflowModel;
import com.flowy.core.util.ConnectionFactory;
import com.mongodb.DBObject;

import java.net.UnknownHostException;

public class MongoWorkflowRepository implements IWorkflowRepository {

    ConnectionFactory connectionFactory;

    public MongoWorkflowRepository(ConnectionFactory connectionFactory) throws UnknownHostException {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public Long save(Workflow workflow) throws UnknownHostException {
        DBObject workflowObject = new WorkflowModel(workflow).getDBObject();
        return connectionFactory.getCollection("dbName", "collectionName").save(workflowObject).getN() > 0 ? workflow.getId() : null;
    }
}
