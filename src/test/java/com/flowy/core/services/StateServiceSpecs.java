package com.flowy.core.services;

import com.flowy.core.models.State;
import com.flowy.core.repos.IStateRepository;
import com.flowy.core.repos.MongoStateRepository;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StateServiceSpecs {

    IStateRepository mockStateRepository;
    private StateService stateService;

    @Before
    public void setUp(){
        mockStateRepository = mock(MongoStateRepository.class);
        stateService = new StateService(mockStateRepository);
    }

    @Test
    public void itShouldCreateAState(){
        //given
        String name = "Test State";
        Integer position = 1;
        String description = "some description";
        when(mockStateRepository.save(any(State.class))).thenReturn(Long.valueOf(1));
        //when
        State state = stateService.create(name, position, description);
        //then
        assertNotNull(state);
        verify(mockStateRepository).save(any(State.class));
    }

    @Test
    public void itShouldReturnNullIfCannotCreateState(){
        //given
        String name = "Test State";
        Integer position = 1;
        String description = "some description";
        when(mockStateRepository.save(any(State.class))).thenReturn(null);
        //when
        State state = stateService.create(name, position, description);
        //then
        assertNull(state);
        verify(mockStateRepository).save(any(State.class));
    }
}
