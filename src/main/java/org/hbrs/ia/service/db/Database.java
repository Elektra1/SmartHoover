package org.hbrs.ia.service.db;

import com.mongodb.MongoClient;

public class Database {

    private static final Database instance = new Database();
    //private final String mongoUrl = "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&ssl=false";
    private MongoClient client = null;
    //private MongoDatabase database;

    private Database() {
    }

    public static Database getInstance() {
        return instance;
    }

    public MongoClient getDB() {
        if (client == null) {
            //client = MongoClients.create(mongoUrl);
            client = new MongoClient("localhost", 27017);
        }
        return client;
    }

    public void init() { getDB(); }

    public void close() {
        if (client != null) {
            try {
                client.close();
                client = null;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Mongo object was null.");
        }
    }

}
