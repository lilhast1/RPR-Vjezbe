package ba.unsa.etf.rpr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InputWrapper {
    ObjectInputStream in;
    FileInputStream f;
    InputWrapper(File file) throws IOException {
        f = new FileInputStream(file);
        in = new ObjectInputStream(f);
    }
    public Object readObject() throws IOException, ClassNotFoundException {
        return in.readObject();
    }
    public int available() throws IOException {
        return f.available();
    }
}
