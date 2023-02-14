module eus.ehu.dbformula1fx_lab12 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens eus.ehu.dbformula1fx_lab12 to javafx.fxml;
    exports eus.ehu.dbformula1fx_lab12;
}