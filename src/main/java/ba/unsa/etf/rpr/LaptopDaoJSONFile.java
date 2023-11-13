package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoJSONFile implements LaptopDao {
    private ArrayList<Laptop> laptopi;
    private File fileJSON;
    public LaptopDaoJSONFile() {
        laptopi = new ArrayList<>();
        fileJSON = null;
    }
    @Override
    public LaptopDao dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop); return this;
    }

    @Override
    public LaptopDao dodajLaptopUFile(Laptop laptop) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        if (fileJSON != null) {
            ArrayList<Laptop> backed = mapper.readValue(fileJSON, new TypeReference<ArrayList<Laptop>>() {
            });
            backed.add(laptop);
            mapper.writeValue(fileJSON, backed);
        } else {
            fileJSON = new File("LaptopJSON" + hashCode() + ".json");
            ArrayList<Laptop> backed = new ArrayList<>();
            backed.add(laptop);
            mapper.writeValue(fileJSON, backed);
        }

        return this;
    }

    @Override
    public Laptop getLaptop(String cpu) throws NeodgovarajuciProcesorException {
        return laptopi.stream()
                .filter(laptop -> cpu.contains(laptop.getProcesor()))
                .findAny()
                .orElseThrow(() -> new NeodgovarajuciProcesorException("Nema ga"));
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptops) {
        laptopi.addAll(laptops);
    }

    @Override
    public void vratiPodatkeIzDatoteke() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        if (fileJSON == null) {
            laptopi = new ArrayList<>();
            return;
        }
        laptopi = mapper.readValue(fileJSON, new TypeReference<ArrayList<Laptop>>() {});
    }
}
