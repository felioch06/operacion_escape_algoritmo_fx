// Controlador.java
package application;

import java.util.List;

import javafx.scene.control.Button;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Controlador {
    // Referencia al juego
    private Juego juego;
    // Referencia a la vista
    private Vista vista;
    // Temporizador para el juego
    private Timeline timeline;
    // Tiempo restante en segundos
    private int tiempoRestante;

    // Constructor de la clase Controlador
    public Controlador(Juego juego, Vista vista) {
        this.juego = juego;
        this.vista = vista;
        tiempoRestante = 60; // 60 segundos
        inicializarVista();
        inicializarTemporizador();
    }

    // Inicializa la vista del juego
    private void inicializarVista() {
        // Muestra la pregunta actual, vidas, tiempo, habitación y la historia relacionada
        mostrarPreguntaActual();
        actualizarVidas();
        actualizarTiempo();
        actualizarHabitacion();
        actualizarHistoria();

        // Configura los eventos para cada opción de respuesta
        for (Button opcion : vista.getOpciones()) {
            opcion.setOnAction(event -> {
                String respuesta = opcion.getText();
                if (juego.responderPregunta(respuesta)) {
                    if (juego.isJuegoTerminado()) {
                        vista.getTxtResultado().setText("¡Felicidades, has logrado escapar!");
                        deshabilitarOpciones();
                        detenerTemporizador();
                    } else {
                        mostrarPreguntaActual();
                        actualizarVidas();
                        actualizarHabitacion();
                        actualizarHistoria();
                        vista.getTxtResultado().setText("Respuesta correcta. Sigue así!");
                    }
                } else {
                    if (juego.isJuegoTerminado()) {
                        vista.getTxtResultado().setText("Juego terminado. Te has quedado sin vidas.");
                        deshabilitarOpciones();
                        detenerTemporizador();
                    } else {
                        actualizarVidas();
                        vista.getTxtResultado().setText("Respuesta incorrecta. Intenta de nuevo.");
                    }
                }
            });
        }

        // Muestra la vista
        vista.mostrar();
    }

    // Muestra la pregunta actual en la vista
    private void mostrarPreguntaActual() {
        Pregunta pregunta = juego.getPreguntaActual();
        if (pregunta != null) {
            vista.getTxtPregunta().setText(pregunta.getPregunta());
            List<String> opciones = pregunta.getOpciones();
            for (int i = 0; i < vista.getOpciones().size(); i++) {
                vista.getOpciones().get(i).setText(opciones.get(i));
            }
        }
    }

    // Actualiza la cantidad de vidas en la vista
    private void actualizarVidas() {
        vista.getTxtVidas().setText("Vidas restantes: " + juego.getVidas());
    }

    // Actualiza el tiempo restante en la vista
    private void actualizarTiempo() {
        vista.getTxtTiempo().setText("Tiempo restante: " + tiempoRestante + "s");
    }

    // Actualiza la habitación actual en la vista
    private void actualizarHabitacion() {
        vista.getTxtHabitacion().setText("Habitación: " + (juego.getIndicePreguntaActual() + 1));
    }

    // Actualiza la historia relacionada con la pregunta actual en la vista
    private void actualizarHistoria() {
        Pregunta pregunta = juego.getPreguntaActual();
        if (pregunta != null) {
            vista.getTxtHistoria().setText(pregunta.getHistoria());
        }
    }

    // Inicializa el temporizador del juego
    private void inicializarTemporizador() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            tiempoRestante--;
            actualizarTiempo();
            if (tiempoRestante <= 0) {
                juegoTerminadoPorTiempo();
                detenerTemporizador();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    // Detiene el temporizador del juego
    private void detenerTemporizador() {
        if (timeline != null) {
            timeline.stop();
        }
    }

    // Termina el juego por falta de tiempo
    private void juegoTerminadoPorTiempo() {
        vista.getTxtResultado().setText("Juego terminado. Se acabó el tiempo.");
        deshabilitarOpciones();
        juegoTerminado();
    }

    // Deshabilita las opciones de respuesta en la vista
    private void deshabilitarOpciones() {
        for (Button opcion : vista.getOpciones()) {
            opcion.setDisable(true);
        }
    }

    // Termina el juego
    private void juegoTerminado() {
        juego.responderPregunta("");
    }
}
