package ba.unsa.etf.rpr;

public class InformacijeOStudentu extends LicneInformacije implements Informator, MozeOcijeniti {
    private String  godinaStudija, brojIndexa;


    public String getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public String getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }

    @Override
    public String predstavi() {
        return "Ja sam" + super.getIme() + " " + super.getPrezime() + ", student " + godinaStudija + " godine Studija"
                + ", broja indeksa " + brojIndexa + "/n";
    }

    @Override
    public Ocjena ocijeni(int x) {
        return new Ocjena(x, super.getIme(), super.getPrezime());
    }
}
