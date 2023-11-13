package ba.unsa.etf.rpr;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao {
    private ArrayList<Laptop> laptopi;
    private File file;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private FileOutputStream fout;
    private FileInputStream fin;
    LaptopDaoSerializableFile() throws IOException {
        file = new File("LaptopDaoSeraizliable" + hashCode());
        fout = new FileOutputStream(file);
        fin = new FileInputStream(file);
        laptopi = null;
        out = new ObjectOutputStream(fout);
        in = new ObjectInputStream(fin);
    }
    @Override
    public LaptopDao dodajLaptopUListu(Laptop laptop) {
        return null;
    }

    @Override
    public LaptopDao dodajLaptopUFile(Laptop laptop) throws IOException {
        out.writeObject(laptop);
        return this;
    }

    @Override
    public Laptop getLaptop(String cpu) {

        return laptopi.stream()
                .filter(laptop -> cpu.equals(laptop.getProcesor()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptops) {
        laptopi.addAll(laptops);
    }

    @Override
    public void vratiPodatkeIzDatoteke() {
        laptopi = new ArrayList<>();
        while(true) {
            try {
                laptopi.add((Laptop) in.readObject());
            } catch (IOException e) {
                break;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
