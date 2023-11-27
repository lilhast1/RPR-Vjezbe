package ba.unsa.etf.rpr;

public class LicneInformacije implements Informator{
    private String ime, prezime;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String predstavi() {
        return "Moje ime je " + ime + " " + prezime + "/n";
    }
}
