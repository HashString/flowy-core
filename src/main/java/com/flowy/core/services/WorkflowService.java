package com.flowy.core.services;

import com.flowy.core.models.Workflow;
import com.flowy.core.repos.IWorkflowRepository;

import java.net.UnknownHostException;

public class WorkflowService {

    private IWorkflowRepository workflowRepository;

    public WorkflowService(IWorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public Workflow save(Workflow workflow) {
        try {
            return workflowRepository.save(workflow.getDBObject()) == null ? null : workflow;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}
