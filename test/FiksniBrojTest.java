import static org.junit.jupiter.api.Assertions.*;

import ETF.imenik.FiksniBroj;
import org.junit.jupiter.api.Test;
import ETF.imenik.Grad;

class FiksniBrojTest {

    @Test
    void ispisi() {
        FiksniBroj f = new FiksniBroj(Grad.SARAJEVO, "221-158");
        assertEquals("033/221-158", f.ispisi());
    }
}