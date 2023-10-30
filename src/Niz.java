import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Niz {
    private List<Integer> niz;
    private Integer min, max, sumSquares, sum;
    private Double mean, s;
    public Niz() {
        niz = new ArrayList<>();
        mean = s = 0.;
        sum = sumSquares = 0;
    }
    public Niz add(Integer n) {
        if (niz.isEmpty())
            min = max = n;
        else if (n < min)
            min = n;
        else if (n > max)
            max = n;
        niz.add(n);
        sumSquares += n * n;
        sum += n;
        Collections.sort(niz);
        var size = niz.size();
        if (size % 2 == 0) {
            mean = (niz.get(size / 2) + niz.get(size / 2 - 1)) / 2.;
        } else {
            mean = niz.get((size - 1) / 2) * 1.;
        }
        double h = mean * sum;
        s = (sumSquares + size * mean * mean - 2 * h) / size;
        return this;
    }

    public Niz print() {
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Mean: " + mean);
        System.out.println("Standard deviation: " + s);
        return this;
    }
}
