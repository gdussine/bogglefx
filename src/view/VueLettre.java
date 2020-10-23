package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import sample.Boggle;

import javax.swing.*;
import java.io.FileInputStream;
import java.util.Observable;
import java.util.Observer;

public class VueLettre extends GridPane implements Observer {

    Button[][] btns;

    public VueLettre(Boggle boggle){
        btns = new Button[boggle.size()][boggle.size()];
        for(int i = 0; i<boggle.size(); i++){
            for(int j = 0; j < boggle.size(); j++){
                Button btn = new Button();
                btn.setMinSize(50,50);
                btn.setStyle("-fx-background-color: #b0c0FF;-fx-border-color: #5080ca");
                btns[i][j] = btn;
                btn.setText((""+boggle.getLettre(i,j)).toUpperCase());
                this.add(btn, i, j);
                int finalI = i;
                int finalJ = j;
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        boggle.ajouterLettre(finalI, finalJ);
                    }
                });
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
