package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.models.State;
import com.flowy.core.repos.IStateRepository;

public class StateService implements IStateService {

    private IStateRepository stateRepository;

    public StateService(IStateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public State saveOrUpdate(State state) {
        return stateRepository.saveOrUpdate(state);
    }

}
