package com.flowy.core.repos;

import com.flowy.core.util.ConnectionFactory;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import java.net.UnknownHostException;

public class MongoStateRepository implements IStateRepository{

    private DBCollection stateCollection;

    public MongoStateRepository(ConnectionFactory connectionFactory) throws UnknownHostException {
        stateCollection = connectionFactory.getCollection(DB_NAME, COLLECTION_NAME);
    }

    /**
     * The saveOrUpdate() method uses either the <b>Insert</b> or the <b>Update</b> command, which use the default write concern.
     *
     * <p>
     * <b>Insert</b>
     * saveOrUpdate() method calls the insert() method of DBCollection if the stateDBObject does not contain an _id field.
     * </p>
     *
     * <p>
     * <b>Upsert</b>
     * saveOrUpdate() method calls the update() method with the upsert option and a query on the _id field if the stateDBObject contain an _id field.
     * </p>
     *
     * @param   stateDBObject database object representation of the state entity that will be persisted
     * @return  <tt>_id</tt> of the stateDBObject
     */
    @Override
    public Long saveOrUpdate(DBObject stateDBObject) {
        return stateCollection.save(stateDBObject).getN() > 0 ? (Long) stateDBObject.get("id") : null;
    }
}
