package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.repos.IActionRepository;
import org.bson.types.ObjectId;

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
    public Action saveOrUpdate(Action action) {
        ObjectId objectId = actionRepository.saveOrUpdate(action.getDBObject());
        if(objectId != null)
            action.setId(objectId.toString());
        return objectId == null ? null : action;
    }
}
