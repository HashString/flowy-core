package com.flowy.core.models.dbObjects;

import com.flowy.core.models.Workflow;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class WorkflowModel {
    private Workflow workflow;

    public WorkflowModel(Workflow workflow) {
        this.workflow = workflow;
    }

    public DBObject getDBObject() {
        return new BasicDBObject();
    }
}
