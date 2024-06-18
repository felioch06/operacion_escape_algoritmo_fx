package application;

import java.util.List;

public class Pregunta {
    // La pregunta misma
    private String pregunta;
    // Lista de opciones de respuesta
    private List<String> opciones;
    // Respuesta correcta a la pregunta
    private String respuestaCorrecta;
    // Descripción histórica relacionada con la pregunta
    private String historia;

    // Constructor de la clase Pregunta
    public Pregunta(String pregunta, List<String> opciones, String respuestaCorrecta, String historia) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.historia = historia;
    }

    // Método para obtener la pregunta
    public String getPregunta() {
        return pregunta;
    }

    // Método para obtener las opciones de respuesta
    public List<String> getOpciones() {
        return opciones;
    }

    // Método para verificar si la respuesta dada es correcta
    public boolean esRespuestaCorrecta(String respuesta) {
        // Ignora el caso y elimina los espacios al principio y al final de la respuesta
        return respuestaCorrecta.equalsIgnoreCase(respuesta.trim());
    }

    // Método para obtener la descripción histórica relacionada con la pregunta
    public String getHistoria() {
        return historia;
    }
}
