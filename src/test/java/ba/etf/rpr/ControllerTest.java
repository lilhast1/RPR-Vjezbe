package ba.etf.rpr;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
class ControllerTest {
    Model model;
    @Start
    public void start(Stage stage) throws IOException {
        model = new Model();
        Controller controller = new Controller(model);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("korisnici_form.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
        stage.setTitle("Korisnici");
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }
    @Test
    void initialize(FxRobot robot) {
        TextField ime = robot.lookup("#imeText").queryAs(TextField.class);
        assertEquals("natasa", ime.getText());
        assertEquals(4, model.getKorisnici().size());
    }

    @Test
    void end(FxRobot robot) {
        Button endBtn = robot.lookup("#krajBtn").queryAs(Button.class);
        robot.clickOn("#krajBtn");
    }

    @Test
    void add(FxRobot robot) {
        TextField ime = robot.lookup("#imeText").queryAs(TextField.class);
        robot.clickOn("#addBtn");
        robot.clickOn("#imeText");
        robot.write("anon");
        robot.clickOn("#prezimeText");
        robot.write("anonovic");
        robot.clickOn("#addBtn");
        assertEquals("", ime.getText());
    }

    @Test
    void select(FxRobot robot) {
        robot.clickOn("#addBtn");
        robot.clickOn("#imeText");
        robot.write("anon");
        robot.clickOn("#prezimeText");
        robot.write("anonovic");
        robot.clickOn("#addBtn");
        assertEquals("anon anonovic", model.getKorisnici().get(model.getKorisnici().size() - 2).toString());

    }
}