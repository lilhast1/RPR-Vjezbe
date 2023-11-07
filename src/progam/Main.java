package progam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //petlja
        System.out.println("Dobro dosli u ETF imenik!");
        var scn = new Scanner(System.in);
        Option opcija = new Option(scn);
        while (true) {
            System.out.println("Izaberite opciju");
            System.out.println("[1] [unesi broj]");
            System.out.println("[2] [kreiraj imenik]");
            System.out.println("[3] [dodaj u imenik]");
            System.out.println("[4] [udji u imenik]");
            System.out.println("[5] [kraj]");
            int option = scn.nextInt(); scn.nextLine();
            if (option == 5)
                break;
            opcija.call(option);
        }

    }
}
