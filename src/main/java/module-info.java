module com.example.nicolasvicente_comp101130899finalexam {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.nicolasvicente_comp101130899finalexam to javafx.fxml;
    exports com.example.nicolasvicente_comp101130899finalexam;
}