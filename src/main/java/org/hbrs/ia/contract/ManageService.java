package org.hbrs.ia.contract;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.hbrs.ia.model.PerformanceRecord;
import org.hbrs.ia.model.SalesMan;

import java.util.List;

public class ManageService implements ManagePersonal {

    private MongoClient mongoClient = null;
    private static final String DBNAME = "PerformanceDB";
    private static MongoCollection<Document> salesmanCollection = null;
    private static MongoCollection<Document> performanceCollection = null;

    public ManageService() {
        mongoClient = Database.getInstance().getDB();
        salesmanCollection = mongoClient.getDatabase(DBNAME).getCollection("salesman");
        performanceCollection = mongoClient.getDatabase(DBNAME).getCollection("performanceRecord");
    }

    public void createSalesMan(SalesMan record) {
        salesmanCollection.insertOne(record.toDocument());
    }

    public SalesMan readSalesMan(int sid) {
        //return salesmanCollection.find().first();
        return null;
    }

    public void updateSalesMan(SalesMan salesMan) {
        //return salesmanCollection.findOneAndUpdate(salesMan, 4567);
    }

    public void deleteSalesMan(SalesMan salesMan) {
        //database.getDB()
    }

    public List<SalesMan> querySalesMan(String attribute, String key) {
        return null;
    }

    public void addPerformanceRecord(PerformanceRecord record, int sid) {
        performanceCollection.find().limit(1).sort(new Document("$natural","-1}"));
        performanceCollection.insertOne(record.toDocument());
    }

    public PerformanceRecord readEvaluationRecords(int sid) {
        return null;
    }
}
