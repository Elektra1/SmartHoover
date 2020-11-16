package org.hbrs.ia.gui.eingabe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Home {

    private Scene scene;

    private GridPane grid;
    private Text scenetitle;

    private Button salesmanButton;
    private Button performanceButton;
    private HBox hbButton;

    public Home() {
        //Layout
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(50,50,50,50));

        //Ueberschrift
        scenetitle = new Text("Was wollen Sie bearbeiten?");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        //Button
        salesmanButton = new Button("Salesman");

        performanceButton = new Button("Performance Record");

        //Buttongruppe
        hbButton = new HBox(10);
        hbButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbButton.getChildren().add(salesmanButton);
        hbButton.getChildren().add(performanceButton);
        grid.add(hbButton, 1, 4);

        scene = new Scene(grid, 300, 300);

    }

    public void show(Stage stage) {
        stage.setTitle("Auswahl Daten");
        stage.setScene(scene);
        stage.show();
    }

    public Button getSalesmanButton() {
        return salesmanButton;
    }

    public Button getPerformanceButton() {
        return performanceButton;
    }
}
