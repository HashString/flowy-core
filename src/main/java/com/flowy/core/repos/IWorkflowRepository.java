package com.flowy.core.repos;

import com.flowy.core.models.Workflow;

import java.net.UnknownHostException;

public interface IWorkflowRepository {

    public Long save(Workflow workflow) throws UnknownHostException;
}
