package org.hbrs.ia.model;

import org.bson.Document;

import java.util.Date;

public class PerformanceRecord {

    int salesManId;
    String description;
    int totalsales;
    int bonus;
    String ranking;
    int socialranking;
    String year;          //ToDo: Date
    int id;

    public PerformanceRecord() {

    }

    public PerformanceRecord(int salesManId, String description, int totalsales, int bonus, String ranking, int socialranking, String year, int id) {
        this.salesManId = salesManId;
        this.description = description;
        this.totalsales = totalsales;
        this.bonus = bonus;
        this.ranking = ranking;
        this.socialranking = socialranking;
        this.year = year;
        this.id = id;
    }

    public int getSalesMan() {
        return salesManId;
    }

    public void setSalesMan(int alesManId) {
        this.salesManId = salesManId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalsales() {
        return totalsales;
    }

    public void setTotalsales(int totalsales) {
        this.totalsales = totalsales;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public int getSocialranking() {
        return socialranking;
    }

    public void setSocialranking(int socialranking) {
        this.socialranking = socialranking;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Document toDocument() {
        Document document = new Document();
        document.append("salesmanId", this.salesManId);
        document.append("description", this.description);
        document.append("totalsales", this.totalsales);
        document.append("bonus", this.bonus);
        document.append("ranking", this.ranking);
        document.append("socialranking", this.socialranking);
        document.append("year", this.year);
        document.append("id", this.id);
        return document;
    }

    public String toString() {
        return "Id: " + this.id + " SalesmanId: " + this.salesManId + " Description: " + this.description + " Totalsales: " + this.totalsales
                + " Bonus: " + this.bonus + " Ranking: " + ranking + " Socialranking: " + socialranking + " Year: " + year;
    }
}
