package ba.etf.rpr.lv9z2;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class GradoviController {
    public Button btnOk;
    public Button btnCancel;
    public TextField fieldNaziv;
    public TextField fieldBrojStanovnika;
    public ChoiceBox choiceDrzava;
    private GeografijaDAO geografijaDAO;
    private GradFX gradFX;
    public void initialize() throws SQLException, FileNotFoundException {
        gradFX = new GradFX();
        geografijaDAO = GeografijaDAO.getInstance();
        choiceDrzava.setItems(geografijaDAO.getDrzavaFXES());
        fieldNaziv.textProperty().bindBidirectional(gradFX.nazivProperty());
        fieldBrojStanovnika.textProperty().bindBidirectional(gradFX.brojStanovnikaProperty(), new NumberStringConverter());

    }
    public void close(ActionEvent actionEvent) {
        Stage s = (Stage) btnCancel.getScene().getWindow();
        s.close();
    }

    public void update(ActionEvent actionEvent) throws SQLException {
        DrzavaFX drzava =  (DrzavaFX) choiceDrzava.getSelectionModel().getSelectedItem();
        if (geografijaDAO.findGrad(gradFX.getNaziv())) {
            geografijaDAO.izmjeniGrad(new Grad(gradFX.getId(), gradFX.getBrojStanovnika(),
                                 drzava.getId(), gradFX.getNaziv()));
        } else {
            geografijaDAO.dodajGrad(new Grad(gradFX.getId(), gradFX.getBrojStanovnika(),
                    drzava.getId(), gradFX.getNaziv()));
        }
        close(actionEvent);
    }
}
