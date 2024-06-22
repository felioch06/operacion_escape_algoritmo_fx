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
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;


public class Vista {
    // Referencia al stage de la ventana
    private Stage stage;
    // Texto para mostrar la pregunta
    private Text txtPregunta;
    // Lista de botones para las opciones de respuesta
    private List<Button> opciones;
    // Texto para mostrar el resultado de la respuesta
    private Text txtResultado;
    // Texto para mostrar la cantidad de vidas restantes
    private Text txtVidas;
    // Texto para mostrar el tiempo restante
    private Text txtTiempo;
    // Texto para mostrar la habitación actual
    private Text txtHabitacion;
    // Texto para mostrar la historia relacionada con la pregunta
    private Text txtHistoria;
    
    // Constructor de la clase Vista
    public Vista(Stage stage) {
        this.stage = stage;
        // Inicializa los componentes de la vista
        txtPregunta = new Text();
        opciones = new ArrayList<>();
        txtResultado = new Text();
        txtVidas = new Text();
        txtTiempo = new Text();
        txtHabitacion = new Text();
        txtHistoria = new Text(); 

        // Crea el diseño de la ventana
        VBox layout = new VBox(10, txtHabitacion, txtHistoria, txtPregunta, txtVidas, txtTiempo, txtResultado);
        layout.setPadding(new Insets(20));
        
        // Insertar imagen de fondo
        Image backgroundImage = new Image("file:src/images/imagen_fondo.png");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background backgroundObj = new Background(background);
        layout.setBackground(backgroundObj);
        

        // Crea botones para las opciones de respuesta y los agrega al diseño
        for (int i = 0; i < 4; i++) {
            Button opcion = new Button();
            opcion.getStyleClass().add("boton-opcion"); // Asigna la clase CSS aquí
            opciones.add(opcion);
            layout.getChildren().add(opcion);
        }

        // Crea la escena con el diseño y establece el tamaño de la ventana
        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        
        // Añade aquí la referencia al archivo CSS
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        txtPregunta.getStyleClass().add("pregunta");
        txtHistoria.getStyleClass().add("historia");
        txtHabitacion.getStyleClass().add("habitacion");
        txtVidas.getStyleClass().add("vidas");
        txtResultado.getStyleClass().add("resultado");
        txtTiempo.getStyleClass().add("tiempo");
        
        // Establece el título de la ventana
        stage.setTitle("Operacion Escape Algoritmo");
        
        // Configuración de la posición y tamaño de la ventana
        stage.setX(0);
        stage.setY(0);
        stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
        
    }

    // Método para obtener el stage de la ventana
    public Stage getStage() {
        return stage;
    }

    // Método para obtener el texto de la pregunta
    public Text getTxtPregunta() {
        return txtPregunta;
    }

    // Método para obtener la lista de botones de opciones
    public List<Button> getOpciones() {
        return opciones;
    }

    // Método para obtener el texto del resultado
    public Text getTxtResultado() {
        return txtResultado;
    }

    // Método para obtener el texto de las vidas restantes
    public Text getTxtVidas() {
        return txtVidas;
    }

    // Método para obtener el texto del tiempo restante
    public Text getTxtTiempo() {
        return txtTiempo;
    }

    // Método para obtener el texto de la habitación actual
    public Text getTxtHabitacion() {
        return txtHabitacion;
    }

    // Método para obtener el texto de la historia relacionada con la pregunta
    public Text getTxtHistoria() {
        return txtHistoria;
    }

    // Método para mostrar la ventana
    public void mostrar() {
        stage.show();
    }
}
