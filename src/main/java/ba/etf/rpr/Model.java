package ba.etf.rpr;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
    private ObservableList<Korisnik> korisnici;
    private SimpleObjectProperty<Korisnik> curr;
    public Model() {
        korisnici = FXCollections.observableArrayList();
        curr = new SimpleObjectProperty<Korisnik>(new Korisnik());
    }
    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getCurr() {
        return curr.get();
    }

    public SimpleObjectProperty<Korisnik> currProperty() {
        return curr;
    }

    public void setCurr(Korisnik curr) {
        this.curr.set(curr);
    }
    public void add(Korisnik k) {

            korisnici.add(k);
    }

    public void find(Korisnik k) {
        int i;
        for (i = 0; i < korisnici.size(); i++)
            if (korisnici.get(i).equals(k))
                break;
        curr.set( korisnici.get(i));
    }
}
