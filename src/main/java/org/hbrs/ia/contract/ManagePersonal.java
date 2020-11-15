package org.hbrs.ia.contract;

import org.hbrs.ia.model.PerformanceRecord;
import org.hbrs.ia.model.SalesMan;

import java.util.List;

public interface ManagePersonal {

    public void createSalesMan( SalesMan record );

    public SalesMan readSalesMan(int sid);

    public void updateSalesMan(SalesMan salesMan);

    public void deleteSalesMan(SalesMan salesMan);

    public List<SalesMan> querySalesMan(String attribute , String key );

    public void addPerformanceRecord(PerformanceRecord record , int sid );

    public PerformanceRecord readEvaluationRecords(int sid );

}
