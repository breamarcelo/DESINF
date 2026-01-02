module com.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens com.javafx to javafx.fxml;
    exports com.javafx;
}
