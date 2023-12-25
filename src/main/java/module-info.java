module ba.etf.rpr.lv9z2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ba.etf.rpr.lv9z2 to javafx.fxml;
    exports ba.etf.rpr.lv9z2;
}