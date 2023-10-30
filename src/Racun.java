public class Racun {
    private   Long brojRacuna;
    private Osoba korisnikRacuna;
    private boolean odobrenjePrekoracenja;
    private Double stanjeRacuna;
    public Racun(Long x, Osoba o) {
        brojRacuna = x;
        korisnikRacuna = o;
    }

    public Long getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(Long brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Osoba getKorisnikRacuna() {
        return korisnikRacuna;
    }

    public void setKorisnikRacuna(Osoba korisnikRacuna) {
        this.korisnikRacuna = korisnikRacuna;
    }

    public boolean isOdobrenjePrekoracenja() {
        return odobrenjePrekoracenja;
    }

    public void odobriPrekoracenje(Double odobrenjePrekoracenja) {
        this.odobrenjePrekoracenja = true;
    }

    public Double getStanjeRacuna() {
        return stanjeRacuna;
    }

    public void izvrsiUplatu(Double stanjeRacuna) {
        this.stanjeRacuna += stanjeRacuna;
    }

    public boolean provjeriOdobrenjePrekoracenja(Double x) {
        return odobrenjePrekoracenja;
    }

    public boolean izvrsiIsplatu(Double x) {
        if (stanjeRacuna - x < 0) {
            return false;
        }
        stanjeRacuna -= x;
        return true;
    }

}
