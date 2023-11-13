package ba.unsa.etf.rpr;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao {
    private ArrayList<Laptop> laptopi;
    private File file;
    private OutputWrapper out;
    private InputWrapper in;
    public LaptopDaoSerializableFile() throws IOException {
        file = new File("LaptopDaoSeraizliable" + hashCode() + ".txt");
        laptopi = new ArrayList<>();
        out = new OutputWrapper(file);
        in = new InputWrapper(file);
    }
    public LaptopDaoSerializableFile(String p, OutputWrapper o, InputWrapper i) {
        file = new File(p);
        out = o; in = i;
    }
    @Override
    public LaptopDao dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
        return this;
    }

    @Override
    public LaptopDao dodajLaptopUFile(Laptop laptop) throws IOException {
        out.writeObject(laptop);
        return this;
    }

    @Override
    public Laptop getLaptop(String cpu) throws NeodgovarajuciProcesorException {

        return laptopi.stream()
                .filter(laptop -> cpu.equals(laptop.getProcesor()))
                .findFirst()
                .orElseThrow(() -> new NeodgovarajuciProcesorException("Nema ga"));
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
    public void ispisi() {
        laptopi.stream().forEach(Laptop::ispisiNaEkran);
    }

}
