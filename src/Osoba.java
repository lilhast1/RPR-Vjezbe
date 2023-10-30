public class Osoba {
    private String ime, prezime;
    public Osoba(String n, String l) {
        ime = n; prezime = l;
    }
    public String toString() {
        return ime + " " + prezime;
    }
}
