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

