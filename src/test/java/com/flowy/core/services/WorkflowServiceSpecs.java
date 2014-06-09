package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.models.State;
import com.flowy.core.models.Workflow;
import com.flowy.core.repos.IWorkflowRepository;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by ssinghal
 * Created on 29-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class WorkflowServiceSpecs {

    private Workflow workflow;
    private IWorkflowService workflowService;
    private IWorkflowRepository workflowRepository;

    @Before
    public void setUp() throws Exception {
        workflowRepository = mock(IWorkflowRepository.class);
        workflowService = new WorkflowService(workflowRepository);
        workflow = new Workflow("workflowName", "workflowDescription");
    }

    @Test
    public void itShouldSaveOrUpdateAWorkflow() {
        //When
        workflowService.saveOrUpdate(workflow);

        //Then
        verify(workflowRepository).saveOrUpdate(workflow);
    }

    @Test
    public void itShouldAddStateToWorkflow() {
        //Given
        State state = new State("state name");

        //When
        workflowService.addState(workflow, state);

        //Then
        assertThat(workflow.getStates().size(), is(1));
        assertThat(workflow.getStates().get(0), is(state));
    }

    @Test
    public void itShouldAddValidActionToWorkflow() {
        //Given
        Action action = new Action("action name");
        action.setStartState(new State("start state"));
        action.setEndState(new State("end state"));

        //When
        workflowService.addAction(workflow, action);

        //Then
        assertThat(workflow.getActions().size(), is(1));
        assertThat(workflow.getActions().get(0), is(action));
    }

    @Test(expected = IllegalStateException.class)
    public void itShouldNotAddInvalidActionToWorkflow() {
        //Given
        Action action = new Action("action name");

        //When
        workflowService.addAction(workflow, action);

        //Then
        assertThat(workflow.getActions().size(), is(1));
        assertThat(workflow.getActions().get(0), is(action));
    }
}
