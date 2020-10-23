package view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import sample.Boggle;

import java.util.Observable;
import java.util.Observer;

public class VueControle extends VBox implements Observer {

    private Boggle boggle;
    private Button btnValider, btnEffacer, btnQuitter;
    private TextArea listeDejaChoisis;
    private String text = "MOTS :";

    public VueControle(Boggle boggle){
        this.boggle = boggle;
        btnValider = new Button("Valider");
        btnEffacer = new Button("Effacer");
        btnQuitter = new Button("Quitter");
        listeDejaChoisis = new TextArea(text);
        btnEffacer.setMinWidth(80);
        btnValider.setMinWidth(80);
        btnQuitter.setMinWidth(80);
        listeDejaChoisis.setMaxSize(80,300);
        listeDejaChoisis.setEditable(false);
        this.getChildren().add(btnValider);
        this.getChildren().add(btnEffacer);
        this.getChildren().add(btnQuitter);
        this.getChildren().add(listeDejaChoisis);
        boggle.addObserver(this);
        btnValider.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boggle.valider();
                boggle.effacer();
            }
        });
        btnEffacer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boggle.effacer();
            }
        });
        btnQuitter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(boggle.getMotsDejaChoisis());
        String res = text;
        for(String mot : boggle.getMotsDejaChoisis()){
            res+="\n"+mot;
        }
        listeDejaChoisis.setText(res);
    }
}
