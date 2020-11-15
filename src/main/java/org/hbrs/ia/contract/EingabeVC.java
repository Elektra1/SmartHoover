package org.hbrs.ia.contract;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.hbrs.ia.model.DataBean;
import org.hbrs.ia.model.SalesMan;

public class EingabeVC {

    private EingabeView eingabeView;
    private DataBean dataBean;


    public EingabeVC(DataBean dataBean) {
        this.dataBean = dataBean;
        this.eingabeView = new EingabeView();

        eingabeView.getAddButton().setOnAction(new addButtonEventHandler());
        eingabeView.getAlleButton().setOnAction(new alleButtonEventHandler());
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
            String vname = eingabeView.getVornametf().getText();
            String nname = eingabeView.getNachnametf().getText();
            int id = Integer.parseInt(eingabeView.getIdtf().getText());

            SalesMan salesMan = new SalesMan(vname, nname, id);

            //Einfügen in Database (Create)
            ManageService manageService = new ManageService();
            manageService.createSalesMan(salesMan);

            //Textfelder zuruecksetzen
            eingabeView.getVornametf().setText("");
            eingabeView.getNachnametf().setText("");
            eingabeView.getIdtf().setText("");

            //Daten testen
            if(vname.isEmpty()){
                eingabeView.getMeldungT().setText("Der Vorname fehlt.");
                return;
            }
            if(nname.isEmpty()){
                eingabeView.getMeldungT().setText("Der Nachname fehlt.");
                return;
            }
            if(nname.isEmpty()){
                eingabeView.getMeldungT().setText("Der Nachname fehlt.");
                return;
            }
            //ToDo: id leer Handling

            //Daten hinzufuegen ToDo: Statt DataBean direkt aus der Datenbank holen
            String erg = null;
            erg = dataBean.getNamePwMap().put(vname,nname);

            //Meldung ausgeben
            if(erg == null) {
                eingabeView.getMeldungT().setText("Salesman hinzugefügt");
            }
            else {
                eingabeView.getMeldungT().setText("Salesman bereits vorhanden.");
            }
        }
    }

    private class alleButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            //zur nächsten Seite springen
            AusgabeVC ausgabeVC = new AusgabeVC(dataBean);
            ausgabeVC.show();
        }
    }
}
