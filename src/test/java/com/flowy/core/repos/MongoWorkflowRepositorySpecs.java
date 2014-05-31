package com.flowy.core.repos;

import com.flowy.core.util.ConnectionFactory;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.*;

/**
 * Created by ssinghal
 * Created on 29-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class MongoWorkflowRepositorySpecs {

    private WriteResult writeResult;
    private DBCollection dbCollection;
    private DBObject workflowDbObject;
    private IWorkflowRepository workflowRepository;
    private ConnectionFactory connectionFactory;

    @Before
    public void setUp() throws Exception {
        writeResult = mock(WriteResult.class);
        dbCollection = mock(DBCollection.class);
        workflowDbObject = mock(DBObject.class);
        connectionFactory = mock(ConnectionFactory.class);
        when(connectionFactory.getCollection(IWorkflowRepository.DB_NAME, IWorkflowRepository.COLLECTION_NAME)).thenReturn(dbCollection);

        workflowRepository = new MongoWorkflowRepository(connectionFactory);
        verify(connectionFactory).getCollection(IWorkflowRepository.DB_NAME, IWorkflowRepository.COLLECTION_NAME);
    }

    @Test
    public void itShouldSaveAWorkflow() throws UnknownHostException {
        //Given
        when(dbCollection.save(workflowDbObject)).thenReturn(writeResult);
        when(writeResult.getN()).thenReturn(1);
        when(workflowDbObject.get("id")).thenReturn(Long.valueOf(1));

        //When
        Long save = workflowRepository.save(workflowDbObject);

        //Then
        assertNotNull(save);
        verify(dbCollection).save(workflowDbObject);
        verify(writeResult).getN();
        verify(workflowDbObject).get("id");
    }

    @Test
    public void itShouldReturnNullIfCannotSaveAWorkflow() throws UnknownHostException {
        //Given
        when(dbCollection.save(workflowDbObject)).thenReturn(writeResult);
        when(writeResult.getN()).thenReturn(0);

        //When
        Long save = workflowRepository.save(workflowDbObject);

        //Then
        assertNull(save);
        verify(dbCollection).save(workflowDbObject);
        verify(writeResult).getN();
    }
}
