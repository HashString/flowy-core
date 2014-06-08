package com.flowy.core.repos;

import com.flowy.core.util.ConfigHandler;
import com.flowy.core.util.ConnectionFactory;

import java.net.UnknownHostException;

/**
 * Created by ssinghal
 * Created on 30-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class MongoActionRepository extends BaseRepository implements IActionRepository {

    private static final String COLLECTION_NAME = ConfigHandler.get("mongo.repo.action");

    public MongoActionRepository(ConnectionFactory connectionFactory) throws UnknownHostException {
        super(connectionFactory, COLLECTION_NAME);
    }
}
