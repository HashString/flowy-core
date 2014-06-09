package com.flowy.core.repos;

import com.flowy.core.models.State;

public interface IStateRepository extends IRepository<State, String> {

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
     *
     * @param   state the state entity that will be persisted
     * @return  <tt>_id</tt> of the stateDBObject
     */
    @Override
    public State saveOrUpdate(State state);
}
