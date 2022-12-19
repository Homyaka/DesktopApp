module com.example.desktopapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.postgresql.jdbc;

    opens com.example.desktopapp to javafx.fxml;
    opens com.example.desktopapp.classesForTables;
    exports com.example.desktopapp;
}