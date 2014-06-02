package com.flowy.core.repos;

import com.mongodb.DBObject;

import java.net.UnknownHostException;

public interface IStateRepository {

    public static final String DB_NAME = "someDb";
    public static final String COLLECTION_NAME = "someCollection";

    public Long save(DBObject stateDBObject) throws UnknownHostException;
}
