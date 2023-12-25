package ba.etf.rpr.lv9z2;

public class Drzava {
    private int id, idGlavniGrad;
    private String naziv;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGlavniGrad() {
        return idGlavniGrad;
    }

    public void setIdGlavniGrad(int idGlavniGrad) {
        this.idGlavniGrad = idGlavniGrad;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Drzava() {
        id = 0;
        idGlavniGrad = 0;
        naziv = "";
    }

    public Drzava(int id, int idGlavniGrad, String naziv) {
        this.id = id;
        this.idGlavniGrad = idGlavniGrad;
        this.naziv = naziv;
    }
}

