package org.hbrs.ia.gui.ausgabe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.hbrs.ia.gui.eingabe.EingabePerformanceVC;
import org.hbrs.ia.control.ManageService;
import org.hbrs.ia.model.DataBean;

public class AusgabePerformanceVC {

    private DataBean dataBean;
    private AusgabePerformanceView ausgabeView;

    public AusgabePerformanceVC(DataBean dataBean) {
        this.dataBean = dataBean;
        this.ausgabeView = new AusgabePerformanceView();

        //EventHandler registrieren
        ausgabeView.getBackButton().setOnAction(new AusgabePerformanceVC.sucheButtonEventHandler());
        ausgabeView.getBackButton().setOnAction(new AusgabePerformanceVC.backButtonEventHandler());
    }

    public void show() {
        //View anzeigen
        ausgabeView.show(dataBean.getPrimaryStage());
    }

    private class backButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            //zur nächsten Seite springen
            EingabePerformanceVC eingabeVC = new EingabePerformanceVC(dataBean);
            eingabeVC.show();
        }
    }

    private class sucheButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            //Ausgabe des Performance Records
            ManageService manageService = new ManageService();
            int performanceid = Integer.parseInt(ausgabeView.getSuchEingabetf().getText());
            System.out.println(manageService.readEvaluationRecords(performanceid));

            ausgabeView.getList().getItems().add(manageService.readEvaluationRecords(performanceid).toString());
        }

    }
}
