package org.hbrs.ia.contract;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.hbrs.ia.model.DataBean;

public class AusgabeVC {

    private DataBean dataBean;
    private AusgabeView ausgabeView;

    public AusgabeVC(DataBean dataBean) {
        this.dataBean = dataBean;
        this.ausgabeView = new AusgabeView();

        //EventHandler registrieren
        ausgabeView.getBackButton().setOnAction(new backButtonEventHandler());
    }

    public void show() {
        //View mit Daten befüllen
        int anz = 1;
        for (String key : dataBean.getNamePwMap().keySet()) {
            //1: Name, Vorname
            ausgabeView.getList().getItems().add(anz + ": " + key + ", " + dataBean.getNamePwMap().get(key));
            anz++;
        }

        //View anzeigen
        ausgabeView.show(dataBean.getPrimaryStage());
    }

    private class backButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            //zur nächsten Seite springen
            //EndeVC
        }
    }
}
