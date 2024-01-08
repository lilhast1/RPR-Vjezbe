package ba.etf.rpr.lv9z2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DrzavaFX {
    private int id;

    public SimpleIntegerProperty idGlavniGradProperty() {
        return idGlavniGrad;
    }

    public SimpleStringProperty nazivProperty() {
        return naziv;
    }

    private SimpleIntegerProperty idGlavniGrad;
    private SimpleStringProperty naziv;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGlavniGrad() {
        return idGlavniGrad.get();
    }

    public void setIdGlavniGrad(int idGlavniGrad) {
        this.idGlavniGrad.set(idGlavniGrad);
    }

    public String getNaziv() {
        return naziv.get();
    }

    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }

    public DrzavaFX() {
        id = 0;
        idGlavniGrad = new SimpleIntegerProperty();
        naziv = new SimpleStringProperty();
    }

    public DrzavaFX(int id, int idGlavniGrad, String naziv) {
        this.id = id;
        this.idGlavniGrad = new SimpleIntegerProperty(idGlavniGrad);
        this.naziv = new SimpleStringProperty(naziv);
    }
}
