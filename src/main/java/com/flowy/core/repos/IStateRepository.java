package com.flowy.core.repos;

import com.flowy.core.models.State;
import com.mongodb.DBObject;

public interface IStateRepository {

    public Long save(DBObject stateDBObject);
}
