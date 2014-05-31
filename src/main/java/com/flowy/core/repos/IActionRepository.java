package com.flowy.core.repos;

import com.mongodb.DBObject;

import java.net.UnknownHostException;

/**
 * Created by ssinghal
 * Created on 30-May-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public interface IActionRepository {

    public static final String DB_NAME = "someDb";
    public static final String COLLECTION_NAME = "someCollection";

    public Long save(DBObject action) throws UnknownHostException;
}
