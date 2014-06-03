package com.flowy.core.repos;

import com.flowy.core.util.ConnectionFactory;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;

public class MongoStateRepositorySpecs {

    private DBObject stateDbObject;
    private IStateRepository stateRepository;

    @Before
    public void setUp() throws Exception {
        stateDbObject = new BasicDBObject().append("state", "test");
        stateRepository = new MongoStateRepository(new ConnectionFactory());
    }

    @Test
    public void itShouldSaveState() {
        //When
        ObjectId id = stateRepository.saveOrUpdate(stateDbObject);
        //Then
        assertNotNull(id);
        assertThat(stateDbObject.get("_id"), Is.<Object>is(id));
    }
}
