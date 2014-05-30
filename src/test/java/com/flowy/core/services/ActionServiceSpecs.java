package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.repos.IActionRepository;
import com.mongodb.DBObject;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ActionServiceSpecs {

    private ActionService actionService;
    private IActionRepository mockRepository;

    @Before
    public void setUp() throws Exception {
        mockRepository = mock(IActionRepository.class);
        actionService = new ActionService(mockRepository);
    }

    @Test
    public void itShouldCreateAnAction() throws UnknownHostException {
        //Given
        Action action = mock(Action.class);
        DBObject mockDBObject = mock(DBObject.class);
        when(action.getDBObject()).thenReturn(mockDBObject);
        when(mockRepository.save(mockDBObject)).thenReturn(Long.valueOf(1));

        //When
        Long id = actionService.create(action);

        //Then
        assertNotNull(id);
        verify(action).getDBObject();
        verify(mockRepository).save(mockDBObject);
    }

    @Test
    public void itShouldReturnNullIfItCannotCreateAnAction() throws UnknownHostException {
        //Given
        Action action = mock(Action.class);
        DBObject mockDBObject = mock(DBObject.class);
        when(action.getDBObject()).thenReturn(mockDBObject);
        when(mockRepository.save(mockDBObject)).thenReturn(null);

        //When
        Long id = actionService.create(action);

        //Then
        assertNull(id);
        verify(action).getDBObject();
        verify(mockRepository).save(mockDBObject);
    }
}
