package com.flowy.core.repos;

import com.flowy.core.util.ConfigHandler;
import com.flowy.core.util.ConnectionFactory;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import org.bson.types.ObjectId;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by ssinghal
 * Created on 30-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class BaseRepositorySpecs {

    private DBObject dbObject;
    private WriteResult writeResult;
    private DBCollection dbCollection;
    private ConnectionFactory connectionFactory;

    private IRepository repository;
    private static final String COLLECTION_NAME = ConfigHandler.get("mongo.repo.action");

    @Before
    //TODO [SHANTANU] start thinking about cleaning up the database
    public void setUp() throws Exception {
        writeResult = mock(WriteResult.class);
        dbCollection = mock(DBCollection.class);
        connectionFactory = new ConnectionFactory();
        dbObject = new BasicDBObject().append("basic", "test");
        repository = new BaseRepository(connectionFactory, COLLECTION_NAME);
    }

    @Test
    public void itShouldSaveAnObject() {
        //Given
        assertNull(dbObject.get("_id"));
        //When
        ObjectId id = repository.saveOrUpdate(dbObject);
        //Then
        assertNotNull(id);
        assertThat(dbObject.get("_id"), Is.<Object>is(id));
    }

    @Test
    public void itShouldReturnSaveAnObject() throws UnknownHostException {
        //Given
        connectionFactory = mock(ConnectionFactory.class);
        when(connectionFactory.getCollection(COLLECTION_NAME)).thenReturn(dbCollection);

        repository = new MongoActionRepository(connectionFactory);
        when(dbCollection.save(dbObject)).thenReturn(writeResult);
        when(writeResult.getError()).thenReturn("dummy error");

        //When
        ObjectId id = repository.saveOrUpdate(dbObject);

        //Then
        assertNull(id);
        verify(dbCollection).save(dbObject);
        verify(writeResult).getError();
    }

    @Test
    public void itShouldUpdateAnObject() {
        //Given
        ObjectId oldId = repository.saveOrUpdate(dbObject);
        //When
        dbObject.put("update", "test");
        ObjectId updatedId = repository.saveOrUpdate(dbObject);
        //Then
        assertNotNull(updatedId);
        assertThat(updatedId, Is.<Object>is(oldId));
    }
}
