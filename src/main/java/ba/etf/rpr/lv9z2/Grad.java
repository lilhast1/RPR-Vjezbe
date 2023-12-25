package ba.etf.rpr.lv9z2;



public class Grad {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public int getIdDrzava() {
        return idDrzava;
    }

    public void setIdDrzava(int idDrzava) {
        this.idDrzava = idDrzava;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    private int brojStanovnika;
    private int idDrzava;
    private String naziv;

    public Grad() {
        naziv = "";
        id = 0;
        brojStanovnika = 0;
        idDrzava = 0;
    }


    public Grad(int id, int brojStanovnika, int idDrzava, String naziv) {
        this.id = id;
        this.brojStanovnika = brojStanovnika;
        this.idDrzava = idDrzava;
        this.naziv = naziv;
    }


}

