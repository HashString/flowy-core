package com.flowy.core.services;

import com.flowy.core.models.State;
import com.flowy.core.repos.IStateRepository;
import com.flowy.core.repos.MongoStateRepository;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StateServiceSpecs {

    IStateRepository mockStateRepository = mock(MongoStateRepository.class);
    private StateService stateService = new StateService(mockStateRepository);

    @Test
    public void itShouldCreateAState(){
        //given
        String name = "Test State";
        Integer position = 1;
        String description = "some description";
        when(mockStateRepository.save(any(State.class))).thenReturn(Long.valueOf(1));
        //when
        Long stateID = stateService.create(name, position, description);
        //then
        assertNotNull(stateID);
    }
}
