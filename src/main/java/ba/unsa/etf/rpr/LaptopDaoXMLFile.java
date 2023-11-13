package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoXMLFile implements LaptopDao {
    ArrayList<Laptop> laptopi;
    File xml;
    LaptopDaoXMLFile()  {
        laptopi = new ArrayList<>();
        xml = null;
    }
    @Override
    public LaptopDao dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
        return this;
    }

    @Override
    public LaptopDao dodajLaptopUFile(Laptop laptop) throws IOException {
        XmlMapper mapper = new XmlMapper();
        if (xml != null) {
            ArrayList<Laptop> backed = mapper.readValue(xml, new TypeReference<ArrayList<Laptop>>() {
            });
            backed.add(laptop);
            mapper = new XmlMapper();
            mapper.writeValue(xml, backed);
        } else {
            xml = new File("LaptopXML" + hashCode() + ".fxml");
            ArrayList<Laptop> backed = new ArrayList<>();
            backed.add(laptop);
            mapper.writeValue(xml, backed);
        }
        return this;
    }

    @Override
    public Laptop getLaptop(String cpu) throws NeodgovarajuciProcesorException {
        return laptopi.stream()
                .filter(laptop -> cpu.contains(laptop.getProcesor()))
                .findAny()
                .orElseThrow(() -> new NeodgovarajuciProcesorException("nema"));
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptops) {
        laptopi.addAll(laptops);
    }

    @Override
    public void vratiPodatkeIzDatoteke() throws IOException {
        XmlMapper mapper = new XmlMapper();
        if (xml != null) {
            laptopi = mapper.readValue(xml, new TypeReference<ArrayList<Laptop>>() {
            });
            return;
        }
        laptopi = new ArrayList<>();
    }
}
