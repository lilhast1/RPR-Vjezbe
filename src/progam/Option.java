package progam;

import ETF.imenik.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Option {
    TelefonskiBroj t;
    ArrayList<Imenik> imeniks;
    Scanner scn;
    public Option(Scanner s) {
        scn = s;
    }
    public void call(int option) {
        switch (option) {
            case 1: inputBroj();
                break;
            case 2: kreirajImenik();
                break;
            case 3: dodajImenik();
                break;
            case 4:
                nadImenik();
                break;
        }
    }
    public void inputBroj() {
        System.out.println("""
                Unesite tip broja:
                1 - Fiksni
                2 - Mobilni
                3 - Medjunarodni 
                """);
        int tip;
        //var scn = new Scanner(System.in);
        tip = scn.nextInt();
        if (tip == 1) {
            System.out.print("Unesi grad:");
            int g = scn.nextInt();
            scn.nextLine();
            System.out.print("Unesi broj:");
            String broj = scn.nextLine();
            t = new FiksniBroj(Grad.values()[g], broj);
        } else if (tip == 2) {
            System.out.print("Unesi mrezu[XX]:");
            int m = scn.nextInt();
            scn.nextLine();
            System.out.print("Unesi broj:");
            String broj = scn.nextLine();
            t = new MobilniBroj(m, broj);
        } else if (tip == 3) {
            System.out.print("Unesi drzavu[+XXX]:");
            String d = scn.nextLine();
            System.out.print("Unesi broj:");
            String broj = scn.nextLine();
            t = new MedunarodniBroj(d, broj);
        }
    }

    public void kreirajImenik() {
        imeniks.add(new Imenik());
    }
    public void dodajImenik() {
        System.out.println("Koji od " + imeniks.size() + " imenika?");
        //var scn = new Scanner(System.in);
        int imen = scn.nextInt(); scn.nextLine();
        System.out.println("Ime?");
        String ime = scn.nextLine();
        System.out.println("Novi broj/zadnji? [1/0]");
        if (scn.nextInt() == 1)
            inputBroj();
        scn.nextLine();
        imeniks.get(imen - 1).dodaj(ime, t);
    }
    public void nadImenik() {
        System.out.println("Koji od " + imeniks.size() + " imenika?");
        //var scn = new Scanner(System.in);
        int imen = scn.nextInt(); scn.nextLine();
        System.out.println("""
                Opciju izaberite:
                1 - DajBroj
                2 - NaSlovo
                3 - IzGrada
                4 - IzGradaBrojevi
                """);
        int op = scn.nextInt(); scn.nextLine();
        if (op == 1) {
            System.out.println("Ciji broj?");
            String ime = scn.nextLine();
            System.out.println(imeniks.get(imen - 1).dajBroj(ime));
        } else if (op == 2) {
            System.out.print("Na slovo, na slovo: ");
            String c = scn.next(); scn.nextLine();
            System.out.println(imeniks.get(imen - 1).naSlovo(c.charAt(0)));
        } else if (op == 3) {
            System.out.println("Iz grada: ");
            int g = scn.nextInt(); scn.nextLine();
            var s = imeniks.get(imen - 1).izGrada(Grad.values()[g]);
            for (var i : s)
                System.out.println(i);
        } else if (op == 4) {
            System.out.println("Iz grada: ");
            int g = scn.nextInt(); scn.nextLine();
            try {
                var s = imeniks.get(imen - 1).izGradaBrojevi(Grad.values()[g]);
                for (var i : s)
                    System.out.println(i.ispisi());
            } catch (BijelaKuga b) {
                System.out.println(b.getMessage());
            }
        }
    }
}
