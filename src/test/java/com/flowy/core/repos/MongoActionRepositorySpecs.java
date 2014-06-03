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

/**
 * Created by ssinghal
 * Created on 30-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class MongoActionRepositorySpecs {

    private DBObject actionDbObject;
    private IActionRepository actionRepository;

    @Before
    public void setUp() throws Exception {
        actionDbObject = new BasicDBObject().append("action", "test");
        actionRepository = new MongoActionRepository(new ConnectionFactory());
    }

    @Test
    public void itShouldSaveAnAction() {
        //When
        ObjectId id = actionRepository.saveOrUpdate(actionDbObject);
        //Then
        assertNotNull(id);
        assertThat(actionDbObject.get("_id"), Is.<Object>is(id));
    }

}
