// Juego.java
package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Juego {
    // Lista de preguntas del juego
    private List<Pregunta> preguntas;
    // Índice de la pregunta actual
    private int indicePreguntaActual;
    // Indica si el juego ha terminado
    private boolean juegoTerminado;
    // Número de vidas del jugador
    private int vidas;

    // Constructor de la clase Juego
    public Juego() {
        // Inicializa la lista de preguntas
        preguntas = new ArrayList<>();
        // Agrega las preguntas y respuestas al juego
        preguntas.add(new Pregunta(
            "¿Cuál es la salida de 'System.out.println(2 + 2);'?", 
            Arrays.asList("3", "4", "22", "5"), 
            "4",
            "Estás en la primera habitación, llena de libros de programación. En el centro, hay una computadora antigua con una pantalla verde. La pregunta aparece en la pantalla, y debes responder correctamente para avanzar."
        ));
        preguntas.add(new Pregunta(
            "¿Qué palabra clave se utiliza para crear una subclase en Java?", 
            Arrays.asList("implement", "extends", "inherits", "subclass"), 
            "extends",
            "La siguiente habitación es un laboratorio de código. Hay pizarras blancas llenas de diagramas de clases y jerarquías de herencia. La pregunta está escrita en una de las pizarras."
        ));
        preguntas.add(new Pregunta(
            "¿Cuál es el método principal en una aplicación Java?", 
            Arrays.asList("start", "begin", "main", "init"), 
            "main",
            "Te encuentras en una sala de servidores. Los servidores zumban y parpadean con luces LED. Un monitor muestra la pregunta que debes responder para seguir adelante."
        ));
        preguntas.add(new Pregunta(
            "¿Qué estructura de control se usa para iterar un número fijo de veces?", 
            Arrays.asList("while", "do-while", "for", "if"), 
            "for",
            "Esta habitación parece un aula de clases, con escritorios y computadoras. En la pizarra digital, aparece la pregunta. Los recuerdos de las clases de programación vuelven a tu mente."
        ));
        preguntas.add(new Pregunta(
            "¿Qué palabra clave se usa para definir una constante en Java?", 
            Arrays.asList("const", "static", "final", "immutable"), 
            "final",
            "Ahora estás en una biblioteca de software. Hay estanterías llenas de manuales y documentación. La pregunta está impresa en una hoja de papel sobre la mesa central."
        ));
        preguntas.add(new Pregunta(
            "¿Cómo se llama el proceso de convertir un objeto de una clase a otra clase relacionada?", 
            Arrays.asList("boxing", "unboxing", "casting", "wrapping"), 
            "casting",
            "La última habitación es una sala de pruebas de software. Monitores y teclados están conectados a múltiples dispositivos para pruebas de compatibilidad. La pregunta final se muestra en una gran pantalla en la pared."
        ));
        // Inicializa el índice de la pregunta actual
        indicePreguntaActual = 0;
        // Inicializa la variable que indica si el juego ha terminado
        juegoTerminado = false;
        // Inicializa el número de vidas del jugador
        vidas = 3; 
    }

    // Obtiene la pregunta actual
    public Pregunta getPreguntaActual() {
        // Verifica si aún hay preguntas por responder
        if (indicePreguntaActual < preguntas.size()) {
            return preguntas.get(indicePreguntaActual);
        } else {
            return null;
        }
    }

    // Método para responder a una pregunta
    public boolean responderPregunta(String respuesta) {
        // Obtiene la pregunta actual
        Pregunta pregunta = getPreguntaActual();
        // Verifica si la pregunta existe y la respuesta es correcta
        if (pregunta != null && pregunta.esRespuestaCorrecta(respuesta)) {
            // Avanza al siguiente índice de pregunta
            indicePreguntaActual++;
            // Verifica si todas las preguntas han sido respondidas
            if (indicePreguntaActual >= preguntas.size()) {
                juegoTerminado = true;
            }
            // Devuelve verdadero si la respuesta es correcta
            return true;
        } else {
            // Decrementa el número de vidas
            vidas--;
            // Verifica si el jugador ha perdido todas las vidas
            if (vidas <= 0) {
                juegoTerminado = true;
            }
            // Devuelve falso si la respuesta es incorrecta
            return false;
        }
    }

    // Verifica si el juego ha terminado
    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    // Obtiene el número de vidas restantes del jugador
    public int getVidas() {
        return vidas;
    }

    // Obtiene el índice de la pregunta actual
    public int getIndicePreguntaActual() {
        return indicePreguntaActual;
    }
}
