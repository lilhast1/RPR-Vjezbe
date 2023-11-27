package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Predmet implements Informator {
    public Predmet() {
        ocjene = new ArrayList<>();
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    private String naziv, opis;

    public Ocjena getOcjena(int i) {
        return ocjene.get(i);
    }

    public void addOcjena(Ocjena ocjene) {
        this.ocjene.add(ocjene);
    }

    private List<Ocjena> ocjene;
    @Override
    public String predstavi() {
        return "Ovo je predmet: " + naziv + " na njemu se radi " + opis + "/n";
    }
}
