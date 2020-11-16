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

public class AusgabeSalesmanView {

    private Scene scene;

    private GridPane grid;
    private Text scenetitle;

    private ListView<String> list;

    private Label suchEingabe;
    private TextField suchEingabetf;

    private Button sucheButton;

    private Button backButton;
    private HBox hbButton;

    public AusgabeSalesmanView() {              //ToDo: Salesman id eingeben, dann erscheint er auf dem Bildschirm (read), dadrunter 2 Button: update, delete
        grid = new GridPane();                  //ToDo: draufklicken der Button update: neues Fenster öffnen und die alten Werte können dann verändert werden
        grid.setAlignment(Pos.CENTER);          //ToDo: Button delete: Salesman bei read auswählen und dann wird er aus der DB gelöscht, Meldung: Salesman id wurde gelöscht
        grid.setHgap(10);                       //ToDo neue Fenster: update
        grid.setVgap(10);
        grid.setPadding(new Insets(50, 50, 50, 50));

        //Ueberschrift
        scenetitle = new Text("Suche Verkäufer");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        //Performance ID
        suchEingabe = new Label("Bitte geben Sie eine ID ein:");
        grid.add(suchEingabe, 0, 1);

        suchEingabetf = new TextField();
        grid.add(suchEingabetf, 1, 1);

        //suche-Button
        sucheButton = new Button("Suchen");
        grid.add(sucheButton, 2,1);

        //Liste
        list = new ListView<String>();
        list.setMinWidth(400);
        grid.add(list, 0, 2);

        //Button
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

    public ListView<String> getList() {
        return list;
    }

    public TextField getSuchEingabetf() {
        return suchEingabetf;
    }

    public Button getSucheButton() {
        return sucheButton;
    }

    public Button getBackButton() {
        return backButton;
    }
}
