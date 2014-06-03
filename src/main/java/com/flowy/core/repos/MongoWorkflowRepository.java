package com.flowy.core.repos;

import com.flowy.core.util.ConfigHandler;
import com.flowy.core.util.ConnectionFactory;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import java.net.UnknownHostException;

/**
 * Created by ssinghal
 * Created on 29-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class MongoWorkflowRepository extends BaseRepository implements IWorkflowRepository {

    private static final String COLLECTION_NAME = ConfigHandler.get("mongo.repo.workflow");

    public MongoWorkflowRepository(ConnectionFactory connectionFactory) throws UnknownHostException {
        super(connectionFactory, COLLECTION_NAME);
    }
}
