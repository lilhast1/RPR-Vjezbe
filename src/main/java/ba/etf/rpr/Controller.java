package ba.etf.rpr;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {
    public Button krajBtn;
    public ListView<Korisnik> userList;
    public Button addBtn;
    public PasswordField lozinkaText;
    public TextField usernameText;
    public TextField mailText;
    public TextField prezimeText;
    public TextField imeText;
    @FXML
    private Label welcomeText;
    private Model model;
    public Controller(Model model) {
        this.model = model;
    }
    @FXML
    public void initialize() {
        imeText.textProperty().bindBidirectional(model.getCurr().imeProperty());
        userList.setItems(model.getKorisnici());
        //userList.itemsProperty().bind(model.getKorisnici());
        System.out.println("OK");
        userList.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> model.setCurr(newSelection)
        );
        model.currProperty().addListener(
                (obs, prev, next) -> {
                    if (prev != null) {
                        imeText.textProperty().unbindBidirectional(prev.imeProperty());
                        prezimeText.textProperty().unbindBidirectional(prev.prezimeProperty());
                        mailText.textProperty().unbindBidirectional(prev.emailProperty());
                        lozinkaText.textProperty().unbindBidirectional(prev.lozinkaProperty());
                        usernameText.textProperty().unbindBidirectional(prev.userNameProperty());
                    } else {
                        System.out.println("prev je null");
                    }
                    if (next != null) {
                        imeText.textProperty().bindBidirectional(next.imeProperty());
                        prezimeText.textProperty().bindBidirectional(next.prezimeProperty());
                        mailText.textProperty().bindBidirectional(next.emailProperty());
                        lozinkaText.textProperty().bindBidirectional(next.lozinkaProperty());
                        usernameText.textProperty().bindBidirectional(next.userNameProperty());
                    } else {
                        //next = new Korisnik();
                        imeText.setText("");
                        prezimeText.setText("");
                        mailText.setText("");
                        lozinkaText.setText("");
                        usernameText.setText("");
                    }
                    userList.refresh();
                }
        );
        userList.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldKorisnik, newKorisnik) -> {
                    model.setCurr(newKorisnik);
                    userList.refresh();
        });
        model.napuni();
        //model.setCurr(new Korisnik());
    }

    public void end(ActionEvent actionEvent) {
        Stage s  = (Stage) krajBtn.getScene().getWindow();
        s.close();
    }

    public void add(ActionEvent actionEvent) {
        //model.setCurr(userList.getSelectionModel().getSelectedItem());
        model.add(new Korisnik());
        userList.refresh();
        userList.getSelectionModel().select(model.getCurr());
        //model.setCurr(new Korisnik());
    }

    public void select(MouseEvent mouseEvent) {
        model.find(userList.getSelectionModel().getSelectedItem());
        userList.refresh();
    }
    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }
}