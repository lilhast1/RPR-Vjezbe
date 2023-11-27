import java.util.List;

public class KolekcijaImenaIPrezimena implements Kolekcija{
    private List<String> imena, prezimena;
    public int getIndexNajduzegPara() {
        int m = 0;
        for (int i = 0; i < imena.size(); i++) {
            int temp = imena.get(i).length() + prezimena.get(i).length();
            if (temp > m)
                m = temp;
        }
        return m;
    }
    public String getImeiPrezime(int indx) {
        StringBuilder s = new StringBuilder(imena.get(indx));
        return s.append(" " + prezimena.get(indx)).toString();
    }

    @Override
    public String getNajduzeIme() {
        return getImeiPrezime(getIndexNajduzegPara());
    }
}
