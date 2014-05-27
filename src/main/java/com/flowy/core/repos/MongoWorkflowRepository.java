package com.flowy.core.repos;

import com.flowy.core.models.Workflow;
import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoWorkflowRepository implements IWorkflowRepository {

    DB db;
    MongoClient mongoClient;

    @Override
    public Long save(Workflow workflow) {
        return null;
    }
}
