package com.flowy.core.repos;

import com.flowy.core.util.ConfigHandler;
import com.flowy.core.util.ConnectionFactory;

import java.net.UnknownHostException;

public class MongoStateRepository extends BaseRepository implements IStateRepository {

    private static final String COLLECTION_NAME = ConfigHandler.get("mongo.repo.state");

    public MongoStateRepository(ConnectionFactory connectionFactory) throws UnknownHostException {
        super(connectionFactory, COLLECTION_NAME);
    }

}
