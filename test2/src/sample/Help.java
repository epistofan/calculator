package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Help {

    @FXML
    private Button closea;

    static void close(ActionEvent event) {
        System.exit(1);
    }

}

