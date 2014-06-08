package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.models.State;
import com.flowy.core.repos.IStateRepository;
import org.bson.types.ObjectId;

public class StateService implements IStateService {

    private IStateRepository stateRepository;

    public StateService(IStateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public State saveOrUpdate(State state) {
        ObjectId objectId = stateRepository.saveOrUpdate(state.getDBObject());
        if(objectId != null)
            state.setId(objectId.toString());
        return objectId == null ? null : state;
    }

    @Override
    public State toStateAddAction(State state, Action action) {
        if(!state.getActions().contains(action)) {
            state.addAction(action);
            return stateRepository.saveOrUpdate(state.getDBObject()) == null ? null : state;
        }
        return state;
    }
}
