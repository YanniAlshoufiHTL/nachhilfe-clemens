module herbstpruefung.uebung.characterlistnew {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jshell;
    requires java.desktop;
    requires java.sql;


    opens herbstpruefung.uebung.characterlistnew to javafx.fxml;
    exports herbstpruefung.uebung.characterlistnew;
    exports herbstpruefung.uebung.characterlistnew.view;
    opens herbstpruefung.uebung.characterlistnew.view to javafx.fxml;
    exports herbstpruefung.uebung.characterlistnew.view.exceptions;
    opens herbstpruefung.uebung.characterlistnew.view.exceptions to javafx.fxml;
}