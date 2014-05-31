package com.flowy.core.repos;

import com.mongodb.DBObject;

import java.net.UnknownHostException;

/**
 * Created by ssinghal
 * Created on 29-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public interface IWorkflowRepository {

    public static final String DB_NAME = "someDb";
    public static final String COLLECTION_NAME = "someCollection";

    public Long save(DBObject workflowDbObject) throws UnknownHostException;
}
