package com.flowy.core.services;

import com.flowy.core.models.Workflow;
import com.flowy.core.repos.IWorkflowRepository;
import com.mongodb.DBObject;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.*;

public class WorkflowServiceSpecs {

    private Workflow workflow;
    private DBObject workflowDbObject;
    private IWorkflowRepository workflowRepository;
    private WorkflowService workflowService;

    @Before
    public void setUp() throws Exception {
        workflow = mock(Workflow.class);
        workflowDbObject = mock(DBObject.class);
        workflowRepository = mock(IWorkflowRepository.class);
        workflowService = new WorkflowService(workflowRepository);
    }

    @Test
    public void itShouldSaveAWorkflow() throws UnknownHostException {
        //Given
        when(workflow.getDBObject()).thenReturn(workflowDbObject);
        when(workflowRepository.save(workflowDbObject)).thenReturn(Long.valueOf(1));

        //When
        Workflow savedWorkflow = workflowService.save(workflow);

        //Then
        assertNotNull(savedWorkflow);
        verify(workflow).getDBObject();
        verify(workflowRepository).save(workflowDbObject);
    }

    @Test
    public void itShouldReturnNullIfCannotSaveAWorkflow() throws UnknownHostException {
        //Given
        when(workflow.getDBObject()).thenReturn(workflowDbObject);
        when(workflowRepository.save(workflowDbObject)).thenReturn(null);

        //When
        Workflow savedWorkflow = workflowService.save(workflow);

        //Then
        assertNull(savedWorkflow);
        verify(workflow).getDBObject();
        verify(workflowRepository).save(workflowDbObject);
    }
}
