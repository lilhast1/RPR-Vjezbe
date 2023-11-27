package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class KolekcijaPoruka {
    private List<String> poruke;
    public String get(int i) {
        return poruke.get(i);
    }
    public KolekcijaPoruka(List<Informator> lista) {
        poruke = new ArrayList<>();
        for (var inf : lista)
            poruke.add(inf.predstavi());
    }
}
