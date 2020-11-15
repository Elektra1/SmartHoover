package org.hbrs.ia.contract;

import javafx.application.Application;
import javafx.stage.Stage;
import org.hbrs.ia.model.DataBean;

import static javafx.application.Application.launch;

public class App extends Application {

    private ManageService manageService;

    public void start(Stage primaryStage) throws Exception {

        DataBean dataBean = new DataBean(primaryStage);

        EingabeVC eingabeVC = new EingabeVC(dataBean);
        eingabeVC.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
