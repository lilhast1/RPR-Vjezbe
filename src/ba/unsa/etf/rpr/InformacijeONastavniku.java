package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class InformacijeONastavniku extends LicneInformacije implements Informator, MozeOcijeniti {
    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }
    public InformacijeONastavniku() {
        ocjene = new ArrayList<>();
    }
    private String titula;
    private List<Ocjena> ocjene;
    @Override
    public String predstavi() {
        StringBuilder s = new StringBuilder();
        s.append(super.predstavi()).deleteCharAt(s.length());
        return s.append(" " + titula + "\n").toString();
    }
    public void dodajOcjenu(Ocjena o) {
        ocjene.add(o);
    }
    public Ocjena getOcjenta(int indx) {
        return ocjene.get(indx);
    }
    @Override
    public Ocjena ocijeni(int x) {
        return new Ocjena(x, super.getIme(), super.getPrezime());
    }
    public void addOcjena(Ocjena o) {
        ocjene.add(o);
    }
}
