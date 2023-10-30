import java.util.List;
public class Banka {
    private Long brojRacuna;
    private List<Uposlenik> Uposlenici;
    private List<Korisnik> Korisnici;

    public Korisnik kreirajNovogKorisnika(String ime, String prezime) {
        var k = new Korisnik(ime, prezime);
        Korisnici.add(k);
        return k;
    }
    public Uposlenik kreirajNovogUposlenika(String ime, String prezime) {
        var u = new Uposlenik(ime, prezime);
        Uposlenici.add(u);
        return u;    }

    public Racun kreirajRacunZaKorisnika(Korisnik k) {
        if (!Korisnici.contains(k))
            throw new RuntimeException("Nije korisnik nase banke!");
        var r = new Racun(0L, k);
        k.dodajRacun(r);
        return r;
    }
}
