package com.flowy.core.repos;

import com.flowy.core.models.Action;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Created by ssinghal
 * Created on 30-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class MongoActionRepository extends BaseRepository<Action, String> implements IActionRepository {

    public MongoActionRepository(MongoOperations mongoOperations) {
        super(mongoOperations);
    }
}
