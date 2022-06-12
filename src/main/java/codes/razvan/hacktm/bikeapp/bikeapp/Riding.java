package codes.razvan.hacktm.bikeapp.bikeapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Riding implements Initializable {

    @FXML
    private Label first_name;

    @FXML
    private Label last_name;

    @FXML
    private Label email;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        first_name.setText(HelloApplication.firstName);
        last_name.setText(HelloApplication.lastName);
        email.setText(HelloApplication.email);
    }
}
