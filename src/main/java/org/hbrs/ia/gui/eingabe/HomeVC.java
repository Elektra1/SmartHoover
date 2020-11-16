package org.hbrs.ia.gui.eingabe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.hbrs.ia.model.DataBean;

public class HomeVC {

    private Home homeView;
    private DataBean dataBean;


    public HomeVC(DataBean dataBean) {
        this.dataBean = dataBean;
        this.homeView = new Home();

        homeView.getSalesmanButton().setOnAction(new HomeVC.salesmanButtonEventHandler());
        homeView.getPerformanceButton().setOnAction(new HomeVC.performanceButtonEventHandler());
    }

    public void show() {
        homeView.show(dataBean.getPrimaryStage());
    }

    private class salesmanButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            //zur nächsten Seite springen
            EingabeSalesmanVC eingabeVC = new EingabeSalesmanVC(dataBean);
            eingabeVC.show();
        }
    }

    private class performanceButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            EingabePerformanceVC eingabePerformanceVC = new EingabePerformanceVC(dataBean);
            eingabePerformanceVC.show();
        }
    }

}
