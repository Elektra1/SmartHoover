package org.hbrs.ia.gui.ausgabe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AusgabePerformanceView {

    private Scene scene;

    private GridPane grid;
    private Text scenetitle;

    private ListView<String> list;

    private Label suchEingabe;
    private TextField suchEingabetf;

    private Button sucheButton;
    private Button backButton;
    private HBox hbButton;

    public AusgabePerformanceView() {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Ueberschrift
        scenetitle = new Text("Suche Performance Record");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        //Salesman ID
        suchEingabe = new Label("Bitte geben Sie eine ID ein:");
        grid.add(suchEingabe, 0, 1);

        suchEingabetf = new TextField();
        grid.add(suchEingabetf, 1, 1);

        //suche-Button
        backButton = new Button("Suchen");
        grid.add(backButton, 2,1);

        //Liste
        list = new ListView<String>();
        list.setMinWidth(400);
        grid.add(list, 0, 2);

        //zurück-Button
        backButton = new Button("zurück");
        grid.add(backButton, 0,3);

        //Buttongruppe
        hbButton = new HBox(10);
        hbButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbButton.getChildren().add(backButton);
        grid.add(hbButton, 0, 2);

        scene = new Scene(grid, 300, 200);
    }

    public void show(Stage stage) {
        stage.setTitle("Übersicht Verkäufer");
        stage.setScene(scene);
        stage.show();
    }

    public TextField getSuchEingabetf() {
        return suchEingabetf;
    }

    public ListView<String> getList() {
        return list;
    }

    public Button getBackButton() {
        return backButton;
    }
}
