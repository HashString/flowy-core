package com.flowy.core.services;

import com.flowy.core.models.Action;
import com.flowy.core.repos.IActionRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    public void itShouldSaveOrUpdateAnAction() {
        //When
        actionService.saveOrUpdate(action);

        //Then
        verify(mockRepository).saveOrUpdate(action);
    }
}
