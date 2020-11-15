package org.hbrs.ia.contract;

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

public class AusgabeView {

    private Scene scene;

    private GridPane grid;
    private Text scenetitle;

    private ListView<String> list;

    private Button backButton;
    private HBox hbButton;

    public AusgabeView() {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Ueberschrift
        scenetitle = new Text("Bitte geben Sie alle Daten ein.");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        //Liste
        list = new ListView<String>();
        list.setMinWidth(200);
        grid.add(list, 0, 1);

        //Button
        backButton = new Button("zurück");

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

    public ListView<String> getList() {
        return list;
    }

    public Button getBackButton() {
        return backButton;
    }
}
