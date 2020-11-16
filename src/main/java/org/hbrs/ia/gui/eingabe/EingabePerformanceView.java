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

import java.util.Date;

public class EingabePerformanceView {

    private Scene scene;

    private GridPane grid;
    private Text scenetitle;

    private Label salesmanId;
    private TextField salesmanIdtf;

    private Label description;
    private TextField descriptiontf;

    private Label totalsales;
    private TextField totalsalestf;

    private Label bonus;
    private TextField bonustf;

    private Label ranking;
    private TextField rankingtf;

    private Label socialranking;
    private TextField socialrankingtf;

    private Label year;         //ToDo: year!
    private TextField yeartf;

    private Label id;
    private TextField idtf;

    private Text meldungT;

    private Button alleButton;
    private Button addButton;
    private Button backButton;
    private HBox hbButton;

    public EingabePerformanceView() {
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

        //Salesman ID
        salesmanId = new Label("Salesman ID");
        grid.add(salesmanId, 0, 1);

        salesmanIdtf = new TextField();
        grid.add(salesmanIdtf, 1, 1);

        //Description
        description = new Label("Description");
        grid.add(description, 0, 2);

        descriptiontf = new TextField();
        grid.add(descriptiontf, 1, 2);

        //Totalsales
        totalsales = new Label("Totalsales");
        grid.add(totalsales, 0, 3);

        totalsalestf = new TextField();
        grid.add(totalsalestf, 1, 3);

        //Bonus
        bonus = new Label("Bonus");
        grid.add(bonus, 0, 4);

        bonustf = new TextField();
        grid.add(bonustf, 1, 4);

        //Ranking
        ranking = new Label("Ranking");
        grid.add(ranking, 0, 5);

        rankingtf = new TextField();
        grid.add(rankingtf, 1, 5);

        //Socialranking
        socialranking = new Label("Socialranking");
        grid.add(socialranking, 0, 6);

        socialrankingtf = new TextField();
        grid.add(socialrankingtf, 1, 6);

        //Year
        year = new Label("Year");
        grid.add(year, 0, 7);

        yeartf = new TextField();
        grid.add(yeartf, 1, 7);

        //id
        id = new Label("Id");
        grid.add(id, 0, 8);

        idtf = new TextField();
        grid.add(idtf, 1, 8);

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
        grid.add(hbButton, 1, 9);

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

    public TextField getSalesmanIdtf() {
        return salesmanIdtf;
    }

    public TextField getDescriptiontf() {
        return descriptiontf;
    }

    public TextField getTotalsalestf() {
        return totalsalestf;
    }

    public TextField getBonustf() {
        return bonustf;
    }

    public TextField getRankingtf() {
        return rankingtf;
    }

    public TextField getSocialrankingtf() {
        return socialrankingtf;
    }

    public TextField getYeartf() {
        return yeartf;
    }

    public TextField getIdtf() {
        return idtf;
    }

    public Text getMeldungT() {
        return meldungT;
    }

    public Button getBackButton() {
        return backButton;
    }

    public Button getAlleButton() {
        return alleButton;
    }

    public Button getAddButton() {
        return addButton;
    }

}
