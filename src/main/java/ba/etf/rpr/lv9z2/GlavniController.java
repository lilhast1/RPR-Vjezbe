package ba.etf.rpr.lv9z2;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class GlavniController {
    public TableView tableViewGradovi;
    public GeografijaDAO geografijaDAO;
    public ObservableList<GradFX> rez
    @FXML
    private Label welcomeText;
    @FXML
    public void initialize() throws SQLException, FileNotFoundException {
        geografijaDAO = GeografijaDAO.getInstance();
        tableViewGradovi.setItems(geografijaDAO.getDrzave());
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}