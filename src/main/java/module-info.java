module com.ecodeup.jdbc.poofx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens com.ecodeup.jdbc.poofx to javafx.fxml;
    exports com.ecodeup.jdbc.poofx;
}