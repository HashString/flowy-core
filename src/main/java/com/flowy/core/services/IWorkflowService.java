package com.flowy.core.services;

import com.flowy.core.models.State;
import com.flowy.core.models.Workflow;

/**
 * Created by ssinghal
 * Created on 31-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public interface IWorkflowService {
    Workflow saveOrUpdate(Workflow workflow);
    Workflow addState(Workflow workflow, State state);
}
