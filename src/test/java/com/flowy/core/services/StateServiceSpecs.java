package com.flowy.core.services;

import com.flowy.core.models.State;
import com.flowy.core.repos.IStateRepository;
import com.mongodb.DBObject;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StateServiceSpecs {

    private IStateRepository mockStateRepository;
    private IStateService stateService;
    private State state;
    private DBObject stateDBObject;

    @Before
    public void setUp(){
        state = mock(State.class);
        stateDBObject = mock(DBObject.class);
        mockStateRepository = mock(IStateRepository.class);
        stateService = new StateService(mockStateRepository);
    }

    @Test
    public void itShouldCreateAState() throws UnknownHostException {
        //given
        when(state.getDBObject()).thenReturn(stateDBObject);
        when(mockStateRepository.save(stateDBObject)).thenReturn(Long.valueOf(1));
        //when
        State savedState = stateService.save(state);
        //then
        assertNotNull(savedState);
        verify(mockStateRepository).save(stateDBObject);
    }

    @Test
    public void itShouldReturnNullIfCannotCreateState() throws UnknownHostException {
        //given
        when(state.getDBObject()).thenReturn(stateDBObject);
        when(mockStateRepository.save(stateDBObject)).thenReturn(null);
        //when
        State savedState = stateService.save(state);
        //then
        assertNull(savedState);
        verify(mockStateRepository).save(stateDBObject);
    }
}
