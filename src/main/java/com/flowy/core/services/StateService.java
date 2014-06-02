package com.flowy.core.services;

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
}
