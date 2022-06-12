package codes.razvan.hacktm.bikeapp.bikeapp;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.UUID;

public class HelloController {

    @FXML
    public ImageView qr;
    private Internet internet;

    @FXML
    public void initialize() {
        internet = new UnirestInternet();
        if (HelloApplication.bike_token == null) {
            HelloApplication.bike_token = UUID.randomUUID().toString();
        }
        internet.ping(HelloApplication.bike_token);
        Image image = SwingFXUtils.toFXImage(QRGenerator.generate(HelloApplication.bike_token, 900, 900), null);
        qr.setImage(image);
    }
}