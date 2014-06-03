package com.flowy.core.services;

import com.flowy.core.models.Item;
import com.flowy.core.models.Workflow;
import com.flowy.core.repos.IWorkflowRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.*;

/**
 * Created by ssinghal
 * Created on 29-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class WorkflowServiceSpecs {

    private Workflow workflow;
    private DBObject workflowDbObject;
    private IWorkflowRepository workflowRepository;
    private IWorkflowService workflowService;

    @Before
    public void setUp() throws Exception {
        workflowDbObject = mock(DBObject.class);
        workflowRepository = mock(IWorkflowRepository.class);
        workflowService = new WorkflowService(workflowRepository);

        Item mockItem = mock(Item.class);
        when(mockItem.getDBObject()).thenReturn(new BasicDBObject());
        workflow = new Workflow("workflowName", mockItem, "workflowDescription");
    }

    @Test
    public void itShouldSaveAWorkflow() {
        //Given
        when(workflowRepository.saveOrUpdate(any(DBObject.class))).thenReturn(ObjectId.get());

        //When
        Workflow savedWorkflow = workflowService.saveOrUpdate(workflow);

        //Then
        assertNotNull(savedWorkflow);
        verify(workflowRepository).saveOrUpdate(any(DBObject.class));
    }

    @Test
    public void itShouldReturnNullIfCannotSaveAWorkflow() {
        //Given
        when(workflowRepository.saveOrUpdate(any(DBObject.class))).thenReturn(null);

        //When
        Workflow savedWorkflow = workflowService.saveOrUpdate(workflow);

        //Then
        assertNull(savedWorkflow);
        verify(workflowRepository).saveOrUpdate(any(DBObject.class));
    }
}
