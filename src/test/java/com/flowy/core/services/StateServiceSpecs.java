package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.models.State;
import com.flowy.core.repos.IStateRepository;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class StateServiceSpecs {

    private State state;
    private final Action action = mock(Action.class);
    private IStateRepository mockStateRepository;
    private IStateService stateService;

    @Before
    public void setUp() {
        mockStateRepository = mock(IStateRepository.class);
        stateService = new StateService(mockStateRepository);
        state = new State("someName", Integer.MIN_VALUE, "someDescription");
    }

    @Test
    public void itShouldCreateOrUpdateState() {
        //Given
        when(mockStateRepository.saveOrUpdate(any(DBObject.class))).thenReturn(ObjectId.get());

        //When
        State savedState = stateService.saveOrUpdate(state);

        //Then
        assertNotNull(savedState);
        verify(mockStateRepository).saveOrUpdate(any(DBObject.class));
    }

    @Test
    public void itShouldReturnNullIfCannotCreateOrUpdateState() {
        //Given
        when(mockStateRepository.saveOrUpdate(any(DBObject.class))).thenReturn(null);

        //When
        State savedState = stateService.saveOrUpdate(state);

        //Then
        assertNull(savedState);
        verify(mockStateRepository).saveOrUpdate(any(DBObject.class));
    }

    @Test
    public void itShouldAddActionToState() {
        //Given
        when(mockStateRepository.saveOrUpdate(any(DBObject.class))).thenReturn(ObjectId.get());

        //When
        State stateWithAction = stateService.toStateAddAction(state, action);

        //Then
        assertNotNull(stateWithAction);
        assertThat(stateWithAction.getActions().size(), is(1));
        verify(mockStateRepository).saveOrUpdate(any(DBObject.class));
    }

    @Test
    public void itShouldNotUpdateDatabaseIfActionAlreadyExists() {
        //Given
        state = mock(State.class);
        when(state.getActions()).thenReturn(new ArrayList<Action>() {{
            add(action);
        }});

        //When
        State stateWithAction = stateService.toStateAddAction(state, action);

        //Then
        assertNotNull(stateWithAction);
        verify(mockStateRepository, times(0)).saveOrUpdate(any(DBObject.class));
    }

    @Test
    public void itShouldReturnNullIfItCanNotAddActionToState() {
        //Given
        when(mockStateRepository.saveOrUpdate(any(DBObject.class))).thenReturn(null);

        //When
        State stateWithAction = stateService.toStateAddAction(state, action);

        //Then
        assertNull(stateWithAction);
        verify(mockStateRepository).saveOrUpdate(any(DBObject.class));
    }

}
