package main;

public class G {
    public static int faktorijel(int n) {
        int p = 1;
        for (int i = 1; i <= n; i++)
            p *= i;
        return p;
    }
}
