package com.flowy.core.repos;

import com.flowy.core.models.State;
import com.mongodb.DBObject;

public class MongoStateRepository implements IStateRepository{

    public MongoStateRepository() {

    }

    @Override
    public Long save(DBObject stateDBObject) {
        return null;
    }
}
