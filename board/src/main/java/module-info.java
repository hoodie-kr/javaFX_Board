module com.team3 {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;
    
    opens com.team3 to javafx.base, javafx.graphics, javafx.fxml;
    opens com.team3.Controller to javafx.fxml;
    opens com.team3.DTO to javafx.base;
    
    exports com.team3;
}
