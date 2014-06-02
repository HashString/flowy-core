package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.models.State;

import java.net.UnknownHostException;

/**
 * Created by ssinghal
 * Created on 31-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public interface IStateService {

    public State save(State state);

    public State toStateAddAction(State state, Action action) throws UnknownHostException;
}
