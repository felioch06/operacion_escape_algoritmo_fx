package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Vista {
    private Stage stage;
    private Label lblPregunta;
    private List<Button> opciones;
    private Label lblResultado;
    private Label lblVidas;
    private Label lblTiempo;
    private Label lblHabitacion; // Label para mostrar el número de habitación

    public Vista(Stage stage) {
        this.stage = stage;
        lblPregunta = new Label();
        opciones = new ArrayList<>();
        lblResultado = new Label();
        lblVidas = new Label();
        lblTiempo = new Label();
        lblHabitacion = new Label(); // Inicializamos el Label de habitación

        VBox layout = new VBox(10, lblHabitacion, lblPregunta, lblVidas, lblTiempo, lblResultado); // Añadimos lblHabitacion al layout
        layout.setPadding(new Insets(20));

        for (int i = 0; i < 4; i++) {
            Button opcion = new Button();
            opciones.add(opcion);
            layout.getChildren().add(opcion);
        }

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Escape Room de Programación");
    }

    public Stage getStage() {
        return stage;
    }

    public Label getLblPregunta() {
        return lblPregunta;
    }

    public List<Button> getOpciones() {
        return opciones;
    }

    public Label getLblResultado() {
        return lblResultado;
    }

    public Label getLblVidas() {
        return lblVidas;
    }

    public Label getLblTiempo() {
        return lblTiempo;
    }

    public Label getLblHabitacion() {
        return lblHabitacion;
    }

    public void mostrar() {
        stage.show();
    }
}
