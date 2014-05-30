package com.flowy.core.services;

import com.flowy.core.models.Item;
import com.flowy.core.models.Workflow;
import com.flowy.core.repos.IWorkflowRepository;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class WorkflowServiceSpecs {

    private IWorkflowRepository mockRepo;
    private WorkflowService workflowService;

    @Before
    public void setUp() throws Exception {
        mockRepo = mock(IWorkflowRepository.class);
        workflowService = new WorkflowService(mockRepo);
    }

    @Test
    public void itShouldCreateAWorkflow() throws UnknownHostException {
        //Given
        String name = "Test Workflow";
        Item manages = new Item();
        String description = "some desc";
        when(mockRepo.save(any(Workflow.class))).thenReturn(Long.valueOf(1));
        //When
        Workflow workflow = workflowService.create(name, manages, description);
        //Then
        assertNotNull(workflow);
    }

    @Test
    public void itShouldReturnNullIfCannotCreateAWorkflow() throws UnknownHostException {
        //Given
        String name = "Test Workflow";
        Item manages = new Item();
        String description = "some desc";
        when(mockRepo.save(any(Workflow.class))).thenReturn(null);
        //When
        Workflow workflow = workflowService.create(name, manages, description);
        //Then
        assertNull(workflow);
        verify(mockRepo).save(any(Workflow.class));
    }
}
