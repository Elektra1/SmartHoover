package org.hbrs.ia.test;

import com.mongodb.MongoClient;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import org.hbrs.ia.contract.SalesMan;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class HighPerformanceTest {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> salesman;

    @Before
    public void setUp() {
        //Setting up the connection to a local MongoDB with standard port 27017
        //must be started within a terminal with command "mongod"
        client = new MongoClient("localhost", 27017);

        //Get database "highperformance" (creates one if not available)
        database = client.getDatabase("highperformance");

        //Get Collection "salesman" (creates one if not available)
        salesman = database.getCollection("salesman");
    }

    @Test
    public void insertSalesMan() {

        //CREATE (Storing) the salesman object
        Document document = new Document();
        document.append("firstname", "Julia");
        document.append("lastname", "Lepp");
        document.append("id", 12345);

        //storing the object
        salesman.insertOne(document);

        //READ (Finding) the started Document
        Document newDoc = this.salesman.find().first();
        System.out.println("Printing the object (JSON): " + newDoc);

        //Assertion
        int id = (Integer) newDoc.get("id");
        assertEquals(12345, id);

        //Deletion
        salesman.drop();
    }

    @Test
    public void insertSalesmanMoreObjectOriented() {
        //CREATE (Storing) the salesman business object
        //Using setter instead
        SalesMan salesMan = new SalesMan("Lisa", "Lustig", 23568);

        //now storing the object
        salesman.insertOne(salesMan.toDocument());

        //READ (Finding) the stored Document
        Document newDoc = this.salesman.find().first();
        System.out.println("Printing the object (JSON): " + newDoc);

        //Assertion
        int id = (Integer) newDoc.get("id");
        assertEquals(23568, id);

        //Deletion
        salesman.drop();
    }

}
