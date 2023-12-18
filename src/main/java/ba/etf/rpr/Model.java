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
    public void napuni() {
        korisnici.add(new Korisnik("tarik","hastor","thastor1@etf.unsa.ba","lilhast1","sifra"));
        korisnici.add(new Korisnik("jasmin","fazlagic","imperia@gmail.com","jalabrat","123456"));
        korisnici.add(new Korisnik("amar","hodzic","ahodzic1@gmail.com","bubacorelli","sifra2"));
        korisnici.add(new Korisnik("natasa","bekvalac","nikotin@gmail.com","nbekvlc","sifra"));
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
