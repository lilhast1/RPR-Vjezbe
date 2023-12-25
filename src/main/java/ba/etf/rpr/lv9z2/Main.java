package ba.etf.rpr.lv9z2;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Scanner scn;
    public Main() {
        if (scn == null)
            scn = new Scanner(System.in);
    }
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        GeografijaDAO gdao = GeografijaDAO.getInstance();
    }
    public static String ispisiGradove() {
        //za svaki: “Ime grada (ime države) - broj stanovnika”
        return "";
    }
    public static void glavniGrad() {
        //"Glavni grad države Država je Grad"
        //ili ako nema "Nepostojeća država"
        String drzava = scn.nextLine();

    }

}

