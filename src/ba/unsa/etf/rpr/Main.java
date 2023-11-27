package ba.unsa.etf.rpr;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        Scanner scn = new Scanner(System.in);
        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
        System.out.println("Kako se zove predmet?");
        Predmet p = new Predmet();
        p.setNaziv(scn.nextLine());
        System.out.println("Kratki opis predmeta?");
        p.setOpis(scn.nextLine());
        InformacijeONastavniku n = new InformacijeONastavniku();
        System.out.println("Kako se zove predavac?");
        n.setIme(scn.next());
        n.setPrezime(scn.next());
        System.out.println("Koja je titula nastavnika?");
        n.setTitula(scn.next());
        InformacijeOStudentu s = new InformacijeOStudentu();
        System.out.println("Kako se zovete?");
        s.setIme(scn.next());
        s.setPrezime(scn.next());
        System.out.println("Koja ste godina?");
        s.setGodinaStudija(scn.next());
        System.out.println("Broj Indeksa?");
        s.setBrojIndexa(scn.next());
        System.out.println("Ocjenite Predavaca");
        n.addOcjena(s.ocijeni(scn.nextInt()));
        System.out.println("Ocjenite Predmet");
        p.addOcjena(s.ocijeni(scn.nextInt()));
    }
}