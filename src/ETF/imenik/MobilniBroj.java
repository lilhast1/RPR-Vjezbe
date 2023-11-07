package ETF.imenik;

public class MobilniBroj extends TelefonskiBroj {
    private String broj, mreza;
    public MobilniBroj(int mreza, String broj) {
        this.mreza = "0" + mreza;
        this.broj = broj;
    }
    @Override
    public String ispisi() {
        StringBuilder s = new StringBuilder(mreza);
        s.append("/" + broj);
        return s.toString();
    }

}
