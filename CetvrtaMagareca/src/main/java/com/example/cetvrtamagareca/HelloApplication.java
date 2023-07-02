package com.example.cetvrtamagareca;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    private Reader reader = new Reader("C:\\Users\\Admin\\Documents\\IdeaProjects\\CetvrtaMagareca\\src\\main\\java\\com\\example\\cetvrtamagareca\\txt\\muskarci.txt",
            "C:\\Users\\Admin\\Documents\\IdeaProjects\\CetvrtaMagareca\\src\\main\\java\\com\\example\\cetvrtamagareca\\txt\\zene.txt",
            "C:\\Users\\Admin\\Documents\\IdeaProjects\\CetvrtaMagareca\\src\\main\\java\\com\\example\\cetvrtamagareca\\txt\\tereni.txt");
    private ObservableList<Igrac> igraci = reader.ucitajIgrace();

    private ObservableList<Teren> tereni = reader.ucitajTerene();

    public HelloApplication() throws FileNotFoundException {
    }




    @Override
    public void start(Stage stage) throws IOException {
        TextField textField = new TextField();
        CheckBox muskiCheckBox = new CheckBox("M");
        CheckBox zenskiCheckBox = new CheckBox("Z");
        Button filterButton = new Button("Filtriraj");

        HBox filteri = new HBox(50, textField, filterButton, muskiCheckBox, zenskiCheckBox);
        ListView<Igrac> Viewigrac = new ListView<>(igraci);
        VBox igraciIFilteri = new VBox(20, filteri, Viewigrac);

        filterButton.setOnAction(Event->{
            Viewigrac.setItems(reader.filteriraj(textField.getText(),muskiCheckBox.isSelected(),zenskiCheckBox.isSelected()));
        });


        Button kreirajMec = new Button("Kreiraj Mec");
        Button dodajIgrace = new Button("Dodaj igrace");
        VBox buttons = new VBox(100, kreirajMec, dodajIgrace);
        buttons.setPadding(new Insets(100, 0, 0, 0));

        ListView<Teren> terenListView = new ListView<>(tereni);






        HBox gornjiDeo = new HBox(50, igraciIFilteri, buttons, terenListView);

        TableView<Mec> mecTableView = new TableView<>();

        TableColumn<Mec, String> teren = new TableColumn<>("teren");
        TableColumn<Mec, String> termini = new TableColumn<>("termin");

        TableColumn<Mec, Igrac[]> prviTim = new TableColumn<>("Prvi Tim");
        TableColumn<Mec, Igrac[]> drugiTim = new TableColumn<>("Drugi Tim");
        mecTableView.getColumns().setAll(teren, termini, prviTim, drugiTim);

        VBox celo = new VBox(gornjiDeo, mecTableView);

        BorderPane root = new BorderPane();
        root.setCenter(celo);
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Teniski Turnir");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}