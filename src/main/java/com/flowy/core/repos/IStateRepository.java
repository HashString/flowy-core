package com.flowy.core.repos;

import com.mongodb.DBObject;

public interface IStateRepository {

    public static final String DB_NAME = "someDb";
    public static final String COLLECTION_NAME = "someCollection";

    public Long saveOrUpdate(DBObject stateDBObject);
}
