package org.hbrs.ia.gui.ausgabe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.hbrs.ia.gui.eingabe.EingabeSalesmanVC;
import org.hbrs.ia.control.ManageService;
import org.hbrs.ia.model.DataBean;

public class AusgabeSalesmanVC {

    private DataBean dataBean;
    private AusgabeSalesmanView ausgabeView;

    public AusgabeSalesmanVC(DataBean dataBean) {
        this.dataBean = dataBean;
        this.ausgabeView = new AusgabeSalesmanView();

        //EventHandler registrieren
        ausgabeView.getSucheButton().setOnAction(new AusgabeSalesmanVC.sucheButtonEventHandler());
        ausgabeView.getBackButton().setOnAction(new AusgabeSalesmanVC.backButtonEventHandler());
    }

    public void show() {
        //View mit Daten befüllen
        //int anz = 1;
        //for (String key : dataBean.getNamePwMap().keySet()) {
            //1: Name, Vorname
        //    ausgabeView.getList().getItems().add(anz + ": " + key + ", " + dataBean.getNamePwMap().get(key));
        //    anz++;
        //}


        //View anzeigen
        ausgabeView.show(dataBean.getPrimaryStage());
    }


    private class backButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            //zur nächsten Seite springen
            EingabeSalesmanVC eingabeVC = new EingabeSalesmanVC(dataBean);
            eingabeVC.show();
        }
    }

    private class sucheButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            //Ausgabe des Salesman

            ManageService manageService = new ManageService();
            int salesmanid = Integer.parseInt(ausgabeView.getSuchEingabetf().getText());

            ausgabeView.getList().getItems().add(manageService.readSalesMan(salesmanid).toString());
        }
    }
}
