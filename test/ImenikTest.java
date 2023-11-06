import org.junit.jupiter.api.Test;

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
1. Faruk - 033/221-158
2. Fata - 061/556-443
""", imenik.naSlovo('F'));
    }

    @Test
    void izGrada() {
    }

    @Test
    void izGradaBrojevi() {
    }
}