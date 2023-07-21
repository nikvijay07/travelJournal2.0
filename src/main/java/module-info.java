module com.example.traveljournalv2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.traveljournalv2 to javafx.fxml;
    exports com.example.traveljournalv2;
}