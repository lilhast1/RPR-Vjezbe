package ba.etf.rpr.lv9z2;

//import com.almasb.fxgl.net.Connection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeografijaDAO {
    private static GeografijaDAO instance;
    private Connection connection;
    private String url;
    private PreparedStatement gradoviQuery, glGradQuery, drzavaQuery, deleteDrzavaQuery, alterGradQuery,
            addGradQuery, addDrzavaQuery, getDrzavaIDQuery;
    private GeografijaDAO() throws SQLException, FileNotFoundException {
        //init bazu
        url = "jdbc:sqlite:" + System.getProperty("user.host") + ".geografija.db";
        connection = DriverManager.getConnection(url);
        Statement test = connection.createStatement();
        try{
            test.execute("SELECT * FROM gradovi CROSS JOIN drzave");
        } catch (SQLException sqlException) {
            generate();
            test.execute("SELECT * FROM gradovi CROSS JOIN drzave");
        }
        gradoviQuery = connection.prepareStatement("SELECT id, naziv, broj_stanovnika, drzava FROM " +
                                                    "gradovi ORDER BY broj_stanovnika DESC");
        glGradQuery = connection.prepareStatement(
                "SELECT  g.id, g.naziv, g.broj_stanovnika, g.drzava" +
                        " FROM gradovi g, drzave d " + " WHERE d.naziv = ? and d.glavni_grad = g.id"
        );
        drzavaQuery = connection.prepareStatement("SELECT id, naziv, glavni_grad FROM drzave WHERE naziv = ?");
        deleteDrzavaQuery = connection.prepareStatement("DELETE FROM drzave WHERE naziv = ?");
        alterGradQuery = connection.prepareStatement("UPDATE gradovi SET naziv = ?, broj_stanovnika = ?," +
                " drzava = ? WHERE id = ?");
        addGradQuery = connection.prepareStatement("INSERT INTO gradovi(naziv, broj_stanovnika, drzava) " +
                "VALUES (?,?,?)");
        addDrzavaQuery = connection.prepareStatement("INSERT INTO drzave(naziv, glavni_grad) VALUES (?,?)");
        getDrzavaIDQuery = connection.prepareStatement("SELECT id, naziv, glavni_grad FROM drzave WHERE id = ?");
    }
    public static GeografijaDAO getInstance() throws SQLException, FileNotFoundException {
        if (instance == null)
            instance = new GeografijaDAO();
        return instance;
    }
    private void generate() throws FileNotFoundException, SQLException {
        Scanner in = new Scanner(new FileInputStream(
                "/Users/tarikhastor/IdeaProjects/lv9-z2/src/main/resources/ba/etf/rpr/lv9z2/geografija.sql")
        );
        StringBuilder command = new StringBuilder();
        while(in.hasNext()) {
            command.append(in.nextLine());
            if (!command.isEmpty() && command.charAt(command.length() - 1) == ';') {
                Statement statement = connection.createStatement();
                statement.execute(command.toString());
                command.setLength(0);
            }
        }
        in.close();
    }
    public Grad glavniGrad(String drzava) throws SQLException {
        glGradQuery.setString(1, drzava);
        ResultSet result = glGradQuery.executeQuery();
        if (!result.next())
            return null;
        return new Grad(
                result.getInt(1), result.getInt(3),
                result.getInt(4), result.getString(2)
        );
    }
    public void obrisiDrzavu(String drzava) throws SQLException {
        deleteDrzavaQuery.setString(1, drzava);
        deleteDrzavaQuery.execute();
    }
    public ArrayList<Grad> gradovi() throws SQLException {
        ResultSet resultSet = gradoviQuery.executeQuery();
        ArrayList<Grad> gradovi = new ArrayList<>();
        while (resultSet.next()) {
            gradovi.add(new Grad(
                    resultSet.getInt(1), resultSet.getInt(3),
                    resultSet.getInt(4), resultSet.getString(2)
            ));
        }
        return gradovi;
    }

    public void dodajGrad(Grad grad) throws SQLException {
        addGradQuery.setString(1, grad.getNaziv());
        addGradQuery.setInt(2, grad.getBrojStanovnika());
        addGradQuery.setInt(3, grad.getIdDrzava());
        addGradQuery.execute();
    }
    public void dodajDrzavu(Drzava drzava) throws SQLException {
        addDrzavaQuery.setString(1, drzava.getNaziv());
        addDrzavaQuery.setInt(2, drzava.getIdGlavniGrad());
        addDrzavaQuery.execute();
    }
    public void izmjeniGrad(Grad grad) throws SQLException {
        alterGradQuery.setString(1, grad.getNaziv());
        alterGradQuery.setInt(2, grad.getBrojStanovnika());
        alterGradQuery.setInt(3, grad.getIdDrzava());
        alterGradQuery.setInt(4, grad.getId());
        alterGradQuery.execute();
    }
    public Drzava nadjiDrzavu(String Drzava) throws SQLException {
        drzavaQuery.setString(1, Drzava);
        ResultSet result = drzavaQuery.executeQuery();
        if (!result.next())
            return null;
        return new Drzava(result.getInt(1), result.getInt(3),
                result.getString(2));
    }
    public String getDrzavaNaziv(int id) throws SQLException {
        getDrzavaIDQuery.setInt(1, id);
        ResultSet res = getDrzavaIDQuery.executeQuery();
        res.next();
            return res.getString(2);
        //return null;
    }
}

