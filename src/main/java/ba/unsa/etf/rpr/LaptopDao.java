package ba.unsa.etf.rpr;

import java.io.File;
import java.util.ArrayList;

public interface LaptopDao {
    public LaptopDao dodajLaptopUListu(Laptop laptop);
    public LaptopDao dodajLaptopUFile(Laptop laptop);
    public Laptop getLaptop(String cpu);
    public void napuniListu(ArrayList<Laptop> laptops);
    public void vratiPodatkeIzDatoteke();
}
