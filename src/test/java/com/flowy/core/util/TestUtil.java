package com.flowy.core.util;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

/**
 * Created by ssinghal
 * Created on 08-Jun-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class TestUtil {

    private static DB db;
    private static ConnectionFactory connectionFactory;

    static {
        String hostName = ConfigHandler.get("mongo.local.host_name");
        String dbName = ConfigHandler.get("mongo.local.database_name");
        int port = Integer.parseInt(ConfigHandler.get("mongo.local.port"));

        try {
            connectionFactory = new ConnectionFactory();
            db = new MongoClient(hostName, port).getDB(dbName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void dropCollection(String collectionName) {
        db.getCollection(collectionName).drop();
    }
}
