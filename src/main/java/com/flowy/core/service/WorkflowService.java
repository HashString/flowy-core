package com.flowy.core.service;

import com.flowy.core.models.Item;
import com.flowy.core.models.Workflow;
import com.flowy.core.repos.IWorkflowRepository;

public class WorkflowService {

    private IWorkflowRepository workflowRepository;

    public WorkflowService(IWorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public Workflow create(String name, Item manages, String description) {
        Workflow workflow = new Workflow(name, manages, description);
        Long workflowId = workflowRepository.save(workflow);
        return workflowId == null ? null : workflow;
    }
}
