package com.flowy.core.services;

import com.flowy.core.models.State;
import com.flowy.core.models.Workflow;
import com.flowy.core.repos.IWorkflowRepository;

/**
 * Created by ssinghal
 * Created on 29-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class WorkflowService implements IWorkflowService {

    private IWorkflowRepository workflowRepository;

    public WorkflowService(IWorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    @Override
    public Workflow saveOrUpdate(Workflow workflow) {
        return workflowRepository.saveOrUpdate(workflow);
    }

    @Override
    public Workflow addState(Workflow workflow, State state) {
        workflow.addState(state);
        workflowRepository.saveOrUpdate(workflow);
        return workflow;
    }
}
