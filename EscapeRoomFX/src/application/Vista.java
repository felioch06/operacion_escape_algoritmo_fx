package application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Vista {
    private Stage stage;
    private Text txtPregunta;
    private List<Button> opciones;
    private Text txtResultado;
    private Text txtVidas;
    private Text txtTiempo;
    private Text txtHabitacion;
    private Text txtHistoria;

    public Vista(Stage stage) {
        this.stage = stage;
        txtPregunta = new Text();
        opciones = new ArrayList<>();
        txtResultado = new Text();
        txtVidas = new Text();
        txtTiempo = new Text();
        txtHabitacion = new Text();
        txtHistoria = new Text(); 

        VBox layout = new VBox(10, txtHabitacion, txtHistoria, txtPregunta, txtVidas, txtTiempo, txtResultado); // Añadimos txtHistoria al layout
        layout.setPadding(new Insets(20));

        for (int i = 0; i < 4; i++) {
            Button opcion = new Button();
            opciones.add(opcion);
            layout.getChildren().add(opcion);
        }

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Operacion Escape Algoritmo");
        
        stage.setX(0);
        stage.setY(0);
        stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
    }

    public Stage getStage() {
        return stage;
    }

    public Text getTxtPregunta() {
        return txtPregunta;
    }

    public List<Button> getOpciones() {
        return opciones;
    }

    public Text getTxtResultado() {
        return txtResultado;
    }

    public Text getTxtVidas() {
        return txtVidas;
    }

    public Text getTxtTiempo() {
        return txtTiempo;
    }

    public Text getTxtHabitacion() {
        return txtHabitacion;
    }

    public Text getTxtHistoria() {
        return txtHistoria;
    }

    public void mostrar() {
        stage.show();
    }
}

