package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.repos.IActionRepository;
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
        action = new Action("actionName", "actionDescription");
    }

    @Test
    public void itShouldSaveAnAction() {
        //Given
        when(mockRepository.saveOrUpdate(any(DBObject.class))).thenReturn(ObjectId.get());
        assertNull(action.getId());

        //When
        actionService.saveOrUpdate(action);

        //Then
        assertNotNull(action);
        assertNotNull(action.getId());
        verify(mockRepository).saveOrUpdate(any(DBObject.class));
    }

    @Test
    public void itShouldReturnNullIfItCannotSaveAnAction() {
        //Given
        when(mockRepository.saveOrUpdate(any(DBObject.class))).thenReturn(null);
        assertNull(action.getId());

        //When
        actionService.saveOrUpdate(action);

        //Then
        assertNull(action.getId());
        verify(mockRepository).saveOrUpdate(any(DBObject.class));
    }
}
