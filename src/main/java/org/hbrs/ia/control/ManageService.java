package org.hbrs.ia.control;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.hbrs.ia.service.db.Database;
import org.hbrs.ia.contract.ManagePersonal;
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

        Document documentSalesman = salesmanCollection.find(Filters.eq("id", sid)).first();

        SalesMan salesMan = new SalesMan();

        salesMan.setFirstname((String) documentSalesman.get("firstname"));
        salesMan.setLastname((String) documentSalesman.get("lastname"));
        salesMan.setId((Integer) documentSalesman.get("id"));

        return salesMan;

        //return salesmanCollection.find(Filters.eq("id", sid)).first().get("id", SalesMan.class);

    }

    public void updateSalesMan(SalesMan salesMan) {
        //return salesmanCollection.findOneAndUpdate(salesMan, 4567);
        //return salesmanCollection.updateOne(new Document("$set", new Document("firstname", ""), new Document("$set", new Document("lastname", ""), new Document("$set", new Document("id", "")))));
        //return salesmanCollection.findOneAndUpdate(salesMan, new Document("$set", new Document("firstname", ""), new Document("$set", new Document("lastname", ""), new Document("$set", new Document("id", "")))));
    }

    public void deleteSalesMan(SalesMan salesMan) {
        //salesmanCollection.deleteOne(salesMan.toDocument());
        //System.out.println("Salesman deleted successfully...");
    }

    public List<SalesMan> querySalesMan(String attribute, String key) {     //ToDo: Iterator
        Document documentSalesman = salesmanCollection.find(Filters.eq(key, attribute)).first();

        SalesMan salesMan = new SalesMan();

        salesMan.setFirstname((String) documentSalesman.get("firstname"));
        salesMan.setLastname((String) documentSalesman.get("lastname"));
        salesMan.setId((Integer) documentSalesman.get("id"));

        return null;
    }

    public void addPerformanceRecord(PerformanceRecord record, int sid) {
        performanceCollection.insertOne(record.toDocument());
    }

    public PerformanceRecord readEvaluationRecords(int sid) {

        Document documentPerformance = performanceCollection.find(Filters.eq("id", sid)).first();

        PerformanceRecord performanceRecord = new PerformanceRecord();

        performanceRecord.setSalesMan((Integer) documentPerformance.get("salesmanId"));
        performanceRecord.setDescription((String) documentPerformance.get("description"));
        performanceRecord.setTotalsales((Integer) documentPerformance.get("totalsales"));
        performanceRecord.setBonus((Integer) documentPerformance.get("bonus"));
        performanceRecord.setRanking((String) documentPerformance.get("ranking"));
        performanceRecord.setSocialranking((Integer) documentPerformance.get("socialranking"));
        performanceRecord.setYear((String) documentPerformance.get("year"));
        performanceRecord.setId((Integer) documentPerformance.get("id"));

        return performanceRecord;

        //return performanceCollection.find(Filters.eq("id", sid)).first().get("id", PerformanceRecord.class);
    }
}
