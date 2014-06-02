package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.models.State;
import com.flowy.core.repos.IStateRepository;
import com.mongodb.DBObject;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class StateServiceSpecs {

    private State state;
    private DBObject stateDBObject;
    private IStateRepository mockStateRepository;
    private IStateService stateService;

    @Before
    public void setUp(){
        state = mock(State.class);
        stateDBObject = mock(DBObject.class);
        mockStateRepository = mock(IStateRepository.class);
        stateService = new StateService(mockStateRepository);
    }

    @Test
    public void itShouldCreateAState() throws UnknownHostException {
        //Given
        when(state.getDBObject()).thenReturn(stateDBObject);
        when(mockStateRepository.save(stateDBObject)).thenReturn(Long.valueOf(1));
        //When
        State savedState = stateService.save(state);
        //Then
        assertNotNull(savedState);
        verify(mockStateRepository).save(stateDBObject);
    }

    @Test
    public void itShouldReturnNullIfCannotCreateState() throws UnknownHostException {
        //Given
        when(state.getDBObject()).thenReturn(stateDBObject);
        when(mockStateRepository.save(stateDBObject)).thenReturn(null);
        //When
        State savedState = stateService.save(state);
        //Then
        assertNull(savedState);
        verify(mockStateRepository).save(stateDBObject);
    }

    @Test
    public void itShouldAddActionToState() throws UnknownHostException {
        //Given
        state = getDummyState();
        Action action = mock(Action.class);
        when(mockStateRepository.save(any(DBObject.class))).thenReturn(Long.valueOf(1));

        //When
        State stateWithAction = stateService.toStateAddAction(state, action);

        //Then
        assertNotNull(stateWithAction);
        assertThat(stateWithAction.getActions().size(), is(1));
        verify(mockStateRepository).save(any(DBObject.class));
    }

    @Test
    public void itShouldJustReturnSameStateIfActionAlreadyExists() throws UnknownHostException {
        //Given
        Action action = mock(Action.class);
        List<Action> actionList = mock(List.class);
        when(state.getActions()).thenReturn(actionList);
        when(actionList.contains(action)).thenReturn(true);

        //When
        State stateWithAction = stateService.toStateAddAction(state, action);

        //Then
        assertNotNull(stateWithAction);
        assertEquals(stateWithAction, state);

        verify(state).getActions();
        verify(actionList).contains(action);
        verify(mockStateRepository, times(0)).save(any(DBObject.class));
    }

    @Test
    public void itShouldReturnNullIfItCanNotAddActionToState() throws UnknownHostException {
        //Given
        Action action = mock(Action.class);
        List<Action> actionList = mock(List.class);
        when(state.getActions()).thenReturn(actionList);
        when(actionList.contains(action)).thenReturn(false);
        when(state.getDBObject()).thenReturn(stateDBObject);
        when(mockStateRepository.save(stateDBObject)).thenReturn(null);

        //When
        State stateWithAction = stateService.toStateAddAction(state, action);

        //Then
        assertNull(stateWithAction);

        verify(state).getActions();
        verify(actionList).contains(action);
        verify(state).addAction(action);
        verify(state).getDBObject();
        verify(mockStateRepository).save(stateDBObject);
    }

    private State getDummyState() {
        return new State("someName", Integer.MIN_VALUE, "someDescription");
    }
}
