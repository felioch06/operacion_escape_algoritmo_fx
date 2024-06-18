package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Juego juego = new Juego();
        Vista vista = new Vista(primaryStage);
        new Controlador(juego, vista);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
