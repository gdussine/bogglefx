package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import view.VueControle;
import view.VueInfos;
import view.VueLettre;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #000000");
        Boggle boggle = new Boggle(6);
        VueLettre vueLettre = new VueLettre(boggle);
        VueInfos vueInfos = new VueInfos(boggle);
        VueControle vueControle = new VueControle(boggle);
        root.setCenter(vueLettre);
        root.setBottom(vueInfos);
        root.setRight(vueControle);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 450, 450));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
