package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.repos.IActionRepository;

/**
 * Created by ssinghal
 * Created on 30-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class ActionService implements IActionService {

    private IActionRepository actionRepository;

    public ActionService(IActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    @Override
    public Action save(Action action) {
        return actionRepository.saveOrUpdate(action.getDBObject()) == null ? null : action;
    }
}
