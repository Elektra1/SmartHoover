package org.hbrs.ia.model;

import org.bson.Document;

import java.util.List;

public class SalesMan {

    private String firstname;
    private String lastname;
    private int id;

    public SalesMan(String firstname, String lastname, int id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private List<PerformanceRecord> performanceRecords;

    public Document toDocument() {
        Document document = new Document();
        document.append("firstname", this.firstname);
        document.append("lastname", this.lastname);
        document.append("id", this.id);
        return document;
    }
}
