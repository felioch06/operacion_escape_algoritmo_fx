package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    // Método start que se llama al iniciar la aplicación
    @Override
    public void start(Stage primaryStage) {
        // Crea una instancia del juego
        Juego juego = new Juego();
        // Crea una instancia de la vista y le pasa el primaryStage
        Vista vista = new Vista(primaryStage);
        // Crea una instancia del controlador y le pasa el juego y la vista
        new Controlador(juego, vista);
    }
    
    // Método main, punto de entrada de la aplicación
    public static void main(String[] args) {
        // Lanza la aplicación
        launch(args);
    }
}
