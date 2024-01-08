package ba.etf.rpr.lv9z2;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class GlavniController {
    public TableView<GradFX> tableViewGradovi;
    public GeografijaDAO geografijaDAO;
    public TableColumn<GradFX, Integer> colGradId;
    public TableColumn<GradFX, String> colGradNaziv;
    public TableColumn<GradFX, Integer> colGradStanovnika;
    public TableColumn<GradFX, String> colGradDrzava;
    public ObservableList<GradFX> gradFXES;
    @FXML
    private Label welcomeText;
    @FXML
    public void initialize() throws SQLException, FileNotFoundException {
        geografijaDAO = GeografijaDAO.getInstance(); // drzim model
       // geografijaDAO.reset();
        colGradId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colGradNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        colGradStanovnika.setCellValueFactory(new PropertyValueFactory<>("brojStanovnika"));
        colGradDrzava.setCellValueFactory(new PropertyValueFactory<>("idDrzava"));
        gradFXES = geografijaDAO.getGradFXES();
        tableViewGradovi.setItems(gradFXES); // table vezem za bazu
        // zavrseno vezanje baza<->tableview
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void dodajDrzavu(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        DrzavaController controller = new DrzavaController();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("drzava.fxml"));
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 300, 100);
        stage.setTitle("Drzava");
        stage.setScene(scene);
        stage.show();
    }

    public void gradAkcija(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        GradoviController controller = new GradoviController();
        controller.setGradovi(gradFXES);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gradovi.fxml"));
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 300, 100);
        stage.setTitle("Gradovi");
        stage.setScene(scene);
        stage.show();
    }

}