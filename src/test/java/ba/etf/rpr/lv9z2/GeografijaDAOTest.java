package ba.etf.rpr.lv9z2;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class GeografijaDAOTest {

    @Test
    void getInstance() throws SQLException, FileNotFoundException {
        GeografijaDAO g = GeografijaDAO.getInstance();
        GeografijaDAO b = GeografijaDAO.getInstance();
        assertEquals(g, b);
    }

    @Test
    void obrisiDrzavu() throws SQLException, FileNotFoundException {
        GeografijaDAO g = GeografijaDAO.getInstance();
        g.obrisiDrzavu("UK");
        assertEquals(null, g.nadjiDrzavu("UK"));
    }

    @Test
    void dodajGrad() throws SQLException, FileNotFoundException {
        GeografijaDAO g  = GeografijaDAO.getInstance();
        g.dodajGrad(new Grad(5, 275524, 1, "Sarajevo"));
        new Main();
        assert(Main.ispisiGradove().contains("Sarajevo"));
    }

    @Test
    void dodajDrzavu() throws SQLException, FileNotFoundException {
        GeografijaDAO g  = GeografijaDAO.getInstance();
        g.dodajDrzavu(new Drzava(4, 1, "Bosna i Hercegovina"));
        assertEquals("Bosna i Hercegovina", g.nadjiDrzavu("Bosna i Hercegovina").getNaziv());
    }

    @Test
    void izmjeniGrad() throws SQLException, FileNotFoundException {
        GeografijaDAO g = GeografijaDAO.getInstance();
        g.izmjeniGrad(new Grad(1, 1000000, 1, "Paris"));
        new Main();
        assert(Main.ispisiGradove().contains("Paris"));
    }

    @Test
    void nadjiDrzavu() throws SQLException, FileNotFoundException {
        GeografijaDAO g = GeografijaDAO.getInstance();
        assertEquals("Francuska", g.nadjiDrzavu("Francuska").getNaziv());
    }
}