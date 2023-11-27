import java.util.Comparator;
import java.util.List;

public class KolekcijaImena implements Kolekcija {
    private List<String> imena;
    @Override
    public String getNajduzeIme() {
        return imena.stream().max(Comparator.comparing(String::length)).get();
    }
    public void add(String ime) {
        imena.add(ime);
    }
}
