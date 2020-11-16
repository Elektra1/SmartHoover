package org.hbrs.ia.gui.eingabe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.hbrs.ia.control.ManageService;
import org.hbrs.ia.gui.ausgabe.AusgabePerformanceVC;
import org.hbrs.ia.model.DataBean;
import org.hbrs.ia.model.PerformanceRecord;

public class EingabePerformanceVC {

    private EingabePerformanceView eingabeView;
    private DataBean dataBean;


    public EingabePerformanceVC(DataBean dataBean) {
        this.dataBean = dataBean;
        this.eingabeView = new EingabePerformanceView();

        eingabeView.getBackButton().setOnAction(new EingabePerformanceVC.backButtonEventHandler());
        eingabeView.getAddButton().setOnAction(new EingabePerformanceVC.addButtonEventHandler());
        eingabeView.getAlleButton().setOnAction(new EingabePerformanceVC.alleButtonEventHandler());
    }

    public void show() {
        eingabeView.show(dataBean.getPrimaryStage());
    }

    private class addButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            //Meldung reseten
            eingabeView.getMeldungT().setText("");

            //Daten aus den Textfelder holen
            int salesmanid = Integer.parseInt(eingabeView.getSalesmanIdtf().getText());
            String description = eingabeView.getDescriptiontf().getText();
            int totalsales = Integer.parseInt(eingabeView.getTotalsalestf().getText());
            int bonus = Integer.parseInt(eingabeView.getBonustf().getText());
            String ranking = eingabeView.getRankingtf().getText();
            int socialranking = Integer.parseInt(eingabeView.getSocialrankingtf().getText());
            String year = eingabeView.getYeartf().getText();
            int id = Integer.parseInt(eingabeView.getIdtf().getText());

            PerformanceRecord performanceRecord = new PerformanceRecord(salesmanid, description, totalsales, bonus, ranking, socialranking, year, id);

            //Einfügen in Database (Create)
            ManageService manageService = new ManageService();
            manageService.addPerformanceRecord(performanceRecord, performanceRecord.getId());

            //Textfelder zuruecksetzen
            eingabeView.getSalesmanIdtf().setText("");
            eingabeView.getDescriptiontf().setText("");
            eingabeView.getTotalsalestf().setText("");
            eingabeView.getBonustf().setText("");
            eingabeView.getRankingtf().setText("");
            eingabeView.getSocialrankingtf().setText("");
            eingabeView.getYeartf().setText("");
            eingabeView.getIdtf().setText("");

            //Daten testen
            if(salesmanid == 0){        //ToDo: isEmpty bei allen ints
                eingabeView.getMeldungT().setText("Die Salesman ID fehlt.");
                return;
            }
            if(description.isEmpty()){
                eingabeView.getMeldungT().setText("Die Beschreibung fehlt.");
                return;
            }
            if(totalsales == 0){
                eingabeView.getMeldungT().setText("Der Gesamtverkauf fehlt.");
                return;
            }
            if(bonus == 0){
                eingabeView.getMeldungT().setText("Der Bonus fehlt.");
                return;
            }
            if(ranking.isEmpty()){
                eingabeView.getMeldungT().setText("Die Bewertung fehlt.");
                return;
            }
            if(socialranking == 0){
                eingabeView.getMeldungT().setText("Die soziale Bewertung fehlt.");
                return;
            }
            if(id == 0){            //ToDo: Fehler-Handling id des Salesman vorhanden?
                eingabeView.getMeldungT().setText("Die Record-Id fehlt.");
                return;
            }
            //Daten hinzufuegen ToDo: Statt DataBean direkt aus der Datenbank holen
            //String erg = null;
            //erg = dataBean.getNamePwMap().put(salesmanid, description, totalsales, bonus, ranking, socialranking, year, id);

            //Meldung ausgeben
            //if(erg == null) {
           //     eingabeView.getMeldungT().setText("Salesman hinzugefügt");
            //}
            //else {
            //    eingabeView.getMeldungT().setText("Salesman bereits vorhanden.");
            //}
        }
    }

    private class backButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            //zur nächsten Seite springen
            HomeVC homeVC = new HomeVC(dataBean);
            homeVC.show();
        }
    }

    private class alleButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            //zur nächsten Seite springen
            AusgabePerformanceVC ausgabeVC = new AusgabePerformanceVC(dataBean);
            ausgabeVC.show();
        }
    }

}
