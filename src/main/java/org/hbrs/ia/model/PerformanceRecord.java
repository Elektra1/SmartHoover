package org.hbrs.ia.model;

import org.bson.Document;

import java.util.Date;

public class PerformanceRecord {

    SalesMan salesMan;
    String description;
    int targetvalue;
    int actualvalue;
    Date year;
    int id;

    public SalesMan getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(SalesMan salesMan) {
        this.salesMan = salesMan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTargetvalue() {
        return targetvalue;
    }

    public void setTargetvalue(int targetvalue) {
        this.targetvalue = targetvalue;
    }

    public int getActualvalue() {
        return actualvalue;
    }

    public void setActualvalue(int actualvalue) {
        this.actualvalue = actualvalue;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Document toDocument() {
        Document document = new Document();
        document.append("salesman", this.salesMan);
        document.append("description", this.description);
        document.append("targetvalue", this.targetvalue);
        document.append("actualvalue", this.actualvalue);
        document.append("year", this.year);
        document.append("id", this.id);
        return document;
    }
}
