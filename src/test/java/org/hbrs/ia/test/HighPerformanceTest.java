package org.hbrs.ia.test;

import com.mongodb.MongoClient;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import org.junit.Before;


public class HighPerformanceTest {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> salesman;

    @Before
    void setUp() {

    }

}
