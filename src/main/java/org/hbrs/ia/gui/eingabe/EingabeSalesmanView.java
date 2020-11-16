package org.hbrs.ia.gui.eingabe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class EingabeSalesmanView {

    private Scene scene;

    private GridPane grid;
    private Text scenetitle;

    private Label vorname;
    private TextField vornametf;

    private Label nachname;
    private TextField nachnametf;

    private Label id;
    private TextField idtf;

    private Text meldungT;

    private Button alleButton;
    private Button addButton;
    private Button backButton;
    private HBox hbButton;

    public EingabeSalesmanView() {
        //Layout
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        //Ueberschrift
        scenetitle = new Text("Bitte geben Sie alle Daten ein.");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        //Vorname
        vorname = new Label("Vorname");
        grid.add(vorname, 0, 1);

        vornametf = new TextField();
        grid.add(vornametf, 1, 1);

        //Nachname
        nachname = new Label("Nachname");
        grid.add(nachname, 0, 2);

        nachnametf = new TextField();
        grid.add(nachnametf, 1, 2);

        //id
        //ToDo Eingabe id
        id = new Label("Id");
        grid.add(id, 0, 3);

        idtf = new TextField();
        grid.add(idtf, 1, 3);

        //Button
        addButton = new Button("Eintragen");

        alleButton = new Button("Suche");

        backButton = new Button("zurück");

        //Buttongruppe
        hbButton = new HBox(10);
        hbButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbButton.getChildren().add(addButton);
        hbButton.getChildren().add(alleButton);
        hbButton.getChildren().add(backButton);
        grid.add(hbButton, 1, 4);

        //Meldung
        meldungT = new Text();
        grid.add(meldungT, 1, 6);

        scene = new Scene(grid, 300, 300);
    }

    public void show(Stage stage) {
        stage.setTitle("Salesman eingeben");
        stage.setScene(scene);
        stage.show();
    }

    public TextField getVornametf() {
        return vornametf;
    }

    public TextField getNachnametf() {
        return nachnametf;
    }

    public TextField getIdtf() {
        return idtf;
    }

    public Text getMeldungT() {
        return meldungT;
    }

    public Button getAlleButton() {
        return alleButton;
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getBackButton() {
        return backButton;
    }
}
