package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.repos.IActionRepository;

import java.net.UnknownHostException;

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
        try {
            return actionRepository.save(action.getDBObject()) == null ? null : action;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}
