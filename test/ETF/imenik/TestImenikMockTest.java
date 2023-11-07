package ETF.imenik;

import org.junit.jupiter.api.Test;

class TestImenikMockTest {

    @Test
    void naSlovo() {
        TestImenikMock imenik = new TestImenikMock();
        imenik.start();
        FiksniBroj f = new FiksniBroj(Grad.SARAJEVO, "221-158");
        imenik.dodaj("Faruk", f);
        f = new FiksniBroj(Grad.BIHAC, "222-558");
        imenik.dodaj("Izet", f);
        MobilniBroj m = new MobilniBroj(62, "556-443");
        imenik.dodaj("Fata", m);
        assert(imenik.naSlovo('F') != null);
    }


    @Test
    void izGrada() {
        FiksniBroj f = new FiksniBroj(Grad.SARAJEVO, "710-000");
        TestImenikMock imenik = new TestImenikMock();
        imenik.start();
        imenik.dodaj("Azra", f);
        f = new FiksniBroj(Grad.BIHAC, "111-111");
        imenik.dodaj("Mirza", f);
        f = new FiksniBroj(Grad.MOSTAR, "222-222");
        imenik.dodaj("Maja", f);
        f = new FiksniBroj(Grad.MOSTAR, "333-333");
        imenik.dodaj("Zdravko Maminjo Mamic", f);
        assert(imenik.izGrada(Grad.MOSTAR) != null);
        // ideja je ako je null to znaci da ima razlike
        // ovim testiram izvedenu koja se sadrzi u bazi
        // dok istovremeno izvedena mocka baznu bazne
    }
}