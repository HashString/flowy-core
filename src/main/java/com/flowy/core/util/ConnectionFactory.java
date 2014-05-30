package com.flowy.core.util;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

public class ConnectionFactory {

    private MongoClient mongoClient;

    public ConnectionFactory() throws UnknownHostException {
        this.mongoClient = new MongoClient("localhost", 27017);
    }

    public DBCollection getCollection(String dbName, String collectionName) throws UnknownHostException {
        return mongoClient.getDB(dbName).getCollection(collectionName);
    }
}
