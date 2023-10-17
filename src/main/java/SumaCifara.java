import java.util.Scanner;
public class SumaCifara {
    public static void isti(int n) {
        for (int i = 2; i < n; i++) {
            if (i % sumaCifara(i) == 0)
                System.out.println(i);
        }
    }
    public static int sumaCifara(int n) {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Unesite n:");
        int n;
        n = scn.nextInt();
        isti(n);
    }
}
