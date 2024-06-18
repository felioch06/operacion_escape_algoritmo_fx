// Controlador.java
package application;

import java.util.List;

import javafx.scene.control.Button;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Controlador {
    private Juego juego;
    private Vista vista;
    private Timeline timeline;
    private int tiempoRestante;

    public Controlador(Juego juego, Vista vista) {
        this.juego = juego;
        this.vista = vista;
        tiempoRestante = 60; // 60 segundos
        inicializarVista();
        inicializarTemporizador();
    }

    private void inicializarVista() {
        mostrarPreguntaActual();
        actualizarVidas();
        actualizarTiempo();
        actualizarHabitacion();
        actualizarHistoria();

        for (Button opcion : vista.getOpciones()) {
            opcion.setOnAction(event -> {
                String respuesta = opcion.getText();
                if (juego.responderPregunta(respuesta)) {
                    if (juego.isJuegoTerminado()) {
                        vista.getTxtResultado().setText("¡Felicidades, has completado el juego!");
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

        vista.mostrar();
    }

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

    private void actualizarVidas() {
        vista.getTxtVidas().setText("Vidas restantes: " + juego.getVidas());
    }

    private void actualizarTiempo() {
        vista.getTxtTiempo().setText("Tiempo restante: " + tiempoRestante + "s");
    }

    private void actualizarHabitacion() {
        vista.getTxtHabitacion().setText("Habitación: " + (juego.getIndicePreguntaActual() + 1));
    }

    private void actualizarHistoria() {
        Pregunta pregunta = juego.getPreguntaActual();
        if (pregunta != null) {
            vista.getTxtHistoria().setText(pregunta.getHistoria());
        }
    }

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

    private void detenerTemporizador() {
        if (timeline != null) {
            timeline.stop();
        }
    }

    private void juegoTerminadoPorTiempo() {
        vista.getTxtResultado().setText("Juego terminado. Se acabó el tiempo.");
        deshabilitarOpciones();
        juegoTerminado();
    }

    private void deshabilitarOpciones() {
        for (Button opcion : vista.getOpciones()) {
            opcion.setDisable(true);
        }
    }

    private void juegoTerminado() {
        juego.responderPregunta(""); // Marcar el juego como terminado
    }
}
