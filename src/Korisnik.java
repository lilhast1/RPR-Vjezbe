public class Korisnik extends Osoba {
    public Racun racun;
    public Korisnik(String a, String b) {
        super(a, b);
    }
    public void dodajRacun(Racun r) {
        racun = r;
    }
}
