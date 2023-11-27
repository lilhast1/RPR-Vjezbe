public class Pobjednik {
    private Kolekcija kolekcijaImena;
    private final int len;
    private final String ime, prezime;
    public Pobjednik(Kolekcija k) {
        kolekcijaImena = k;
        String[] s = k.getNajduzeIme().split(" ");
        ime = s[0];
        prezime = s[1];
        len = ime.length() + prezime.length() + 1;
    }

    public int getLen() {
        return len;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }
}
