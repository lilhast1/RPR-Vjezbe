package ba.etf.rpr.lv9z2;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class DrzavaController {
    public TextField fieldNaziv;
    public ChoiceBox choiceGrad;
    public Button btnOk;
    public Button btnCancel;
    private DrzavaFX drzavaFX;
    private GeografijaDAO geografijaDAO;
    public void initialize() throws SQLException, FileNotFoundException {
        geografijaDAO = GeografijaDAO.getInstance();
        drzavaFX = new DrzavaFX();
        fieldNaziv.textProperty().bindBidirectional(drzavaFX.nazivProperty());
        choiceGrad.setItems(geografijaDAO.gradoviFX());
    }

    public void close(ActionEvent actionEvent) {
        Stage s = (Stage) btnCancel.getScene().getWindow();
        s.close();
    }

    public void update(ActionEvent actionEvent) throws SQLException {
        GradFX g = (GradFX) choiceGrad.getSelectionModel().getSelectedItem();
        geografijaDAO.dodajDrzavu(new Drzava(drzavaFX.getId(), g.getId(), drzavaFX.getNaziv()));
        close(actionEvent);
    }
}
