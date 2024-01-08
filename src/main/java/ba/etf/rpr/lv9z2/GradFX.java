package ba.etf.rpr.lv9z2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class GradFX {
    private SimpleIntegerProperty id;

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleIntegerProperty brojStanovnikaProperty() {
        return brojStanovnika;
    }

    public SimpleStringProperty idDrzavaProperty() {
        return idDrzava;
    }

    public SimpleStringProperty nazivProperty() {
        return naziv;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set( id);
    }

    public int getBrojStanovnika() {
        return brojStanovnika.get();
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika.set(brojStanovnika);
    }

    public String getIdDrzava() {
        return idDrzava.get();
    }

    public void setIdDrzava(String idDrzava) {
        this.idDrzava.set( idDrzava);
    }

    public String getNaziv() {
        return naziv.get();
    }

    public void setNaziv(String naziv) {
        this.naziv.set( naziv);
    }

    private SimpleIntegerProperty brojStanovnika;
    private SimpleStringProperty idDrzava;
    private SimpleStringProperty naziv;

    public GradFX() {
        naziv = new SimpleStringProperty();
        id = new SimpleIntegerProperty();
        brojStanovnika = new SimpleIntegerProperty();
        idDrzava = new SimpleStringProperty();
    }


    public GradFX(int id, String naziv, int brojStanovnika, String Drzava) {
        this.id = new SimpleIntegerProperty( id);
        this.brojStanovnika =  new SimpleIntegerProperty( brojStanovnika);
        this.idDrzava = new SimpleStringProperty(Drzava);
        this.naziv = new SimpleStringProperty(naziv);
    }
    @Override
    public String toString() {
        return getNaziv();
    }
}
