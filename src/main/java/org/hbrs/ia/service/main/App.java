package org.hbrs.ia.service.main;

import javafx.application.Application;
import javafx.stage.Stage;
import org.hbrs.ia.control.ManageService;
import org.hbrs.ia.gui.eingabe.HomeVC;
import org.hbrs.ia.model.DataBean;

public class App extends Application {

    private ManageService manageService;

    public void start(Stage primaryStage) throws Exception {

        DataBean dataBean = new DataBean(primaryStage);

        HomeVC homeVC = new HomeVC(dataBean);
        homeVC.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
