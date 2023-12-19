package ba.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void getKorisnici() {
        Model m = new Model();
        m.napuni();
        assertEquals("natasa", m.getCurr().getIme());
    }

    @Test
    void napuni() {
        Model m = new Model();
        m.napuni();
        assertEquals("tarik hastor", m.getKorisnici().get(0).toString());
        assertEquals("jasmin fazlagic", m.getKorisnici().get(1).toString());
        assertEquals("amar hodzic", m.getKorisnici().get(2).toString());
        assert("natasa bekvalac".equals(m.getKorisnici().get(3).toString()));
    }

    @Test
    void add() {
        Model m = new Model();
        m.add(new Korisnik("lamija", "borovina", "lamsi@gmail", "lamsi", "sifra"));
        assertEquals("lamija", m.getCurr().getIme());

    }

    @Test
    void find() {
        Model m = new Model();
        m.napuni();
        m.find(m.getKorisnici().get(1));
        assertEquals("jasmin fazlagic", m.getCurr().toString());
    }
}