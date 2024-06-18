// Juego.java
package application;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Juego {
    private List<Pregunta> preguntas;
    private int indicePreguntaActual;
    private boolean juegoTerminado;
    private int vidas;

    public Juego() {
        preguntas = new ArrayList<>();
        preguntas.add(new Pregunta("¿Cuál es la salida de 'System.out.println(2 + 2);'?", 
            Arrays.asList("3", "4", "22", "5"), "4"));
        preguntas.add(new Pregunta("¿Qué palabra clave se utiliza para crear una subclase en Java?", 
            Arrays.asList("implement", "extends", "inherits", "subclass"), "extends"));
        preguntas.add(new Pregunta("¿Cuál es el método principal en una aplicación Java?", 
            Arrays.asList("start", "begin", "main", "init"), "main"));
        preguntas.add(new Pregunta("¿Qué estructura de control se usa para iterar un número fijo de veces?", 
            Arrays.asList("while", "do-while", "for", "if"), "for"));
        preguntas.add(new Pregunta("¿Qué palabra clave se usa para definir una constante en Java?", 
            Arrays.asList("const", "static", "final", "immutable"), "final"));
        preguntas.add(new Pregunta("¿Cómo se llama el proceso de convertir un objeto de una clase a otra clase relacionada?", 
            Arrays.asList("boxing", "unboxing", "casting", "wrapping"), "casting"));
        indicePreguntaActual = 0;
        juegoTerminado = false;
        vidas = 3; // Número inicial de vidas
    }

    public Pregunta getPreguntaActual() {
        if (indicePreguntaActual < preguntas.size()) {
            return preguntas.get(indicePreguntaActual);
        } else {
            return null;
        }
    }

    public boolean responderPregunta(String respuesta) {
        Pregunta pregunta = getPreguntaActual();
        if (pregunta != null && pregunta.esRespuestaCorrecta(respuesta)) {
            indicePreguntaActual++;
            if (indicePreguntaActual >= preguntas.size()) {
                juegoTerminado = true;
            }
            return true;
        } else {
            vidas--;
            if (vidas <= 0) {
                juegoTerminado = true;
            }
            return false;
        }
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    public int getVidas() {
        return vidas;
    }

    public int getIndicePreguntaActual() {
        return indicePreguntaActual;
    }
}