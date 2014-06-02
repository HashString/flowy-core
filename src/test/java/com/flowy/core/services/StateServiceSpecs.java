package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.models.State;
import com.flowy.core.repos.IStateRepository;
import com.mongodb.DBObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;
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
    public void itShouldCreateAState() {
        //Given
        when(state.getDBObject()).thenReturn(stateDBObject);
        when(mockStateRepository.saveOrUpdate(stateDBObject)).thenReturn(Long.valueOf(1));
        //When
        State savedState = stateService.saveOrUpdate(state);
        //Then
        assertNotNull(savedState);
        verify(mockStateRepository).saveOrUpdate(stateDBObject);
    }

    //TODO [SHANTANU] needs mongo connection to test _id field for update
    @Ignore
    @Test
    public void itShouldUpdateAState() {
        //Given
        when(state.getDBObject()).thenReturn(stateDBObject);
        when(mockStateRepository.saveOrUpdate(stateDBObject)).thenReturn(Long.valueOf(1));
        //When
        State savedState = stateService.saveOrUpdate(state);
        //Then
        assertNotNull(savedState);
        verify(mockStateRepository).saveOrUpdate(stateDBObject);
    }

    @Test
    public void itShouldReturnNullIfCannotCreateState() {
        //Given
        when(state.getDBObject()).thenReturn(stateDBObject);
        when(mockStateRepository.saveOrUpdate(stateDBObject)).thenReturn(null);
        //When
        State savedState = stateService.saveOrUpdate(state);
        //Then
        assertNull(savedState);
        verify(mockStateRepository).saveOrUpdate(stateDBObject);
    }

    @Test
    public void itShouldAddActionToState() {
        //Given
        state = getDummyState();
        Action action = mock(Action.class);
        when(mockStateRepository.saveOrUpdate(any(DBObject.class))).thenReturn(Long.valueOf(1));

        //When
        State stateWithAction = stateService.toStateAddAction(state, action);

        //Then
        assertNotNull(stateWithAction);
        assertThat(stateWithAction.getActions().size(), is(1));
        verify(mockStateRepository).saveOrUpdate(any(DBObject.class));
    }

    @Test
    public void itShouldJustReturnSameStateIfActionAlreadyExists() {
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
        verify(mockStateRepository, times(0)).saveOrUpdate(any(DBObject.class));
    }

    @Test
    public void itShouldReturnNullIfItCanNotAddActionToState() {
        //Given
        Action action = mock(Action.class);
        List<Action> actionList = mock(List.class);
        when(state.getActions()).thenReturn(actionList);
        when(actionList.contains(action)).thenReturn(false);
        when(state.getDBObject()).thenReturn(stateDBObject);
        when(mockStateRepository.saveOrUpdate(stateDBObject)).thenReturn(null);

        //When
        State stateWithAction = stateService.toStateAddAction(state, action);

        //Then
        assertNull(stateWithAction);

        verify(state).getActions();
        verify(actionList).contains(action);
        verify(state).addAction(action);
        verify(state).getDBObject();
        verify(mockStateRepository).saveOrUpdate(stateDBObject);
    }

    private State getDummyState() {
        return new State("someName", Integer.MIN_VALUE, "someDescription");
    }
}
