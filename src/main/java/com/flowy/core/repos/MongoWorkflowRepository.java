package com.flowy.core.repos;

import com.flowy.core.models.Workflow;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Created by ssinghal
 * Created on 29-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class MongoWorkflowRepository extends BaseRepository<Workflow, String> implements IWorkflowRepository {

    public MongoWorkflowRepository(MongoOperations mongoOperations) {
        super(mongoOperations);
    }
}
