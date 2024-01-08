package ba.etf.rpr.lv9z2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GeografijaApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GlavniController controller = new GlavniController();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("glavna.fxml"));
        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load(), 640, 400);
        stage.setTitle("GeografijaApp");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}