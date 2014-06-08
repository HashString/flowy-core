package com.flowy.core.services;

import com.flowy.core.models.State;
import com.flowy.core.repos.IStateRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StateServiceSpecs {

    private State state;
    private IStateRepository mockStateRepository;
    private IStateService stateService;

    @Before
    public void setUp() {
        mockStateRepository = mock(IStateRepository.class);
        stateService = new StateService(mockStateRepository);
        state = new State("someName", "someDescription");
    }

    @Test
    public void itShouldCreateOrUpdateState() {
        //When
        stateService.saveOrUpdate(state);

        //Then
        verify(mockStateRepository).saveOrUpdate(state);
    }

}
