package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.repos.IActionRepository;

import java.net.UnknownHostException;

public class ActionService {

    private IActionRepository actionRepository;

    public ActionService(IActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public Action save(Action action) {
        try {
            return actionRepository.save(action.getDBObject()) == null ? null : action;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}
