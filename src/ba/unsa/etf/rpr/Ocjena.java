package ba.unsa.etf.rpr;

public class Ocjena {
    LicneInformacije osoba;
    int ocjena;

    public Ocjena(int x, String ime, String prezime) {
        osoba = new LicneInformacije();
        osoba.setIme(ime);
        osoba.setPrezime(prezime);
        ocjena = x;
    }
    public LicneInformacije getOsoba() {
        return osoba;
    }

    public void setOsoba(LicneInformacije osoba) {
        this.osoba = osoba;
    }

    public int getOcjena() {
        return ocjena;
    }

    public void setOcjena(int ocjena) throws Exception {
        var x = ocjena > 0 ? ocjena <= 10 ? ocjena : -1 : -1;
        if (ocjena < 0)
            throw new Exception("Losa ocjena");
        this.ocjena = x;
    }
}
