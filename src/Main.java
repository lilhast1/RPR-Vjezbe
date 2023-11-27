import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Scanner scn = new Scanner(System.in);
        System.out.println("koliko ljudi?");
        int n = scn.nextInt();
        KolekcijaImena k = new KolekcijaImena();
        for (int i = 0; i < n; i++) {
            System.out.println("Unesi ime prezime: ");
            k.add(scn.nextLine());
        }
        Pobjednik p = new Pobjednik(k);
        System.out.println("Pobjednik se zove " + p.getIme() + " " + p.getPrezime());
    }
}