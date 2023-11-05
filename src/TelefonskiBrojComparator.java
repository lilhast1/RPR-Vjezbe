import java.util.Comparator;
public class TelefonskiBrojComparator implements  Comparator<TelefonskiBroj>{
    @Override
    public int compare(TelefonskiBroj a, TelefonskiBroj b) {
        return a.ispisi().compareTo(b.ispisi());
    }
}
