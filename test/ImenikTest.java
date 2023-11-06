import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {

    @Test
    void naSlovo() {
        Imenik imenik = new Imenik();
        FiksniBroj f = new FiksniBroj(Grad.SARAJEVO, "221-158");
        imenik.dodaj("Faruk", f);
        f = new FiksniBroj(Grad.BIHAC, "222-558");
        imenik.dodaj("Izet", f);
        MobilniBroj m = new MobilniBroj(62, "556-443");
        imenik.dodaj("Fata", m);
        assertEquals("""
1.Faruk - 033/221-158
2.Fata - 062/556-443
""", imenik.naSlovo('F'));
    }

    @Test
    void izGrada() {
        FiksniBroj f = new FiksniBroj(Grad.SARAJEVO, "710-000");
        Imenik imenik = new Imenik();
        imenik.dodaj("Azra", f);
        f = new FiksniBroj(Grad.BIHAC, "111-111");
        imenik.dodaj("Mirza", f);
        f = new FiksniBroj(Grad.MOSTAR, "222-222");
        imenik.dodaj("Maja", f);
        f = new FiksniBroj(Grad.MOSTAR, "333-333");
        imenik.dodaj("Zdravko Maminjo Mamic", f);
        var g = imenik.izGrada(Grad.MOSTAR);
        Iterator it = g.iterator();
        assertEquals("Maja", it.next());
        assertEquals("Zdravko Maminjo Mamic", it.next());
        assert(!it.hasNext());
    }

    @Test
    void izGradaBrojevi() {
        FiksniBroj f = new FiksniBroj(Grad.SARAJEVO, "710-000");
        Imenik imenik = new Imenik();
        imenik.dodaj("Azra", f);
        f = new FiksniBroj(Grad.BIHAC, "111-111");
        imenik.dodaj("Mirza", f);
        f = new FiksniBroj(Grad.MOSTAR, "222-222");
        imenik.dodaj("Maja", f);
        f = new FiksniBroj(Grad.MOSTAR, "333-333");
        imenik.dodaj("Zdravko Maminjo Mamic", f);
        var g = imenik.izGradaBrojevi(Grad.MOSTAR);
        Iterator<TelefonskiBroj> it = g.iterator();
        assertEquals("036/222-222", it.next().ispisi());
        assertEquals("036/333-333", it.next().ispisi());
        assert(!it.hasNext());
    }
}