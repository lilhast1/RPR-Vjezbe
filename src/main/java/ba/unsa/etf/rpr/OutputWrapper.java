package ba.unsa.etf.rpr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputWrapper {
    private ObjectOutputStream out;
    private FileOutputStream f;
    OutputWrapper(File file) throws IOException {
        f = new FileOutputStream(file);
        out = new ObjectOutputStream(f);
    }
    public void writeObject(Laptop l) throws IOException {
        out.writeObject(l);
    }

}
