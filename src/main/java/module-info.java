module com.example.lv7z1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens ba.etf.rpr to javafx.fxml;
    exports ba.etf.rpr;
}