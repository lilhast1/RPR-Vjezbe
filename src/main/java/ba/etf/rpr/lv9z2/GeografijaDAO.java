package ba.etf.rpr.lv9z2;

//import com.almasb.fxgl.net.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeografijaDAO {
    public ObservableList<GradFX> getGradFXES() {
        return gradFXES;
    }

    public void setGradFXES(ObservableList<GradFX> gradFXES) {
        this.gradFXES = gradFXES;
    }

    private ObservableList<GradFX> gradFXES;
    private static GeografijaDAO instance;
    private Connection connection;
    private String url;
    private PreparedStatement gradoviQuery, glGradQuery, drzavaQuery, deleteDrzavaQuery, alterGradQuery,
            addGradQuery, addDrzavaQuery, getDrzavaIDQuery, sveQuery, findGrad, sveDrzave;
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
        drzavaQuery = connection.prepareStatement("SELECT id, Naziv, glavni_grad FROM drzave WHERE naziv = ?");
        deleteDrzavaQuery = connection.prepareStatement("DELETE FROM drzave WHERE naziv = ?");
        alterGradQuery = connection.prepareStatement("UPDATE gradovi SET naziv = ?, broj_stanovnika = ?," +
                " drzava = ? WHERE id = ?");
        addGradQuery = connection.prepareStatement("INSERT INTO gradovi(Naziv, broj_stanovnika, drzava) " +
                "VALUES (?,?,?)");
        addDrzavaQuery = connection.prepareStatement("INSERT INTO drzave(Naziv, glavni_grad) VALUES (?,?)");
        getDrzavaIDQuery = connection.prepareStatement("SELECT id, naziv, glavni_grad FROM drzave WHERE id = ?");
        sveQuery = connection.prepareStatement("SELECT g.id, g.naziv, " +
                "g.broj_stanovnika, d.naziv drzava from gradovi g, drzave d where g.drzava = d.id");
        findGrad = connection.prepareStatement("SELECT naziv from gradovi where naziv = ?");
        sveDrzave = connection.prepareStatement("SELECT * from drzave");
        gradFXES = getAll();
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
                    resultSet.getInt("id"), resultSet.getInt("broj_stanovnika"),
                    resultSet.getInt("drzava"), resultSet.getString("NazIv")
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

    public ObservableList<GradFX> getAll() throws SQLException {
        ObservableList<GradFX> gradObservableList = FXCollections.observableArrayList();
        ResultSet res = sveQuery.executeQuery();
        while (res.next()) {
            gradObservableList.add(new GradFX(res.getInt(1), res.getString(2),
                                res.getInt(3), res.getString(4)));

        }
        return gradObservableList;
    }

    public ObservableList<GradFX> gradoviFX() throws SQLException {
        ResultSet resultSet = sveQuery.executeQuery();
        ObservableList<GradFX> gradovi = FXCollections.observableArrayList();
        while (resultSet.next()) {
            gradovi.add(new GradFX(
                    resultSet.getInt("id"), resultSet.getString("NazIv"),
                    resultSet.getInt("broj_stanovnika"), resultSet.getString("drzava")
            ));
        }
        return gradovi;
    }

    public boolean findGrad(String naziv) throws SQLException {
        findGrad.setString(1, naziv);
        ResultSet r =  findGrad.executeQuery();
        return r.next();
    }

    public ObservableList<DrzavaFX> getDrzavaFXES() throws SQLException {
        ObservableList<DrzavaFX> drzavaFXES = FXCollections.observableArrayList();
        ResultSet res = sveDrzave.executeQuery();
        while(res.next()) {
            drzavaFXES.add(new DrzavaFX( res.getInt("id"), res.getInt("glavni_grad"),
                    res.getString("naziv")));
        }
        return drzavaFXES;
    }
}

