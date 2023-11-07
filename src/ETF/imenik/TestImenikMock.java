package ETF.imenik;

import java.util.Set;

public class TestImenikMock extends Imenik{
    private ImenikMock imenik;
    public TestImenikMock() {
        imenik = null;
    }
    public void start() {
        imenik = new ImenikMock();
    }
    public TestImenikMock(ImenikMock i) {
        imenik = i;
    }
    private TelefonskiBroj decode(String str) {
        if (str.charAt(0) == '+')
            return new MedunarodniBroj(str.substring(0, 3), str.substring(3));
        if (str.charAt(1) == '6') {
            int m = Integer.parseInt(str.substring(1, 3));
            return new MobilniBroj(m, str.substring(3));
        }
        Grad g = Grad.values()[str.charAt(2)];
        return new FiksniBroj(g, str.substring(3));
    }
    @Override
    public void dodaj(String Ime, TelefonskiBroj broj) {
        imenik.dodaj(Ime, broj.ispisi());
        super.dodaj(Ime, broj);
    }

    @Override
    public String dajBroj(String Ime) {
        if (super.dajBroj(Ime).equals(imenik.dajBroj(Ime)))
            return super.dajBroj(Ime);
        return "";
    }

    @Override
    public String naSlovo(char c) {
        if (super.naSlovo(c).equals(imenik.naSlovo(c)))
            return super.naSlovo(c);
        return "";
    }

    @Override
    public Set<String> izGrada(Grad g) {
        if (super.izGrada(g).containsAll(imenik.izGrada(g)))
            return super.izGrada(g);
        return null;
    }
}
