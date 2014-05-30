package com.flowy.core.services;

import com.flowy.core.models.State;
import com.flowy.core.repos.IStateRepository;

public class StateService {

    private IStateRepository stateRepository;

    public StateService(IStateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public State create(String name, Integer position, String description) {
        State state = new State(name, position, description);
        Long stateID = stateRepository.save(state);
        return stateID == null ? null : state;
    }
}
