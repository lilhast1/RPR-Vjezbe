package main;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("NEMA DOVOLJNO ARGUMENTA");
            return;
        }
        double x = Double.parseDouble(args[0]);
        int n  = Integer.parseInt(args[1]);
        System.out.println("Sinus: " + Math.sin(x));
        System.out.println("Faktorijel: " + G.faktorijel(n));

    }
}
