package ETF.imenik;

import ETF.imenik.BijelaKuga;
import ETF.imenik.Grad;
import ETF.imenik.TelefonskiBroj;
import ETF.imenik.TelefonskiBrojComparator;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Imenik {
    private HashMap<String, TelefonskiBroj> imenik = new HashMap<>();
    public void dodaj(String Ime, TelefonskiBroj broj) {
        imenik.put(Ime, broj);
    }
    public String dajBroj(String Ime) {
        return imenik.get(Ime).ispisi();
    }
    public String naSlovo(char c) {
        int i = 1; StringBuilder s = new StringBuilder();
        for (var p : imenik.entrySet()) {
            if (p.getKey().charAt(0) == c) {
                String t = "" + i + "." + p.getKey() + " - " + p.getValue().ispisi() + "\n";
                s.append(t);
                i += 1;
            }
        }
        return s.toString();
    }
    public Set<String> izGrada(Grad g) {
        Set<String> gradjani = new TreeSet<>();
        for (var p : imenik.entrySet()) {
            if (p.getValue().ispisi().contains(g.toString()))
                gradjani.add(p.getKey());
        }
        return gradjani;
    }
    public Set<TelefonskiBroj> izGradaBrojevi(Grad g) throws BijelaKuga {
        Set<TelefonskiBroj> s = new TreeSet<>(new TelefonskiBrojComparator());
        for (var p : imenik.entrySet()) {
            if (p.getValue().ispisi().contains(g.toString()))
                s.add(p.getValue());
        }
        if (s.size() == 0)
            throw new BijelaKuga("Vidjela sam grad bez ljudi");
        return s;
    }
}