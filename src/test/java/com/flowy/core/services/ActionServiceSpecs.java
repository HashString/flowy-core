package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.models.State;
import com.flowy.core.repos.IActionRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.*;

/**
 * Created by ssinghal
 * Created on 30-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class ActionServiceSpecs {

    private Action action;
    private IActionService actionService;
    private IActionRepository mockRepository;

    @Before
    public void setUp() throws Exception {
        mockRepository = mock(IActionRepository.class);
        actionService = new ActionService(mockRepository);

        State mockEndState = mock(State.class);
        State mockStartState = mock(State.class);
        when(mockEndState.getDBObject()).thenReturn(new BasicDBObject());
        when(mockStartState.getDBObject()).thenReturn(new BasicDBObject());
        action = new Action("actionName", "actionDescription", mockStartState, mockEndState);
    }

    @Test
    public void itShouldSaveAnAction() {
        //Given
        when(mockRepository.saveOrUpdate(any(DBObject.class))).thenReturn(ObjectId.get());

        //When
        Action savedAction = actionService.saveOrUpdate(action);

        //Then
        assertNotNull(savedAction);
        verify(mockRepository).saveOrUpdate(any(DBObject.class));
    }

    @Test
    public void itShouldReturnNullIfItCannotSaveAnAction() {
        //Given
        when(mockRepository.saveOrUpdate(any(DBObject.class))).thenReturn(null);

        //When
        Action savedAction = actionService.saveOrUpdate(action);

        //Then
        assertNull(savedAction);
        verify(mockRepository).saveOrUpdate(any(DBObject.class));
    }
}
