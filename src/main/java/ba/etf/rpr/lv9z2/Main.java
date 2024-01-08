package ba.etf.rpr.lv9z2;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Scanner scn;
    private static GeografijaDAO geografija;
    public Main() throws SQLException, FileNotFoundException {
        if (scn == null)
            scn = new Scanner(System.in);
        if (geografija == null)
            geografija = GeografijaDAO.getInstance();
    }
    public static void main(String[] args) throws SQLException, FileNotFoundException, ClassNotFoundException {

        geografija = GeografijaDAO.getInstance();
        scn =  new Scanner(System.in);
        System.out.println( ispisiGradove() );
        glavniGrad();
    }
    public static String ispisiGradove() throws SQLException {
        //za svaki: “Ime grada (ime države) - broj stanovnika”
        StringBuilder s = new StringBuilder();
        for (Grad g : geografija.gradovi()) {
            s.append(g.getNaziv()).
                    append(" (").
                    append(geografija.getDrzavaNaziv(g.getIdDrzava())).
                    append(") - ").
                    append(g.getBrojStanovnika()).append("\n");
        }
        return s.toString();
    }
    public static void glavniGrad() throws SQLException {
        //"Glavni grad države Država je Grad"
        //ili ako nema "Nepostojeća država"
        String drzava = scn.nextLine();
        System.out.println("Glavni grad države " + drzava + " je " + geografija.glavniGrad(drzava).getNaziv());
    }

}

