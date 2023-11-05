import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Unesite FiksniBroj");
        System.out.println("Grad: ");
        var g = scn.nextInt();
        System.out.println("Broj: ");
        scn.nextLine(); // clear /n
        var b = scn.nextLine();
        FiksniBroj f = new FiksniBroj(Grad.values()[g], b);
        System.out.println(f.ispisi());
        System.out.println("Unesite MobilniBroj");
        System.out.println("Mreza i Broj: ");
        var n = scn.nextInt();
        scn.nextLine(); // clear /n
        b = scn.nextLine();
        MobilniBroj m = new MobilniBroj(n, b);
        System.out.println(m.ispisi());
        System.out.println("Unesite MedunarodniBroj");
        System.out.println("Drzava: ");
        var d = scn.nextLine();
        System.out.println("Broj: ");
        b = scn.nextLine();
        MedunarodniBroj i = new MedunarodniBroj(d, b);
        System.out.println(i.ispisi());
        Imenik imenik = new Imenik();
        imenik.dodaj("Kuca", f);
        imenik.dodaj("Almir", m);
        imenik.dodaj("Tarik", i);
        System.out.println(imenik.dajBroj("Tarik"));
        System.out.println(imenik.naSlovo('K'));

    }
}
