package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LaptopDaoXMLFileTest {

    @Test
    void dodajLaptopUListu() throws NeodgovarajuciProcesorException, IOException {
        LaptopDao ld = new LaptopDaoXMLFile();
        Laptop l = new Laptop();
        l.setProcesor("Intel i5-8600");
        l.setBrend("Asus");
        l.setGrafickaKartica("Nvidia 1060Ti");
        l.setCijena(1199.99);
        l.setVelicinaEkrana(17.3);
        l.setRam(16);
        l.setHdd(512);
        l.setSsd(128);
        l.setModel("8908");
        ld.dodajLaptopUListu(l);
        assertEquals("Asus", ld.getLaptop(l.getProcesor()).getBrend());
        ld.vratiPodatkeIzDatoteke();
        assertThrows(NeodgovarajuciProcesorException.class,() -> ld.getLaptop(l.getProcesor()));
    }

    @Test
    void dodajLaptopUFile() throws IOException, NeodgovarajuciProcesorException {
        LaptopDao ld = new LaptopDaoXMLFile();
        Laptop l = new Laptop();
        l.setProcesor("Intel i5-8600");
        l.setBrend("Asus");
        l.setGrafickaKartica("Nvidia 1060Ti");
        l.setCijena(1199.99);
        l.setVelicinaEkrana(17.3);
        l.setRam(16);
        l.setHdd(512);
        l.setSsd(128);
        l.setModel("8908");
        ld.dodajLaptopUListu(l);
        l = new Laptop();
        l.setProcesor("Motorola");
        l.setBrend("Karambolka");
        l.setGrafickaKartica("Nvidia 1060Ti");
        l.setCijena(1199.99);
        l.setVelicinaEkrana(17.3);
        l.setRam(16);
        l.setHdd(512);
        l.setSsd(128);
        l.setModel("8908");
        ld.dodajLaptopUFile(l);
        ld.vratiPodatkeIzDatoteke();
        assertEquals("Karambolka", ld.getLaptop("Motorola").getBrend());
    }
}