module org.jrc.gerenciador {
    requires javafx.controls;
    requires javafx.fxml;

    requires transitive javafx.graphics;
    requires javafx.base;
    requires java.sql;

    opens org.jrc.gerenciador to javafx.fxml;
    exports org.jrc.gerenciador;
}