package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.text.TextAlignment;
import sample.Boggle;

import java.util.Observable;
import java.util.Observer;

public class VueInfos extends TilePane implements Observer {

    private Label label;
    private Boggle boggle;

    public VueInfos(Boggle boggle){
        this.boggle = boggle;
        this.label = new Label("Score : "+boggle.getScore()+" - "+boggle.getMotChoisi());
        label.setStyle("-fx-font-size: 26; -fx-text-fill: white");
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(label);
        boggle.addObserver(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        this.label.setText("Score : "+boggle.getScore()+" - "+boggle.getMotChoisi());
    }
}
