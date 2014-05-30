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

public class MongoActionRepositorySpecs {

    private DBObject actionDbObject;
    private WriteResult writeResult;
    private DBCollection dbCollection;
    private IActionRepository actionRepository;
    private ConnectionFactory connectionFactory;

    @Before
    public void setUp() throws Exception {
        actionDbObject = mock(DBObject.class);
        writeResult = mock(WriteResult.class);
        dbCollection = mock(DBCollection.class);
        connectionFactory = mock(ConnectionFactory.class);
        when(connectionFactory.getCollection(IActionRepository.DB_NAME, IActionRepository.COLLECTION_NAME)).thenReturn(dbCollection);

        actionRepository = new MongoActionRepository(connectionFactory);
        verify(connectionFactory).getCollection(IActionRepository.DB_NAME, IActionRepository.COLLECTION_NAME);
    }

    @Test
    public void itShouldSaveAnAction() throws UnknownHostException {
        //Given
        when(dbCollection.save(actionDbObject)).thenReturn(writeResult);
        when(writeResult.getN()).thenReturn(1);
        when(actionDbObject.get("id")).thenReturn(Long.valueOf(1));

        //When
        Long id = actionRepository.save(actionDbObject);

        //Then
        assertNotNull(id);
        verify(dbCollection).save(actionDbObject);
        verify(writeResult).getN();
        verify(actionDbObject).get("id");
    }

    @Test
    public void itShouldReturnSaveAnAction() throws UnknownHostException {
        //Given
        when(dbCollection.save(actionDbObject)).thenReturn(writeResult);
        when(writeResult.getN()).thenReturn(0);

        //When
        Long id = actionRepository.save(actionDbObject);

        //Then
        assertNull(id);
        verify(dbCollection).save(actionDbObject);
        verify(writeResult).getN();
    }
}
