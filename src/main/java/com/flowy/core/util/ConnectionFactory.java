package com.flowy.core.util;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class ConnectionFactory {

    private DB db;
    private Map<String, DBCollection> collectionMap;

    public ConnectionFactory() throws UnknownHostException {
        String hostName = ConfigHandler.get("mongo.local.host_name");
        String dbName = ConfigHandler.get("mongo.local.database_name");
        int port = Integer.parseInt(ConfigHandler.get("mongo.local.port"));

        db = new MongoClient(hostName, port).getDB(dbName);
        collectionMap = new HashMap<String, DBCollection>();
    }

    public DBCollection getCollection(String collectionName) throws UnknownHostException {
        DBCollection dbCollection;
        if((dbCollection = collectionMap.get(collectionName)) == null) {
            collectionMap.put(collectionName, dbCollection = db.getCollection(collectionName));
        }
        return dbCollection;
    }

}
