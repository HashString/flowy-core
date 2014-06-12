package com.flowy.core.repos;

import com.flowy.core.models.Workflow;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by ssinghal
 * Created on 30-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mongo-test-config.xml" })
public class BaseRepositorySpecs {

    private Workflow workflow;
    private IRepository repository;

    @Autowired
    private MongoOperations mongoOperations;

    @Before
    public void setUp() throws Exception {
        workflow = new Workflow("dummy workflow");
        repository = new BaseRepository(mongoOperations);
    }

    @Test
    public void itShouldSaveOrUpdateAnObject() {
        //Given
        assertNull(workflow.getId());
        //When
        repository.saveOrUpdate(workflow);
        //Then
        assertNotNull(workflow);
        assertNotNull(workflow.getId());
    }

    @After
    public void tearDown() throws Exception {
        mongoOperations.dropCollection(Workflow.class);
    }
}
