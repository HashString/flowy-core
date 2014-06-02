package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.models.State;
import com.flowy.core.repos.IStateRepository;

import java.net.UnknownHostException;

public class StateService implements IStateService {

    private IStateRepository stateRepository;

    public StateService(IStateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public State save(State state) {
        try {
            return stateRepository.save(state.getDBObject()) == null ? null : state;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public State toStateAddAction(State state, Action action) throws UnknownHostException {
        if(!state.getActions().contains(action)) {
            state.addAction(action);
            return stateRepository.save(state.getDBObject()) == null ? null : state;
        }
        return state;
    }
}
