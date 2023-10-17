public class Sat {
    private int sat, min, sek;
    Sat(int sat, int min, int sek) {
        Postavi(sat, min, sek);
    }
    public void Postavi(int sat, int min, int sek) {
        this.sat = sat;
        this.min = min;
        this.sek = sek;
    }
    public void Sljedeci() {
        sek++;
        if (sek == 60) {
            sek = 0;
            min++;
        }
        if (min == 60) {
            min = 0;
            sat++;
        }
        if (sat == 24)
            sat = 0;
    }
    public void Prethodni() {
        sek--;
        if (sek < 0) {
            sek = 59;
            min--;
        }
        if (min < 0) {
            min = 59;
            sat--;
        }
        if (sat < 0)
            sat = 23;
    }
    public void PomjeriZa(int pomak) {
        for (int i = 0; i < pomak; i++)
            Sljedeci();
        for (int i = 0; i > pomak; i--)
            Prethodni();
    }
    public int DajSekunde() {
        return sek;
    }
    public int DajMinute() {
        return min;
    }
    public int DajSat() {
        return sat;
    }
    public void Ispisi() {
        System.out.printf("sati:%d minute:%d sekunde:%d\n", sat, min, sek);
    }
}
