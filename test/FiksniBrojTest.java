import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class FiksniBrojTest {

    @Test
    void ispisi() {
        FiksniBroj f = new FiksniBroj(Grad.SARAJEVO, "221-158");
        assertEquals("033/221-158", f.ispisi());
    }
}