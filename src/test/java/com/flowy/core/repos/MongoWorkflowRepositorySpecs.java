package com.flowy.core.repos;

import com.flowy.core.models.Workflow;
import com.flowy.core.util.ConnectionFactory;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MongoWorkflowRepositorySpecs {

    private IWorkflowRepository workflowRepository;//mock(IWorkflowRepository.class);
    private Workflow mockWorkflow;
    private ConnectionFactory mockConnectionFactory;

    @Before
    public void setUp() throws Exception {
        mockWorkflow = mock(Workflow.class);
        mockConnectionFactory = mock(ConnectionFactory.class);
        workflowRepository = new MongoWorkflowRepository(mockConnectionFactory);
    }

    @Test
    public void itShouldSaveAWorkflow() throws UnknownHostException {
        //given
        WriteResult mockWriteResult = mock(WriteResult.class);
        DBCollection mockCollection = mock(DBCollection.class);
        when(mockConnectionFactory.getCollection(anyString(), anyString())).thenReturn(mockCollection);
        when(mockCollection.save(any(DBObject.class))).thenReturn(mockWriteResult);
        when(mockWriteResult.getN()).thenReturn(1);
        //when
        Long save = workflowRepository.save(mockWorkflow);
        //then
        assertNotNull(save);
    }
}
