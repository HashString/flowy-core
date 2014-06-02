package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.repos.IActionRepository;
import com.mongodb.DBObject;
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

    private IActionService actionService;
    private IActionRepository mockRepository;

    @Before
    public void setUp() throws Exception {
        mockRepository = mock(IActionRepository.class);
        actionService = new ActionService(mockRepository);
    }

    @Test
    public void itShouldSaveAnAction() {
        //Given
        Action action = mock(Action.class);
        DBObject mockDBObject = mock(DBObject.class);
        when(action.getDBObject()).thenReturn(mockDBObject);
        when(mockRepository.save(mockDBObject)).thenReturn(Long.valueOf(1));

        //When
        Action savedAction = actionService.save(action);

        //Then
        assertNotNull(savedAction);
        verify(action).getDBObject();
        verify(mockRepository).save(mockDBObject);
    }

    @Test
    public void itShouldReturnNullIfItCannotSaveAnAction() {
        //Given
        Action action = mock(Action.class);
        DBObject mockDBObject = mock(DBObject.class);
        when(action.getDBObject()).thenReturn(mockDBObject);
        when(mockRepository.save(mockDBObject)).thenReturn(null);

        //When
        Action savedAction = actionService.save(action);

        //Then
        assertNull(savedAction);
        verify(action).getDBObject();
        verify(mockRepository).save(mockDBObject);
    }
}
