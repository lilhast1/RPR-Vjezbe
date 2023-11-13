package ba.unsa.etf.rpr;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao {
    private ArrayList<Laptop> laptopi;
    private File fileJSON;
    private Gson gson;

    @Override
    public LaptopDao dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop); return this;
    }

    @Override
    public LaptopDao dodajLaptopUFile(Laptop laptop) throws IOException {
        FileWriter in = new FileWriter(fileJSON);
        gson.toJson(laptop, in);
        in.close();
        return this;
    }

    @Override
    public Laptop getLaptop(String cpu) {
        return laptopi.stream()
                .filter(laptop -> cpu.contains(laptop.getProcesor()))
                .findAny()
                .orElse(null);
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptops) {
        laptopi.addAll(laptops);
    }

    @Override
    public void vratiPodatkeIzDatoteke() {
        InputStream in = new FileInputStream(fileJSON);
        JsonReader rdr = Json.createReader() {
                     JsonObject obj = rdr.readObject();
                     JsonArray results = obj.getJsonArray("data");
                     for (JsonObject result : results.getValuesAs(JsonObject.class)) {
                         System.out.print(result.getJsonObject("from").getString("name"));
                         System.out.print(": ");
                         System.out.println(result.getString("message", ""));
                         System.out.println("-----------");
                     }

        Laptop l = new Gson().fromJson(br, Laptop.class);
    }
}
