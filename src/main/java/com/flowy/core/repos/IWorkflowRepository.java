package com.flowy.core.repos;

import com.flowy.core.models.Workflow;

/**
 * Created by ssinghal
 * Created on 29-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public interface IWorkflowRepository extends IRepository<Workflow, String> {

    /**
     * The saveOrUpdate() method uses either the <b>Insert</b> or the <b>Update</b> command, which use the default write concern.
     *
     * <p>
     * <b>Insert</b>
     * saveOrUpdate() method calls the insert() method of DBCollection if the workflowDBObject does not contain an _id field.
     * </p>
     *
     * <p>
     * <b>Upsert</b>
     * saveOrUpdate() method calls the update() method with the upsert option and a query on the _id field if the workflowDBObject contain an _id field.
     * </p>
     *
     * @param   workflow the workflow entity that will be persisted
     * @return  <tt>_id</tt> of the workflowDBObject
     */
    @Override
    public Workflow saveOrUpdate(Workflow workflow);
}
