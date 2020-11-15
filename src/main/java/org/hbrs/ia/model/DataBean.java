package org.hbrs.ia.model;

import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class DataBean {

    private Stage primaryStage = null;

    private Map<String, String> namePwMap = null;

    public DataBean(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.namePwMap = new HashMap<String, String>();
    }

    public Map<String, String> getNamePwMap() {
        return namePwMap;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

}
