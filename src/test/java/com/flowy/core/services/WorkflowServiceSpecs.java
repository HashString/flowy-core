package com.flowy.core.services;

import com.flowy.core.models.Item;
import com.flowy.core.models.Workflow;
import com.flowy.core.repos.IWorkflowRepository;
import com.flowy.core.service.WorkflowService;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class WorkflowServiceSpecs {


    private IWorkflowRepository mockRepo = mock(IWorkflowRepository.class);
    private WorkflowService workflowService = new WorkflowService(mockRepo);

    @Test
    public void itShouldCreateAWorkflow() {
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
    public void itShouldReturnNullIfCannotCreateAWorkflow() {
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
