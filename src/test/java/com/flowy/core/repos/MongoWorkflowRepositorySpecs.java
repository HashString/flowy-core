package com.flowy.core.repos;

import com.flowy.core.util.ConnectionFactory;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ssinghal
 * Created on 29-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class MongoWorkflowRepositorySpecs {

    private DBObject workflowDbObject;
    private IWorkflowRepository workflowRepository;

    @Before
    public void setUp() throws Exception {
        workflowDbObject = new BasicDBObject().append("workflow", "test");
        workflowRepository = new MongoWorkflowRepository(new ConnectionFactory());
    }

    @Test
    public void itShouldSaveWorkflow() {
        //When
        ObjectId id = workflowRepository.saveOrUpdate(workflowDbObject);
        //Then
        assertNotNull(id);
        assertThat(workflowDbObject.get("_id"), Is.<Object>is(id));
    }
}
