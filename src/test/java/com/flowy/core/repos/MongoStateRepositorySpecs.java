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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MongoStateRepositorySpecs {

    private DBObject stateDBObject;
    private DBCollection dbCollection;
    private WriteResult writeResult;
    private IStateRepository stateRepository;
    private ConnectionFactory connectionFactory;

    @Before
    public void setUp() throws UnknownHostException {
        stateDBObject = mock(DBObject.class);
        dbCollection = mock(DBCollection.class);
        writeResult = mock(WriteResult.class);
        connectionFactory = mock(ConnectionFactory.class);

        when(connectionFactory.getCollection(IStateRepository.DB_NAME, IStateRepository.COLLECTION_NAME)).thenReturn(dbCollection);
        stateRepository = new MongoStateRepository(connectionFactory);
    }

    @Test
    public void itShouldSaveAState() throws UnknownHostException {
        //given
        when(dbCollection.save(stateDBObject)).thenReturn(writeResult);
        when(writeResult.getN()).thenReturn(1);
        when(stateDBObject.get("id")).thenReturn(Long.valueOf(1));

        //when
        Long savedStateID = stateRepository.saveOrUpdate(stateDBObject);

        //then
        assertNotNull(savedStateID);
        verify(dbCollection).save(stateDBObject);
        verify(writeResult).getN();
        verify(stateDBObject).get("id");
    }

    @Test
    public void itShouldReturnNullIfCannotCreateAState() throws UnknownHostException {
        //given
        when(dbCollection.save(stateDBObject)).thenReturn(writeResult);
        when(writeResult.getN()).thenReturn(0);

        //when
        Long savedStateID = stateRepository.saveOrUpdate(stateDBObject);

        //then
        assertNull(savedStateID);;
        verify(dbCollection).save(stateDBObject);
        verify(writeResult).getN();
    }
}
