package ETF.imenik;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

// Posto nije Maven projekat napraviti cu svoj mock rucno, ali ubuduce ce
// sve biti radjeno mockitom
public class ImenikMock extends TestImenikMock{
    private HashMap<String, String> imenik;
    //private Imenik realImenik;
    public ImenikMock() {
        imenik = new HashMap<>();
    }

    public void dodaj(String Ime, String broj) {
        imenik.put(Ime, broj);
        //TelefonskiBroj t = decode(broj);
        //realImenik.dodaj(Ime, t);
    }
    public String dajBroj(String Ime) {
//        if (!imenik.get(Ime).equals(realImenik.dajBroj(Ime)))
//            return "";
        return imenik.get(Ime);
    }
    public String naSlovo(char c) {
        int i = 1; StringBuilder s = new StringBuilder();
        for (var p : imenik.entrySet()) {
            if (p.getKey().charAt(0) == c) {
                String t = "" + i + "." + p.getKey() + " - " + p.getValue() + "\n";
                s.append(t);
                i += 1;
            }
        }
//        var real = realImenik.naSlovo(c);
//        if (real.contentEquals(s))
//            return s.toString();
        return "";
    }
    public Set<String> izGrada(Grad g) {
        Set<String> gradjani = new TreeSet<>();
        //var real = realImenik.izGrada(g);
        for (var p : imenik.entrySet()) {
            if (p.getValue().contains(g.toString()))
                gradjani.add(p.getKey());
        }
//        for (String p : gradjani) {
//            if (!real.contains(p))
//                return null;
//        }
        return gradjani;
    }

    public Set<String> isGradaBrojevi(Grad g) throws BijelaKuga {
        Set<String> s = new TreeSet<>();
        //var real = realImenik.izGradaBrojevi(g);
        for (var p : imenik.entrySet()) {
            if (p.getValue().contains(g.toString()))
                s.add(p.getValue());
        }
        if (s.size() == 0)
            throw new BijelaKuga("Vidjela sam grad bez ljudi");
        /*for (var p : real)
            if (!s.contains(p.ispisi()))
                return null;
        */
        return s;
    }
}
