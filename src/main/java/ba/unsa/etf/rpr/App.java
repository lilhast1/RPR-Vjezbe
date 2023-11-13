package ba.unsa.etf.rpr;

import java.io.IOException;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {
        Scanner scn = new Scanner(System.in);
        LaptopDaoSerializableFile ldsf = new LaptopDaoSerializableFile();
        while (true) {
            System.out.println("Vrati iz filea ili dodaj u file ili dodaj u list? [V/D/L]");
            String line = scn.nextLine();
            if (line.contains("V"))
                ldsf.vratiPodatkeIzDatoteke();
            else if (line.contains("D"))
                ldsf.dodajLaptopUFile(App.unesiLaptop(scn));
            else if (line.contains("L"))
                ldsf.dodajLaptopUListu(App.unesiLaptop(scn));
            else
                break;
        }
        ldsf.ispisi();
    }
    public static Laptop unesiLaptop(Scanner scn) {
        Laptop l = new Laptop();
        System.out.println( "Unesi Laptop:" );
        System.out.println("CPU: ");
        l.setProcesor(scn.nextLine());
        System.out.println("brend: ");
        l.setBrend(scn.nextLine());
        System.out.println("GPU: ");
        l.setGrafickaKartica(scn.nextLine());
        System.out.println("Cijena: ");
        l.setCijena(scn.nextDouble());
        System.out.println("Velicina Ekrana: ");
        l.setVelicinaEkrana(scn.nextDouble());
        System.out.println("RAM: ");
        l.setRam(scn.nextInt());
        System.out.println("HDD: ");
        l.setHdd(scn.nextInt());
        System.out.println("SSD: ");
        l.setSsd(scn.nextInt()); scn.nextLine();
        return l;
    }
}
