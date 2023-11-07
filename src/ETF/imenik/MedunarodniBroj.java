package ETF.imenik;

import ETF.imenik.TelefonskiBroj;

public class MedunarodniBroj extends TelefonskiBroj {
    private String drzava, broj;
    public MedunarodniBroj(String drzava, String broj) {
        this.drzava = drzava; this.broj = broj;
    }
    @Override
    public String ispisi() {
        StringBuilder s = new StringBuilder(drzava);
        s.append("/" + broj);
        return s.toString();
    }
}
