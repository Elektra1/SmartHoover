package org.hbrs.ia.gui.eingabe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.hbrs.ia.control.ManageService;
import org.hbrs.ia.gui.ausgabe.AusgabeSalesmanVC;
import org.hbrs.ia.model.DataBean;
import org.hbrs.ia.model.SalesMan;

public class EingabeSalesmanVC {

    private EingabeSalesmanView eingabeView;
    private DataBean dataBean;


    public EingabeSalesmanVC(DataBean dataBean) {
        this.dataBean = dataBean;
        this.eingabeView = new EingabeSalesmanView();

        eingabeView.getAddButton().setOnAction(new addButtonEventHandler());
        eingabeView.getAlleButton().setOnAction(new alleButtonEventHandler());
        eingabeView.getBackButton().setOnAction(new backButtonEventHandler());

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
            if(id == 0){        //ToDo id Handling wenn leer
                eingabeView.getMeldungT().setText("Der Nachname fehlt.");
                return;
            }

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
            AusgabeSalesmanVC ausgabeVC = new AusgabeSalesmanVC(dataBean);
            ausgabeVC.show();
        }
    }
}
