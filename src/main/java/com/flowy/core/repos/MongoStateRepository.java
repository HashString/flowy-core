package com.flowy.core.repos;

import com.flowy.core.models.State;
import org.springframework.data.mongodb.core.MongoOperations;

public class MongoStateRepository extends BaseRepository<State, String> implements IStateRepository {

    public MongoStateRepository(MongoOperations mongoOperations) {
        super(mongoOperations);
    }
}
