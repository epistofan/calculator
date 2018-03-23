package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by busja on 2017.05.11..
 */

public class popup {




    public static void alert(String title, String message) {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Label esj = new Label(message);

        esj.setAlignment(Pos.CENTER);
        //esj.setText("");


        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(esj);
        Scene scene = new Scene(layout, 200, 50);

        window.setScene(scene);
        window.show();
    }
}