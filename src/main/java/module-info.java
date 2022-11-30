module com.franprados.ProyectoCarrera {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;

    opens com.franprados.ProyectoCarrera to javafx.fxml;
    exports com.franprados.ProyectoCarrera;
}
