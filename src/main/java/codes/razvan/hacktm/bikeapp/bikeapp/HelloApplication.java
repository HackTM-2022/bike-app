package codes.razvan.hacktm.bikeapp.bikeapp;

import codes.razvan.hacktm.bikeapp.bikeapp.responses.PingResponse;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.SneakyThrows;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class HelloApplication extends Application {

    public static String firstName, lastName, email, bike_token;
    private static Stage stage;
    private static Internet internet;

    public static void main(String[] args) {
        TokenPersister.load();
        launch();
    }

    @SneakyThrows
    public static void changeScene(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setFullScreen(true);
    }

    public static double randomDouble(double low, double high) {
        Random r = new Random();
        return low + (high - low) * r.nextDouble();
    }

    public static int randomInt(int low, int high){
        return new Random().nextInt(high - low + 1) + low;
    }

    @SneakyThrows
    @Override
    public void start(Stage _stage) {
        stage = _stage;

        changeScene("hello-view.fxml");

        internet = new UnirestInternet();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            String lastJob = "done";

            @Override
            public void run() {
                Platform.runLater(() -> {
                    PingResponse response = internet.ping();
                    if (response.getStatus().equals("done") && !lastJob.equals("done")) {
                        bike_token = UUID.randomUUID().toString();
                        changeScene("hello-view.fxml");
                    } else if (response.getStatus().equals("job") && !lastJob.equals("job")) {
                        firstName = response.getFirst_name();
                        lastName = response.getLast_name();
                        email = response.getEmail();
                        changeScene("riding.fxml");
                    }
                    lastJob = response.getStatus();
                });
            }
        }, 0, 5000);

        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);

        stage.setFullScreen(true);
        stage.show();
    }
}

